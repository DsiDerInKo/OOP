package bushuev.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
public class TestVector {

    Integer[] arr = new Integer[10];

    @Test
    void test() {
        Vector<Integer> vector = new Vector<>();


        vector.add(2);
        vector.add(7);
        vector.add(6);
        vector.add(14);
        Assertions.assertEquals(14, vector.get(vector.getCurSize() - 1));
        Assertions.assertEquals(2, vector.get(0));
        Assertions.assertEquals(7, vector.get(1));
        vector.popLast();
        Assertions.assertEquals(6, vector.get(vector.getCurSize() - 1));
        Assertions.assertEquals(3, vector.getCurSize());
        vector.popLast();
        vector.popLast();
        Assertions.assertEquals(2, vector.get(vector.getCurSize() - 1));
        vector.add(100);
        vector.set(200, vector.getCurSize() - 1);
        Assertions.assertEquals(200, vector.get(vector.getCurSize() - 1));
        vector.clear();
        Assertions.assertThrows(IllegalArgumentException.class, vector::popLast);
        Assertions.assertEquals(0, vector.getCurSize());
        var list = List.of(6, 1, 2, 5);
        vector.addAll(list);
        Assertions.assertEquals(5, vector.get(vector.getCurSize() - 1));
        int i = 0;
        for (Integer integer : list) {
            Assertions.assertEquals(integer, vector.get(i));
            i++;
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector.get(100));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Vector<>(-2));
        vector.add(4);
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector.get(-2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector.set(111, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector.set(111, 100));
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector.addAll(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector.popAll(null));

        vector.popAll(new ArrayList<>(Arrays.stream(arr).collect(Collectors.toList())));

    }
}
