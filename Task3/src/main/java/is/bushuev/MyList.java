package is.bushuev;

import java.util.*;

public class MyList<E> implements Collection<E> {
    private int listSize = 0;
    private final Node head;

    public MyList() {
        head = new Node();
    }

    private class Node {

        E value;
        Node prev;
        Node next;

        public Node() {
            prev = this;
            next = this;
        }

        public Node(E elem) {
            value = elem;
            prev = this;
            next = this;
        }
    }
        private void addAfter(Node self, E newValue) {

            Node newNode = new Node(newValue);
            newNode.prev = self;
            newNode.next = self.next;
            self.next.prev = newNode;
            self.next = newNode;

        }

        private void addBefore(Node self, E newValue) {

            Node newNode = new Node(newValue);
            newNode.next = self;
            newNode.prev = self.prev;
            self.prev.next = newNode;
            self.prev = newNode;


        }

        public E removeElem(Node self) {
            self.prev.next = self.next;
            self.next.prev = self.prev;

            return self.value;
        }



    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */

    public int size() {

        return listSize;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */

    public boolean isEmpty() {
        return listSize == 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */

    public boolean contains(Object o) {
        return this.stream().anyMatch((elem) -> o.equals(elem));
        //return indexOf(o) > 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */

    public Iterator<E> iterator() {

        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {

        private Node current = head;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current.next != current;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            current = current.next;

            return current.value;
        }

        @Override
        public void remove() {
            removeElem(current);
        }
    }

    /**
     * Returns an array containing all the elements in this list in proper
     * sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must
     * allocate a new array even if this list is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all the elements in this list in proper
     * sequence
     * @see Arrays#asList(Object[])
     */

    public Object[] toArray() {
        Object[] result = new Object[listSize];
        int i = 0;
        //for (MyList.Node<E> x = head; x.next != head; x = x.next)
        //    result[i++] = x.value;

        for (E elem : this) {
            result[i++] = elem;
        }

        return result;
        //
    }

    /**
     * Returns an array containing all the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     *
     * <p>If this collection fits in the specified array with room to spare
     * (i.e., the array has more elements than this collection), the element
     * in the array immediately following the end of the collection is set to
     * {@code null}.  (This is useful in determining the length of this
     * collection <i>only</i> if the caller knows that this collection does
     * not contain any {@code null} elements.)
     *
     * <p>If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order.
     *
     * @param a the array into which the elements of this collection are to be
     *          stored, if it is big enough; otherwise, a new array of the same
     *          runtime type is allocated for this purpose.
     * @return an array containing all the elements in this collection
     * @throws ArrayStoreException  if the runtime type of any element in this
     *                              collection is not assignable to the {@linkplain Class#getComponentType
     *                              runtime component type} of the specified array
     * @throws NullPointerException if the specified array is nul.
     * It allows an existing array to be reused under certain circumstances.
     * Use {@link #toArray()} to create an array whose runtime type is {@code Object[]}
     *
     *
     * <p>Suppose {@code x} is a collection known to contain only strings.
     * The following code can be used to dump the collection into a previously
     * allocated {@code String} array:
     *
     * <pre>
     *     String[] y = new String[SIZE];
     *     ...
     *     y = x.toArray(y);</pre>
     *
     * <p>The return value is reassigned to the variable {@code y}, because a
     * new array will be allocated and returned if the collection {@code x} has
     * too many elements to fit into the existing array {@code y}.
     *
     * <p>Note that {@code toArray(new Object[0])} is identical in function to
     * {@code toArray()}.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (listSize <= a.length) {
            int i = 0;
            var iter = iterator();
            while (iter.hasNext()) {
                a[i] = (T) iter.next();
            }
        }
        return null;
    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param o element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the {@code add} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */

    public boolean add(E o) {
        addBefore(head, o);
        listSize++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this list
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the {@code remove} operation
     *                                       is not supported by this list
     */

    public boolean remove(Object o) {
        //int i = 0;
        //Node node = head;

        var iter = iterator();
        while (iter.hasNext()) {
            if (iter.next() == o) iter.remove();
        }
        listSize--;
        return contains(o);
    }

    /**
     * Appends all the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.  (Note that this will occur if the
     * specified collection is this list, and it's nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified
     *                                       collection prevents it from being added to this list
     * @throws NullPointerException          if the specified collection contains one
     *                                       or more null elements and this list does not permit null
     *                                       elements, or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the
     *                                       specified collection prevents it from being added to this list
     * @see #add(Object)
     */

    public boolean addAll(Collection c) {
        var iter = iterator();
        while (iter.hasNext()) {
            c.add(iter.next());
        }
        return true;
    }


    /**
     * Removes all the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this list
     */

    public void clear() {
        var iter = iterator();
        while (iter.hasNext()) {
            iter.remove();
        }
        listSize = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */

    public E get(int index) {

        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        int i = 0;
        for (E e : this) {
            if (i == index) return e;
            else i++;
        }

        return null;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code set} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */

    public Object set(int index, Object element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        int i = 0;
        Node node = head.next;

        while (i != (index)) {
            i++;
            node = node.next;
        }
        //addAfter(node, (E) element);
        E prevElem = node.value;
        node.value = (E) element;

        return prevElem;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the {@code add} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     */

    public void add(int index, Object element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        int i = 0;
        Node node = head;

        while (i != (index)) {
            i++;
            node = node.next;
        }
        listSize++;
        addAfter(node, (E) element);
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code remove} operation
     *                                       is not supported by this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */

    public E remove(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        int i = 0;
        Node node = head.next;

        while (i != (index)) {
            i++;
            node = node.next;
        }
        listSize--;
        return removeElem(node);
    }
//
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */

    public int indexOf(Object o) {
        int i = 0;
        Node node = head.next;

        while (node.value != o) {
            i++;
            node = node.next;
        }

        return i;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */

    public int lastIndexOf(Object o) {
        int i = 0;
        int lastInd;
        Node node = head.next;

        while (node.next != head) {
            if (node.value == o) lastInd = i;
            i++;
            node = node.next;
        }

        return 0;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation).  In other words, removes
     * from this list all of its elements that are not contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code retainAll} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of this list
     *                                       is incompatible with the specified collection
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the
     *                                       specified collection does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */

    public boolean retainAll(Collection c) {
        var iter = iterator();
        while (iter.hasNext()) {
            if (!c.contains(iter.next())) iter.remove();
        }

        return true;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code removeAll} operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of this list
     *                                       is incompatible with the specified collection
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the
     *                                       specified collection does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */

    public boolean removeAll(Collection c) {
        var iter = iterator();
        while (iter.hasNext()) {
            if (c.contains(iter.next())) iter.remove();
        }

        return false;
    }

    /**
     * Returns {@code true} if this list contains all the elements of the
     * specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return {@code true} if this list contains all the elements of the
     * specified collection
     * @throws ClassCastException   if the types of one or more elements
     *                              in the specified collection are incompatible with this
     *                              list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one
     *                              or more null elements and this list does not permit null
     *                              elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>),
     *                              or if the specified collection is null
     * @see #contains(Object)
     */

    public boolean containsAll(Collection c) {
        var iter = iterator();
        while (iter.hasNext()) {
            if (!c.contains(iter.next())) return false;
        }
        return true;
    }

}