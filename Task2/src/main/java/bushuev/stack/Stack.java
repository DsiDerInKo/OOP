package bushuev.stack;

/**
 * Stack.
 *
 * @param <E> Type of Stack elements.
 */
public class Stack<E> {

    private final Vector<E> vector;

    /**
     * Constructor of Stack.
     */
    public Stack() {

        vector = new Vector<>();

    }

    /**
     * pushes an elem to Vector.
     *
     * @param elem elem to push.
     */
    public void push(E elem) {
        vector.add(elem);
    }

    /**
     * Pops last elem from Vector.
     *
     * @return popped element.
     */
    public E pop() {
        return vector.popLast();
    }

    /**
     * Peeks last element from Vector.
     *
     * @return peeked element.
     */
    public E peek() {
        return vector.get(vector.getCurSize() - 1);
    }

    /**
     * Useful.
     *
     * @return returns current stack size.
     */
    public int curSize() {
        return vector.getCurSize();
    }

    /**
     * Checks "is stack empty".
     *
     * @return true or false.
     */
    public boolean isEmpty() {
        return vector.getCurSize() == 0;
    }

}
