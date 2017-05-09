import java.awt.*;

/**
 * file: Tile.java
 * author: Ryan Neumann
 * course: CMPT 440
 * assignment: Semester Project
 * due date: 10 May 2017
 * version: 1.0
 * <p>
 * This file sets any black bits detected
 * in the .png image for the map, and replaces
 * them with green boundaries.  This is the
 * part of the map that is unable to be used by
 * Pacman and the ghosts.
 */
public class Tile extends Rectangle {
  
  public Tile(int x, int y) {
    
    setBounds(x, y, 32, 32);
    
  }
  
  public void render(Graphics g) {
    
    g.setColor(Color.green);
    g.fillRect(x, y, width, height);
  }
  
}
