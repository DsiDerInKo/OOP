package is.bushuev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import is.bushuev.MyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class TestMyList {

    private static boolean checker(Collection<?> list1, Collection<?> list2) {
        Iterator<?> iter1 = list1.iterator();
        Iterator<?> iter2 = list2.iterator();

        while (iter2.hasNext() && iter1.hasNext()) {
            if (!Objects.equals(iter1.next(), iter2.next())) return false;
        }

        return !(iter2.hasNext() || iter1.hasNext());
    }

    @Test
    void testFunctions() {
        MyList<Integer> list1 = new MyList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<>();

        Assertions.assertEquals(2, 1 + 1);

        list1.add(12);
        list1.add(13);
        list1.add(14);

        list2.add(12);
        list2.add(13);
        list2.add(14);

        Assertions.assertTrue(checker(list1, list2));



    }

}
