package ro.sci.concurrency;

import ro.sci.concurrency.service.ConcurrencyService;

public class Concurrency {
    /*
    1.  Write a program that runs 5 threads, each thread randomizes a number between 1 and 10.
        The main thread waits for all the others to finish, calculates the sum of the numbers which were randomized and prints that sum.
        You will need to implement a Runnable class that randomizes a number and store it in a member field.
        When all the threads have done, your main program can go over all the objects and check the stored values in each object.
    2.Modify the program in (1) so that instead of each object keeping its own score, you will use one collection to store all the results in.
    */
    public static void main(String[] args) {

        ConcurrencyService ConcurrencyService = new ConcurrencyService();

        long start1 = System.nanoTime();
//        System.out.println("\nSum of random Numbers  using \"calculeSumOfRandomNumbersWithRunnable\"  method is " + ConcurrencyService.calculeSumOfRandomNumbersWithRunnable());
        long end1 = System.nanoTime();

        System.out.println("");

        long start2 = System.nanoTime();
        System.out.println("\nSum of random Numbers  using \"calculateSumOfRandomNumbersListWithRunnable\"  method is " + ConcurrencyService.calculateSumOfRandomNumbersListWithRunnable());
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
//        System.out.println("\nSum of random Numbers  using \"calculateSumOfRandomNumbers\"  method is " + ConcurrencyService.calculateSumOfRandomNumbers());
        long end3 = System.nanoTime();

        long start4 = System.nanoTime();
//        System.out.println("\nSum of random numbers from list: " + ConcurrencyService.calculeSumOfRandomNumbersList());
        long end4 = System.nanoTime();

        System.out.println("\n\tTimpul de executie pentru prima metoda este " + (end1-start1) + " nano secunde");
        System.out.println("\tTimpul de executie pentru a doua metoda este " + (end2-start2) + " nano secunde");
        System.out.println("\tTimpul de executie pentru a treia metoda este " + (end3-start3) + " nano secunde");
        System.out.println("\tTimpul de executie pentru a patra metoda este " + (end4-start4) + " nano secunde");

    }

}
