package bushuev.stack;

import java.util.Arrays;
import java.util.Collection;

/**
 * @param <E>
 */
public class Vector<E> {

    private E[] array;
    private int curSize;

    /**
     *
     */
    public final static int DEFAULT_SIZE = 2;

    /**
     * @param startSize
     */
    @SuppressWarnings({"unchecked"})
    public Vector(int startSize) {
        if (startSize <= 0) {
            throw new IllegalArgumentException("Size is incorrect");
        }
        curSize = 0;
        array = (E[]) new Object[startSize];

    }

    /**
     *
     */
    public Vector() {

        this(DEFAULT_SIZE);

    }

    /**
     * @param size
     */
    private void resize(int size) {
        array = Arrays.copyOf(array, size);
    }

    /**
     *
     */
    private void grow() {
        resize(array.length * 2);
    }

    /**
     * @param elem
     */
    public void add(E elem) {
        if (curSize == array.length) {
            grow();
        }
        array[curSize++] = elem;
    }

    /**
     * @return
     */
    public E popLast() {
        if (curSize == 0) {
            throw new IllegalArgumentException("Array is empty, there is nothing to remove");
        }
        return array[curSize--];
    }

    /**
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Incorrect index");
        }
        return array[index];
    }

    /**
     * @param value
     * @param index
     */
    public void set(E value, int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Incorrect index");
        }
        array[index] = value;
    }

    public int getCurSize() {
        return curSize;
    }

    public void addAll(Collection<? extends E> elements) {

        for (E element : elements) {
            add(element);
        }

        //elements.stream().peek(this::add);

    }

}
