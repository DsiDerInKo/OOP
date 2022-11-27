package bushuev.stack;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList implements List {


    /**
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @param o element whose presence in this list is to be tested
     * @return
     */
    @Override
    public boolean contains(Object o) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * @param o element whose presence in this collection is to be ensured
     * @return
     */
    @Override
    public boolean add(Object o) {
        return false;
    }

    /**
     * @param o element to be removed from this list, if present
     * @return
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     * @param c collection containing elements to be added to this collection
     * @return
     */
    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    /**
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c     collection containing elements to be added to this list
     * @return
     */
    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    /**
     *
     */
    @Override
    public void clear() {

    }

    /**
     * @param index index of the element to return
     * @return
     */
    @Override
    public Object get(int index) {
        return null;
    }

    /**
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return
     */
    @Override
    public Object set(int index, Object element) {
        return null;
    }

    /**
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, Object element) {

    }

    /**
     * @param index the index of the element to be removed
     * @return
     */
    @Override
    public Object remove(int index) {
        return null;
    }

    /**
     * @param o element to search for
     * @return
     */
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    /**
     * @param o element to search for
     * @return
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public ListIterator listIterator() {
        return null;
    }

    /**
     * @param index index of the first element to be returned from the
     *              list iterator (by a call to {@link ListIterator#next next})
     * @return
     */
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    /**
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return
     */
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * @param c collection containing elements to be retained in this list
     * @return
     */
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    /**
     * @param c collection containing elements to be removed from this list
     * @return
     */
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    /**
     * @param c collection to be checked for containment in this list
     * @return
     */
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return
     */
    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}