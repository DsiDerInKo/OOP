package bushuev.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
public class TestStack {
    @Test
    void tesStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(200);
        stack.push(300);
        Assertions.assertEquals(300, stack.pop());
        Assertions.assertEquals(200, stack.pop());
        Assertions.assertEquals(100, stack.peek());

    }
}
