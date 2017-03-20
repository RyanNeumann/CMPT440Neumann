/**
 * 
 * file: driverDFA.java
 * author: Ryan Neumann
 * course: CMPT 440
 * assignment: Homework 1
 *
 */

import java.io.IOException;

public class driverDFA {
  public static void main(String[] args) throws IOException{
    try{ 
      ManWolf d = new ManWolf(); // The dfa created by the ManWolf class
      String input = args[0]; //This reads an argument from the command line
      while (input != null) {
        d.reset();
        d.process(input);
        if (d.accepted()) {
          System.out.println("That is a solution.");
          System.exit(0);
        }else{
          System.out.println("That is not a solution.");
          System.exit(0);
        }
      }
    }catch (ArrayIndexOutOfBoundsException ex){
      System.out.println("Error: Please provide an argument.");
    }
  }
}