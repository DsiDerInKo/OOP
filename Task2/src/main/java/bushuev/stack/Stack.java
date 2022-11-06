package bushuev.stack;


public class Stack<E> {

    private final Vector<E> vector;

    public Stack() {

        vector = new Vector<E>();

    }

    public void push(E elem) {
        vector.add(elem);
    }

    public E pop() {
        return vector.popLast();
    }

    public E peek() {
        return vector.get(vector.getCurSize());
    }

}
