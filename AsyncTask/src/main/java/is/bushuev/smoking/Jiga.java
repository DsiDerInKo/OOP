package is.bushuev.smoking;

public class Jiga {
    boolean isTaken;

    public Jiga() {
        isTaken = false;
    }

    void putOut(Cigarette sigaret) {
        sigaret.thread.interrupt();
        sigaret.onFire = false;
    }

    void burnSigaret(Cigarette sigaret) {
        synchronized (this) {

            sigaret.thread.start();
            sigaret.onFire = true;

            isTaken = true;
            System.out.println(Thread.currentThread().getName() + " took fire");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " closed fire");

        }
    }
}
