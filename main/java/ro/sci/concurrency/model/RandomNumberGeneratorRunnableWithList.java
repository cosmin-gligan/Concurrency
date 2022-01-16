package ro.sci.concurrency.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ro.sci.concurrency.common.Constant.MAX_RANDOM_NUMBER;
import static ro.sci.concurrency.common.Constant.MIN_RANDOM_NUMBER;

public class RandomNumberGeneratorRunnableWithList implements Runnable {
    public List<Integer> integerList;

    public RandomNumberGeneratorRunnableWithList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public void run() {
        addRandomNumber2List();
    }

    public synchronized void addRandomNumber2List(){
        int randomNo = new Random().nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1) + MIN_RANDOM_NUMBER;

        System.out.println(Thread.currentThread().getName() + " generated the number " + randomNo);

        notifyAll();

        this.integerList.add(randomNo);
    }
}
