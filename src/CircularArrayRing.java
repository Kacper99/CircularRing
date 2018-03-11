import java.util.AbstractCollection;
import java.util.Iterator;

public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {

    private int ringSize, head, tail, elementCount;

    public CircularArrayRing() {
        this.ringSize = 10;
        head = tail = elementCount = 0;
    }

    public CircularArrayRing(int ringSize) {
        this.ringSize = ringSize;
        head = tail = elementCount = 0;
    }

    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index > ringSize || index > elementCount)
            throw new IndexOutOfBoundsException("Index out of bounds");

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
