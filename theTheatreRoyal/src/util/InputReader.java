package util;

import java.util.Scanner;

public class InputReader {
    private Scanner scanner = new Scanner(System.in);

    public InputReader(){


    }
    //returns a string input 

    public String getInputString(){

      String input = scanner.nextLine();

      return input;

    }

    //checks to see if it is a integer thats been passed then returns the input

    public int getInputInt(){
 
      while (!scanner.hasNextInt())

      {

        scanner.next();

        System.out.print("Please choose a valid num (Integers only): ");

      }

       int input = scanner.nextInt();

       return input;

    }  
}
