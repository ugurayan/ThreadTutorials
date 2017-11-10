package com.ugurayan.threads.Tutorial02;

/**-----------------------------------------------------------------------------------------------------------
 * Subject : Implementation of Threads implement as Runnable
 * Created by: Ugur Ayan
 * Date: 11/10/2017.
 ------------------------------------------------------------------------------------------------------------*/


class MyThreadClass implements Runnable{

    public String name;

    public MyThreadClass() {}
    public MyThreadClass (String name) {
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + name + " : " + i);

            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}

public class Tutorial02 {
    public static void main(String [] args){
        Thread t1 = new Thread(new MyThreadClass("First"));

        Thread t2= new Thread(new MyThreadClass("Second"));

        t1.start();
        t2.start();

    }


}
