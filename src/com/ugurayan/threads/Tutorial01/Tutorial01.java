package com.ugurayan.threads.Tutorial01;

/**-----------------------------------------------------------------------------------------------------------
 * Subject : Implementation of Threads extending from Thread
 * Created by: Ugur Ayan
 * Date: 11/10/2017.
 ------------------------------------------------------------------------------------------------------------*/


class MyThreadClass extends Thread{

    public String name;

    public MyThreadClass() {}
    public MyThreadClass (String name) {
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + name + " : " + i);

            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
public class Tutorial01 {
    public static void main(String [] args){
        MyThreadClass r1 = new MyThreadClass();
        r1.name = "First Thread";

        MyThreadClass r2= new MyThreadClass();
        r2.name = "Second Thread";

        r1.start();
        r2.start();

    }


}
