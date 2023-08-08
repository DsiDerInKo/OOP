package is.bushuev.counters;

class Counter implements Runnable {
    int evenAmount = 0, oddAmount = 0, part, partAmount;
    int[] array;

    Counter(int[] array, int part, int partAmount) {
        this.array = array;
        this.part = part;
        this.partAmount = partAmount;
    }

    public void run() {
        for (int i = (((part - 1) * array.length) / partAmount); i < ((part * array.length) / partAmount); i++) {
            if (array[i] % 2 == 0) {
                evenAmount++;
            } else {
                oddAmount++;
            }
        }
    }
}
