package ro.sci.concurrency.model;

import java.util.Random;

import static ro.sci.concurrency.common.Constant.MAX_RANDOM_NUMBER;
import static ro.sci.concurrency.common.Constant.MIN_RANDOM_NUMBER;

public class RandomNumberGeneratorRunnable implements Runnable {
    public int randomNumber;

    @Override
    public void run() {
        getRandomInt();
    }

    public synchronized int getRandomInt(){
        randomNumber =  new Random().nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1) + MIN_RANDOM_NUMBER;
        System.out.println("Generated number by " + Thread.currentThread().getName() + " is " + randomNumber);
        return randomNumber;
    }
}
