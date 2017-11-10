package com.ugurayan.threads.Tutorial01;

/**-----------------------------------------------------------------------------------------------------------
 * Subject : Implementation of Threads extending from Thread
 * Created by: Ugur Ayan
 * Date: 11/10/2017.
 ------------------------------------------------------------------------------------------------------------*/


class Runner extends Thread{

    public String name;
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
public class myApp {
    public static void main(String [] args){
        Runner r1 = new Runner();
        r1.name = "First Thread";

        Runner r2= new Runner();
        r2.name = "Second Thread";

        r1.start();
        r2.start();

    }


}
