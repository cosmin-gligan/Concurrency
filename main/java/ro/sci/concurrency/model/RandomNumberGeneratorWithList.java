package ro.sci.concurrency.model;

import java.util.List;
import java.util.Random;

import static ro.sci.concurrency.common.Constant.MAX_RANDOM_NUMBER;
import static ro.sci.concurrency.common.Constant.MIN_RANDOM_NUMBER;

public class RandomNumberGeneratorWithList extends Thread{
    List<Integer> generatedNumbersList;
    public RandomNumberGeneratorWithList(String name, List <Integer> generatedNumbersList) {
        super(name);
        this.generatedNumbersList = generatedNumbersList;
    }

    @Override
    public void run() {
        addRandomNumber2List();
    }

    public synchronized void addRandomNumber2List(){
        int randomNo = new Random().nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1) + MIN_RANDOM_NUMBER;

        System.out.println(this.getName() + " generated the number " + randomNo);

        notifyAll();

        this.generatedNumbersList.add(randomNo);
    }
}
