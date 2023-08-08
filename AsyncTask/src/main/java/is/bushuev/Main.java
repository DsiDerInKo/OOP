package is.bushuev;

import is.bushuev.smoking.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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