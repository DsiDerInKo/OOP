package is.bushuev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

class OddCounter implements Runnable {

    int amount = 0;
    int[] array;

    OddCounter(int[] array) {
        this.array = array;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                amount++;
            }
        }
    }
}

class EvenCounter implements Runnable {

    int amount = 0;
    int[] array;

    EvenCounter(int[] array) {
        this.array = array;
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                amount++;
            }
        }
    }
}

class Jiga {
    boolean isTaken;

    Jiga() {
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

class SmokingPidor implements Runnable {

    Cigarette cigarette;
    Jiga jiga;
    String name;

    SmokingPidor(String name, Jiga jiga) {
        cigarette = new Cigarette();
        this.name = name;
        this.jiga = jiga;
    }

    @Override
    public void run() {
        jiga.burnSigaret(cigarette);
        System.out.println(name + " started smoke");
        cigarette.smoke();
        jiga.putOut(cigarette);
        cigarette.smoke();
        System.out.println(name + " ended smoke");
    }
}

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

public class Main {
    public static void main(String[] args) throws InterruptedException {
/*
        Scanner scanner = new Scanner(System.in);
        int numberOfElem = scanner.nextInt();
        int[] array = new int[numberOfElem];
        for (int i = 0; i < numberOfElem; i++) {
            array[i] = scanner.nextInt();
        }

        List<Counter> counterList = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            counterList.add(new Counter(array,i,4));
        }

        List<Thread> threadList = new ArrayList<>();
        counterList.forEach((counter)->threadList.add(new Thread(counter)));

        threadList.forEach(Thread::start);

        for (Thread thread : threadList) {
            thread.join();
        }

        int odd = 0, even = 0;
        for (Counter counter : counterList) {
            odd+=counter.oddAmount;
            even+=counter.evenAmount;
        }
        System.out.println("odd number is:" + odd + " and even is:" + even);
*/
        Jiga jiga = new Jiga();
        List<SmokingPidor> smokingPidorsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            smokingPidorsList.add(new SmokingPidor("smoker " + i, jiga));
        }

        List<Thread> threadList = new ArrayList<>();
        smokingPidorsList.forEach((pidor) -> {
            Thread thread = new Thread(pidor);
            thread.setName(pidor.name);
            threadList.add(thread);
        });

        threadList.forEach(Thread::start);

    }
}