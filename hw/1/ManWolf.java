/**
* file: ManWolf.java
* author: Ryan Neumann
* course: CMPT 440
* assignment: Homework 01
* due date: 20 March 2017
* version: 1.0
*/


public class ManWolf {
  
  //determining state
  private static final int q0 = 0; 
  private static final int q1 = 1;
  private static final int q2 = 2;
  private static final int q3 = 3;
  private static final int q4 = 4;
  private static final int q5 = 5;
  private static final int q6 = 6;
  private static final int q7 = 7;
  private static final int q8 = 8;
  private static final int q9 = 9;
  private static final int q10 = 10;
  
  //starting DFA at 0
  private int state = 0;
  private int indexOfDelta = 0;
  
  private static int[][] delta = {
//	    g  |  w  |  c  | n
	  { q1,  q10, q10, q10 },
      { q0,  q10, q10, q2  },
      { q10, q3,  q4,  q1  },
      { q5,  q2,  q10, q10 },
      { q6,  q10, q2,  q10 },
      { q3,  q10, q7,  q10 },
      { q4,  q7,  q10, q10 },
      { q10, q6,  q5,  q8  },
      { q9,  q10, q10, q7  },
      { q8,  q10, q10, q10 } 
                            
  };
 
  public void process(String in) {
	  
	  for (int n = 0; n < in.length(); n++) {
    	
		char c = in.charAt(n);
      
    	try{
    	  
    	if (c == 'g') {
          
    		indexOfDelta = 0;
          
        } else if (c == 'w'){
        	
        	indexOfDelta = 1;
        	
        } else if (c == 'c'){
        	
        	indexOfDelta = 2;
        	
        } else if (c == 'n'){
        
        	indexOfDelta = 3;
        
        }
        
        state = delta[state][indexOfDelta]; 
        
      } catch (ArrayIndexOutOfBoundsException ex) {
      
    	  //catch error
    	  state = q10; 
    
      }
    
    }
    
  }
  
  /**
   * Reset the current state to the start state.
   */
  
  public void reset() {
	
    state = q0;
    
  }
  
  /**
   * Test whether the DFA accepted the string.
   * @return true if the final state was accepting
   */
  
  public boolean accepted() {
	
	  //returns as accepted state
	  return state == q9;
	  
  }

}