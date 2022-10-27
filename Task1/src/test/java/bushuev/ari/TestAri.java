package bushuev.ari;

import bushuev.ari.Ari;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tester.
 */
public class TestAri {
    @Test
    void testSumarry() {

        Ari cal = new Ari(10);
        cal.summ(5);
        Assertions.assertEquals(15, cal.getAccum());
        cal.sub(9);
        Assertions.assertEquals(6, cal.getAccum());
        cal.mult(2);
        Assertions.assertEquals(12, cal.getAccum());
        cal.saveAccum();
        cal.summ(11);
        Assertions.assertEquals(12, cal.getSaveAccum());
        Assertions.assertEquals("current: 23 saved: 12", cal.toString());

    }
}
