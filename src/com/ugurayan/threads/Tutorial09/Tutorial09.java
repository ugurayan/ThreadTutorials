/**-----------------------------------------------------------------------------------------------------------
 * Subject : Producer Consumer PAtterns
 *
 * Created by: Ugur Ayan
 * Date: 11/11/2017.
 ------------------------------------------------------------------------------------------------------------*/

package com.ugurayan.threads.Tutorial09;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Tutorial09 {

    private static BlockingQueue queue = new ArrayBlockingQueue(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    private static void producer() throws InterruptedException {
        Random r = new Random();

        while(true){
            queue.put(r.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        Random r = new Random();

        while (true){
            Thread.sleep(100);
            if (r.nextInt(10) == 0 ){
                Integer value = (Integer) queue.take();
                System.out.println("Taken value :" + value + "; Queue size is : " +  queue.size());
            }
        }
    }
}
