package com.ugurayan.threads.Tutorial11;

public class Tutorial11{

    public static void main(String [] args)  throws InterruptedException {

        MyJob m = new MyJob();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    m.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    m.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

    }
}