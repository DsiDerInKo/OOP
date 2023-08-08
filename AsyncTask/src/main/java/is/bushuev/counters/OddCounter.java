package is.bushuev.counters;

class OddCounter implements Runnable {

    int amount = 0;
    int[] array;

    OddCounter(int[] array) {
        this.array = array;
    }

    public void run() {
        for (int j : array) {
            if (j % 2 == 1) {
                amount++;
            }
        }
    }
}
