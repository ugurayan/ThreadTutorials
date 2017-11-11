/**-----------------------------------------------------------------------------------------------------------
 * Subject : Wait and notify
 *
 * Created by: Ugur Ayan
 * Date: 11/11/2017.
 ------------------------------------------------------------------------------------------------------------*/

package com.ugurayan.threads.Tutorial10;




import java.util.Scanner;

public class MyJob {
    public void producer() throws InterruptedException {

        synchronized (this){ // this means myJob class

            System.out.println("Producer thread running ...");
            wait();  // All object has a wait method
            System.out.println("Resumed producer ...");

        }

    }

    public void consumer() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){ // this means myJob class

            System.out.println("Waiting for return key...");

            scanner.nextLine();

            System.out.println("Return key pressed...");
            notify(); // only used in syncronized code block like wait

            Thread.sleep(5000);
        }
    }
}
