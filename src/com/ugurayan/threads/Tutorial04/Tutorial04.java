package com.ugurayan.threads.Tutorial04;

import java.util.Scanner;

/**-----------------------------------------------------------------------------------------------------------
 * Subject : Basic Thread Synchronization
 * Created by: Ugur Ayan
 * Date: 11/10/2017.
 ------------------------------------------------------------------------------------------------------------*/



class Processor extends Thread{
    private boolean close = false;

    public int i = 0;
    public void run(){

        while(!close){

            System.out.println("Hello " + i);
            i++;

            try {
                Thread.sleep(10);

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void closeThread(){
        close = true;
    }
}


public class Tutorial04 {

    public static void main(String [] args){

        Processor pc = new Processor();

        pc.start();

        System.out.println("Press return to stop ...");
        Scanner scn = new Scanner(System.in);

        scn.nextLine();

        pc.closeThread();
    }
}
