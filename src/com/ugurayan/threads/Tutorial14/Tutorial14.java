/**
 * -----------------------------------------------------------------------------------------------------------
 * Subject : Semaphores Threads
 * <p>
 * Created by: Ugur Ayan
 * Date: 11/13/2017.
 * ------------------------------------------------------------------------------------------------------------
 */

package com.ugurayan.threads.Tutorial14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Tutorial14 {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) { //200 hundred times will be called
            executor.submit(new Runnable() {
                public void run() {
                    Connectionn.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}