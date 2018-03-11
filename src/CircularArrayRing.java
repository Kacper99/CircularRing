import java.util.AbstractCollection;
import java.util.Iterator;

public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {

    private int ringSize;

    public CircularArrayRing() {
        this.ringSize = 10;
    }

    public CircularArrayRing(int ringSize) {
        this.ringSize = ringSize;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
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
