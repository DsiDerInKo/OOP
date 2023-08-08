package is.bushuev.smoking;

import java.util.Random;

class Cigarette implements Runnable {

    boolean onFire;
    Thread thread;

    Cigarette() {
        onFire = false;
        thread = new Thread();
    }

    void smoke() {
        if (!onFire) {
            System.out.println(Thread.currentThread().getName() + " can't smoke without burning sigaret");
        }

        Random rn = new Random();
        int random = rn.nextInt(10) + 1;
        for (int i = 0; i < random; i++) {
            System.out.println(Thread.currentThread().getName() + " smoking");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void run() {
        smoke();
    }
}
