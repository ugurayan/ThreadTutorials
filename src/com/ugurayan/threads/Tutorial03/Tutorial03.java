package com.ugurayan.threads.Tutorial03;

/**-----------------------------------------------------------------------------------------------------------
 * Subject : Implementation of Threads implement as Runnable
 * Created by: Ugur Ayan
 * Date: 11/10/2017.
 ------------------------------------------------------------------------------------------------------------*/




public class Tutorial03 {
    public static void main(String [] args){

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello  First Thread : " + i);

                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello Second Thread : " + i);

                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        });

        t2.start();
    }


}
