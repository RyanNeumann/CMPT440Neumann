/**
 * 
 * file: ManWolf.java 
 * author: Ryan Neumann
 * course: CMPT 440 
 * assignment: Homework 1
 * 
 */

public class ManWolf {
  
  private static final int q0 = 0; //start state
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

  private int state = 0; // initialize at zero (the start of the dfa)

  private static int[][] delta =
  /*  G    W    C    N */
  { { q1, q10, q10, q10 },// q0
      { q0, q10, q10, q2 },// q1
      { q10, q3, q4, q1 },// q2
      { q5, q2, q10, q10 },// q3
      { q6, q10, q2, q10 },// q4
      { q3, q10, q7, q10 },// q5
      { q4, q7, q10, q10 },// q6
      { q10, q6, q5, q8 },// q7
      { q9, q10, q10, q7 },// q8
      { q8, q10, q10, q10 } // q9
                            // q10 (error state)
  };

  /**
   * Makes transition on each char in the given string.
   * 
   * @param in : the string to use as input
   */

  public void process(String in) {
    for (int i = 0; i < in.length(); i++) {
      char c = in.charAt(i);
      int index = 0; //This represents which letter in the string and maps it to the delta array
      try{
        if(c == 'g'){
          index = 0;
        }else if (c == 'w'){
          index = 1;
        }else if (c == 'c'){
          index = 2;
        }else if (c == 'n'){
          index = 3;
        }
        state = delta[state][index]; 
      }catch (ArrayIndexOutOfBoundsException ex) {
        state = q10; 
      }
    }
  }

  /**
   * 
   * Reset the current state to the start state.
   */
  public void reset() {
    state = q0;
  }

  /**
   * 
   * @return true if the end state is an accepting state
   */
  public boolean accepted() {
    return state == q9;
  }
}