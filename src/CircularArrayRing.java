import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {

    private static final int DEFAULT_RING_SIZE = 10; //Default size for the ring
    private int head, elementCount;
    private Object[] ringArray; //Used to store the objects.

    /**
     * This constructor sets the ring size to the default size
     */
    public CircularArrayRing() {
        this.ringArray = new Object[DEFAULT_RING_SIZE];
        elementCount = 0;
        head = -1;
    }

    /**
     * Allows for a custom ring size
     * @param ringSize number of elements to have in the ring
     */
    public CircularArrayRing(int ringSize) {
        this.ringArray = new Object[ringSize];
        elementCount = 0;
        head = -1;
    }

    /**
     * Adds an element to the ring
     * @param e the element ot add
     * @return whether the element has been added or not
     */
    @Override
    public boolean add(E e) {
        head++; //Increment the head by one
        if (head == ringArray.length)
            head = 0; //If we get to the end of the ring set the pointer to be 0 again to loop back round
        ringArray[head] = e; //Get the element
        if (elementCount < ringArray.length) //Increase the element count up until the length because at that point the number of elements cant change.
            elementCount++;
        return true;
    }

    /**
     * Gets an item from the ring
     * @param index The index of the ring to get
     * @return The item corresponding to that index
     * @throws IndexOutOfBoundsException Thrown if index is out of bounds
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {

        System.out.println(Arrays.toString(ringArray));
        if (index >= ringArray.length || index < 0) //Check if the index is within the bounds of the ring.
            throw new IndexOutOfBoundsException("Index out of bounds");

        int newIndex = head - index; //Adjust the index for the head position
        return (E) (newIndex < 0 ? ringArray[newIndex + ringArray.length] : ringArray[newIndex]); //If the newIndex is less than zero then add the length of the array to the index
    }

    /**
     * Creates an iterator for the ring. Iterates backwards around the ring.
     *
     * @return The iterator
     */
    @Override
    public Iterator<E> iterator() {

        Iterator<E> myIt = new Iterator<E>() {

            private int currIndex = head;

            @Override
            public boolean hasNext() {
                if (currIndex < ringArray.length && ringArray[currIndex] != null) { //Checking if we got to the end and if there are no null elements
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                if (!hasNext()) //If there isnt another element then throw an exception
                    throw new NoSuchElementException("No element");
                Object nextElement = ringArray[currIndex]; //Getting the next element
                currIndex--; //Decrease the current index by one
                if (currIndex < 0) //If we get to the beginning of the
                    currIndex = ringArray.length - 1;
                return (E) nextElement;
            }

            @Override
            public void remove() throws UnsupportedOperationException {
                throw new UnsupportedOperationException("Remove is not supported");
            }
        };
        return myIt;
    }

    @Override
    public int size() {
        return elementCount;
    }
}
