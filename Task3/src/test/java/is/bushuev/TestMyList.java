package is.bushuev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TestMyList {

    private static boolean checker(Collection<Integer> list1, Collection<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }


        Iterator<Integer> iter1 = list1.iterator();
        Iterator<Integer> iter2 = list2.iterator();

        while (iter2.hasNext() && iter1.hasNext()) {
            if (!Objects.equals(iter1.next(), iter2.next())) return false;
        }

        return !(iter2.hasNext() || iter1.hasNext());
    }

    @Test
    void testFunctions() {
        MyList<Integer> list1 = new MyList<>();

        List<Integer> list = List.of(12, 13, 14, 20);
        LinkedList<Integer> list2 = new LinkedList<>(list);

        list1.add(12);
        list1.add(13);
        list1.add(14);
        list1.add(20);

        Assertions.assertTrue(checker(list1, list2));

        list1.add(1, 100);
        list2.add(1, 100);

        list1.remove(2);
        list2.remove(2);

        Assertions.assertTrue(checker(list1, list2));

        list1.remove();
        list2.remove();

        Assertions.assertTrue(checker(list1, list2));

        Assertions.assertEquals(3, list1.size());
        Assertions.assertFalse(list1.isEmpty());

        list1.clear();
        list2.clear();

        Assertions.assertTrue(checker(list1, list2));

        list1.add(100);
        list2.add(100);

        Assertions.assertTrue(list1.contains(100));

        Object num = 100;
        list1.remove(num);
        list2.remove(num);

        Object elem = 123456;
        list1.remove(elem);

        Assertions.assertTrue(checker(list1, list2));

        list1.addAll(list2);
        list2.addAll(list1);

        Assertions.assertTrue(checker(list1, list2));

        list1.clear();
        list2.clear();
        Assertions.assertFalse(list1.remove());

        Iterator<Integer> iter = list1.iterator();
        Assertions.assertThrows(NoSuchElementException.class, iter::next);

        Assertions.assertTrue(list1.isEmpty());

        list1.add(1);
        list1.add(3);
        list1.add(2);
        list2.add(1);
        list2.add(3);
        list2.add(2);

        Assertions.assertEquals(3, list1.get(1));
        Assertions.assertEquals(1, list1.get(0));

        //num = 666;

        list1.set(0, 666);
        list2.set(0, 666);

        Assertions.assertTrue(checker(list1, list2));

        Assertions.assertEquals(0, list1.indexOf(666));

        list1.add(666);
        list2.add(666);

        Assertions.assertEquals(3, list1.lastIndexOf(666));

        Assertions.assertTrue(list1.containsAll(list2));

        list1.retainAll(list2);

        Assertions.assertTrue(checker(list1, list2));

        list1.removeAll(list2);
        list2.retainAll(list1);

        Assertions.assertTrue(checker(list1, list2));

        list1.add(1);
        list1.add(3);
        list1.add(2);
        list2.add(1);
        list2.add(3);
        list2.add(2);

        Integer[] array = new Integer[10];
        list1.toArray(array);

        Assertions.assertTrue(list1.toArray().length > 0);

        Assertions.assertEquals(2, array[2]);

        list1.addAll(list2);
        list2.add(1);
        list2.add(3);
        list2.add(2);

        Assertions.assertFalse(list1.isEmpty());
        Assertions.assertTrue(checker(list1, list2));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.get(1000));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.get(-1000));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.set(10000, 1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.set(-10000, 1));
        list1.set(2, 999);
        list2.set(2, 999);

        Assertions.assertTrue(checker(list1, list2));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.add(10000, 1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.add(-10000, 1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(10000));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(-10000));

        Assertions.assertEquals(2, list1.indexOf(999));

        Object nul = null;
        Object number = 98765;
        Assertions.assertThrows(NullPointerException.class, () -> list1.indexOf(nul));
        Assertions.assertThrows(NullPointerException.class, () -> list1.lastIndexOf(nul));

        Assertions.assertEquals(-1, list1.indexOf(number));

        list1.clear();
        list2.clear();

        list1.add(1);
        list1.add(2);
        list2.add(2);
        list2.add(3);
        list1.retainAll(list2);
        list2.remove();
    }

}
 