/**
* file: driverDFA.java
* author: Ryan Neumann
* course: CMPT 440
* assignment: Homework 01
* due date: 20 March 2017
* version: 1.0
*/


import java.io.*;

public class driverDFA {
	
  public static void main(String[] args) throws IOException{
	  
    try{
    	
      ManWolf test = new ManWolf();
      String input = args[0];
      
      while (input != null) {
    	  
        test.reset();
        test.process(input);
        
        if (test.accepted()) {
        	
          System.out.println("That is a solution.");
          
        } else {
        	
          System.out.println("That is not a solution.");
          
        }
          
        System.exit(0);
        
      }
      
    } catch (ArrayIndexOutOfBoundsException ex) {
    	
      System.out.println("Error - No arguement given. Please try again.");
      
    }
    
  }
  
}
