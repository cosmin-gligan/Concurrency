package ro.sci.concurrency.model;

import ro.sci.concurrency.common.Constant;

import java.util.Random;

import static ro.sci.concurrency.common.Constant.MAX_RANDOM_NUMBER;
import static ro.sci.concurrency.common.Constant.MIN_RANDOM_NUMBER;

public class RandomNumberGenerator extends Thread {
    public int number = 0;

    public RandomNumberGenerator(String name) {
        super(name);
    }

    @Override
    public void run() {
        getRandomInt();
    }

    private synchronized void getRandomInt(){
        int randomNo = new Random().nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1) + MIN_RANDOM_NUMBER;

//        System.out.println(this.getName() + " generated the number " + randomNo);

        this.number = randomNo;

        notifyAll();

        return;
    }

}
