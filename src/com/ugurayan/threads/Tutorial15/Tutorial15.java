/**
 * -----------------------------------------------------------------------------------------------------------
 * Subject : Callable and Future
 * <p>
 * Created by: Ugur Ayan
 * Date: 11/13/2017.
 * ------------------------------------------------------------------------------------------------------------
 */

package com.ugurayan.threads.Tutorial15;

import java.util.Random;
import java.util.concurrent.*;

public class Tutorial15 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        //anonymous call of Callable
        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            //return value is Integer
            public Integer call() throws TimeoutException {
                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new TimeoutException("Sleeping for too long.");
                }

                System.out.println("Starting ...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
        try {
            //get returned value from call()
            System.out.println("Result is: " + future.get());

        } catch (InterruptedException ignored) {
        } catch (ExecutionException e) {
            TimeoutException ex = (TimeoutException) e.getCause();
            System.out.println(ex.getMessage());
        }
    }

}