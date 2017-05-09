import java.awt.*;

/**
 * file: PowerPellets.java
 * author: Ryan Neumann
 * course: CMPT 440
 * assignment: Semester Project
 * due date: 10 May 2017
 * version: 1.0
 * <p>
 * This file pulls the image for the PowerPellet
 * as well as sets the boundaries for each object.
 */
public class PowerPellets extends Rectangle {
  
  public PowerPellets(int x, int y) {
    
    setBounds(x + 10, y + 8, 8, 8);
    
  }
  
  public void render(Graphics g) {
    
    SpriteSheet sheet = Game.spritesheet;
    g.drawImage(sheet.getSprite("pellet"), x, y + 5, 10, 10, null);
    
  }
  
}
