package com.ugurayan.threads.Tutorial05;

/**-----------------------------------------------------------------------------------------------------------
 * Subject : Basic Thread Synchronization by synchronized method
 * The join method allows one thread to wait for the completion of another. If t is a Thread object whose thread
 * is currently executing,
 * t.join();
 * causes the current thread to pause execution until t's thread terminates. Overloads of join allow the programmer
 * to specify a waiting period. However, as with sleep, join is dependent on the OS for timing, so you should not
 * assume that join will wait exactly as long as you specify.
 * Like sleep, join responds to an interrupt by exiting with an InterruptedException.
 *
 * Created by: Ugur Ayan
 * Date: 11/10/2017.
 ------------------------------------------------------------------------------------------------------------*/

public class Tutorial05 {

    private int count1 = 0;
    private int count2= 0;

    public synchronized void increment(){ count2++; } //

    public static void main(String[] args) {

    Tutorial05 app = new Tutorial05();
    app.createThread();

    }

    private void createThread() {

        Thread t1 = new Thread(new Runnable() {
            public void run(){ for (int i = 0; i < 10000; i++) { count1 ++; } }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run(){ for (int i = 0; i < 10000; i++) { count1 ++;} }
        });
        t1.start();
        t2.start();
        System.out.println("Count 1 is :" + count1); // Does not means 20000 something not equals 20000

        Thread t3 = new Thread(new Runnable() {
            public void run(){ for (int i = 0; i < 10000; i++) { increment(); } }
        });

        Thread t4 = new Thread(new Runnable() {
            public void run(){ for (int i = 0; i < 10000; i++) { increment();} }
        });


        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count 2 is :" + count2); // equals  always 20000 because t4 waits t3 finished


    }
}
