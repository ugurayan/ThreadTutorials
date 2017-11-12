/**-----------------------------------------------------------------------------------------------------------
 * Subject : Wait and notify
 *
 * Created by: Ugur Ayan
 * Date: 11/11/2017.
 ------------------------------------------------------------------------------------------------------------*/

package com.ugurayan.threads.Tutorial11;




import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class MyJob {

    private LinkedList<Integer> myList = new LinkedList<Integer>();

    private final int LIMIT = 10;

    private Object lock = new Object();

    public void producer() throws InterruptedException {
        int value = 0 ;
        while(true) {

            synchronized (lock) {

                while(myList.size() == LIMIT) {
                    lock.wait();
                }

                value++;
                myList.add(value);
            }

        }
    }

    public void consumer() throws InterruptedException {
        Random rand = new Random();

        while(true) {
            while(myList.size() == LIMIT) {
                lock.wait();
            }


            synchronized (lock) {
                System.out.println("List size is " + myList.size());
                int value = myList.removeFirst();
                System.out.println("Value is " + value);
                lock.notify();
            }

            Thread.sleep(rand.nextInt(1000));

        }
    }
}
