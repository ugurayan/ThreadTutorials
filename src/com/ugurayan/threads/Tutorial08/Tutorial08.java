package com.ugurayan.threads.Tutorial08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**-----------------------------------------------------------------------------------------------------------
 * Subject : Countdown and Latches
 *
 * Created by: Ugur Ayan
 * Date: 11/11/2017.
 ------------------------------------------------------------------------------------------------------------*/

class MyJob implements Runnable{
    private CountDownLatch latch;

    private Integer id ;
    public MyJob(CountDownLatch latch, Integer id){
        this.latch = latch;
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Started .." + id);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        latch.countDown();
        System.out.println("Completed " + id);

    }
}


public class Tutorial08 {

    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new MyJob(latch, i));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed all...");

    }
}
