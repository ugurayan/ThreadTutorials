package com.ugurayan.threads.Tutorial06;

import java.util.*;

public class Job {

    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> myList1= new ArrayList<Integer>();
    private List<Integer> myList2= new ArrayList<Integer>();

//    public synchronized void step1st(){
//        try{
//            Thread.sleep(1);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        myList1.add(random.nextInt(100));
//    }
//
//    public synchronized void step2nd(){
//        try{
//            Thread.sleep(1);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        myList2.add(random.nextInt(100));
//    }

    public  void step1st(){

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myList1.add(random.nextInt(10));
        }
    }

    public void step2nd(){
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myList2.add(random.nextInt(10));
        }
    }

    public void proceed(){
        for (int i = 0; i < 1000; i++) {
            step1st();
            step2nd();
        }
    }

    public void myWork(){
        System.out.println("Starting.......");

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                proceed();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                proceed();
            }
        });
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();

        System.out.println("Time runs about " + (end - start));
        System.out.println("My First List :" + myList1.size() + " ; My Second List :" + myList2.size());
    }
}
