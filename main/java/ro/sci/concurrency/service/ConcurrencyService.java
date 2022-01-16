package ro.sci.concurrency.service;

import ro.sci.concurrency.model.RandomNumberGenerator;
import ro.sci.concurrency.model.RandomNumberGeneratorRunnable;
import ro.sci.concurrency.model.RandomNumberGeneratorRunnableWithList;
import ro.sci.concurrency.model.RandomNumberGeneratorWithList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import static ro.sci.concurrency.common.Constant.MAX_NO_OF_THREADS;


public class ConcurrencyService {

    public int calculeSumOfRandomNumbersWithRunnable() {
        int sum = 0;
        List<RandomNumberGeneratorRunnable> threadList = new ArrayList<>();

        for (int k = 0; k < MAX_NO_OF_THREADS; k++) {
            RandomNumberGeneratorRunnable runnable = new RandomNumberGeneratorRunnable();
            Thread thread = new Thread(runnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error when joining thread: " + e.getMessage());
            }

            threadList.add(runnable);
        }

        for (RandomNumberGeneratorRunnable runnable : threadList) {
            sum += runnable.randomNumber;
        }

        return sum;
    }

    public synchronized int calculateSumOfRandomNumbersListWithRunnable() {

        Vector<Integer> generatedNumbersList = new Vector<>();

        for (int k = 0; k < MAX_NO_OF_THREADS; k++) {
            Runnable runnable = new RandomNumberGeneratorRunnableWithList(generatedNumbersList);
            Thread thread = new Thread(runnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        int sum = generatedNumbersList.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    public int calculateSumOfRandomNumbers() {
        int sum = 0;
        //stocam thread-urile intr-o lista
        List<RandomNumberGenerator> threadList = new ArrayList<>();
        //populam lista de thread-uri
        for (int k = 0; k < MAX_NO_OF_THREADS; k++) {
            //cream un nou thread
            RandomNumberGenerator thread = new RandomNumberGenerator("Thread " + k);
            //lansam thread-ul in executie
            thread.start();
            //adaugam thread-ul intr-o lista
            threadList.add(thread);
        }

        //iteram prin lista de thread-uri
        for (RandomNumberGenerator thread : threadList) {
            //thread-ul e inca in executie, asteptam finalizarea executiei
            while (thread.isAlive()) {
            }
            int no = thread.number;
            sum += no;
//            System.out.println("\tadded " + no + " from " + thread.getName() + " to the sum");
        }
        return sum;
    }

    public int calculeSumOfRandomNumbersList() {

        List<Integer> generatedNumbersList = new ArrayList<>();

        for (int k = 0; k < MAX_NO_OF_THREADS; k++) {
            RandomNumberGeneratorWithList thread = new RandomNumberGeneratorWithList("ThreadWithList " + k, generatedNumbersList);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error when joining thread: " + e.getMessage());
            }
        }

        return generatedNumbersList.stream().mapToInt(Integer::intValue).sum();
    }
}
