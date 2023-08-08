package is.bushuev.counters;

class EvenCounter implements Runnable {

    int amount = 0;
    int[] array;

    EvenCounter(int[] array) {
        this.array = array;
    }

    public void run() {
        for (int j : array) {
            if (j % 2 == 0) {
                amount++;
            }
        }
    }
}
