
/**-----------------------------------------------------------------------------------------------------------
 * Subject : Wait and notify
 *
 * Created by: Ugur Ayan
 * Date: 11/11/2017.
 ------------------------------------------------------------------------------------------------------------*/


package com.ugurayan.threads.Tutorial10;

public class Tutorial10 {
    public static void main(String[] args) throws InterruptedException {

        MyJob m = new MyJob();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    m.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    m.consumer();
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
}