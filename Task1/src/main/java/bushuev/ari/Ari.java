package bushuev.ari;


/**
 * class of Accum.
 */
public class Ari {

    private int accum;
    private int saveAccum;

    /**
     * Saves current condition of accum to saveAccum.
     */
    public void saveAccum() {
        saveAccum = accum;
    }

    /**
     * Returns value of saveAccum.
     *
     * @return saveAccum
     */
    public int getSaveAccum() {
        return saveAccum;
    }

    /**
     * Constructor of Ari.
     *
     * @param num getted elem
     */
    public Ari(int num) {
        accum = num;
        saveAccum = accum;
    }

    /**
     * Summarizing current accum and entered num, putting the result into accum.
     *
     * @param num getted elem
     */
    public void summ(int num) {
        accum += num;
    }

    /**
     * Putting the result of substruction of accum and num into accum.
     *
     * @param num getted elem
     */
    public void sub(int num) {
        accum -= num;
    }

    /**
     * Putting the result of multiplication of accum and num into accum.
     *
     * @param num getted elem
     */
    public void mult(int num) {
        accum *= num;
    }

    /**
     * Returns value of current saveAccum.
     *
     * @return accum
     */
    public int getAccum() {
        return accum;
    }

    /**
     * Retuns value of accum and saveAccum in string format.
     * (would look like "current: accum saved: saceAccum")
     *
     * @return stringed
     */
    @Override
    public String toString() {
        return "current: " + accum + " saved: " + saveAccum;
    }
}
