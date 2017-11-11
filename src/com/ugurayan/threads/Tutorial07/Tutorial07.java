package com.ugurayan.threads.Tutorial07;
/**-----------------------------------------------------------------------------------------------------------
 * Subject : Thread Pool
 *
 * Created by: Ugur Ayan
 * Date: 11/10/2017.
 ------------------------------------------------------------------------------------------------------------*/


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Proceed implements Runnable{

    private int id;

    public Proceed(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting :" + id);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Completed: " + id);
    }
}

public class Tutorial07 {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Proceed(i));
        }

        executorService.shutdown();
        System.out.println("All tasks are submitted");

        try{
            executorService.awaitTermination(1, TimeUnit.DAYS);
        }catch (InterruptedException e){

        }
    }
}
