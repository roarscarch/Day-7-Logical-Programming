/*
 * see u start 
 * then u end time
 * the time measured is in ms 
 * so the data type u can have is long or int
 * calculate current time
 * then ask for a input compiler will wait for ur input meanwhile ur java program will run
 * then calculate end time
 * nextLine(): This is a method of the Scanner class.
 *  It reads the entire line from the user's input until it encounters a newline character (Enter key).
 *  It returns the input as a string.
 * 
 */


import java.util.*;

public class StopWatch {

    public static void elapsedTime(){
        Scanner sc = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        System.out.println("Start StopWatch Broo");
        System.out.print("Press Enter to end StopWatch Broo");
        sc.nextLine();
        long endTime = System.currentTimeMillis();
        System.out.println("Giving u time Difference, Why didnt you press enter early");
        System.out.println("Time elapsed is: " + (endTime - startTime) + " ms");
        sc.close();
    }
    public static void main(String[] args) {
        //System.out.println("StopWatch Problem");
        elapsedTime();
    }
}