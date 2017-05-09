import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 * file: SpriteSheet.java
 * author: Ryan Neumann
 * course: CMPT 440
 * assignment: Semester Project
 * due date: 10 May 2017
 * version: 1.0
 * <p>
 * This file reads each image and
 * assigns them to a variable, which
 * is called later by other classes.
 */
public class SpriteSheet {
  private BufferedImage pacMan;
  private BufferedImage pacManOpen;
  private BufferedImage enemy;
  private BufferedImage enemy2;
  private BufferedImage pellet;
  private BufferedImage candy;
  
  public SpriteSheet(String path) {
    
    try {
      
      pacMan = ImageIO.read(getClass().getResource("/Map/closed.png"));
      pacManOpen = ImageIO.read(getClass().getResource("/Map/open.png"));
      enemy = ImageIO.read(getClass().getResource("/Map/enemy.png"));
      enemy2 = ImageIO.read(getClass().getResource("/Map/enemy2.png"));
      pellet = ImageIO.read(getClass().getResource("/Map/pellet.png"));
      candy = ImageIO.read(getClass().getResource("/Map/candy.png"));
      
    } catch (IOException e) {
      
      System.out.println("Failed to load image");
      
    }
    
  }
  
  public BufferedImage getSprite(String name) {
    
    if (name == "pacman") {
      
      return pacMan;
      
    } else if (name == "open") {
      
      return pacManOpen;
      
    } else if (name == "pellet") {
      
      return pellet;
      
    } else if (name == "candy") {
      
      return candy;
      
    } else if (name == "enemy2") {
      
      return enemy2;
      
    } else {
      
      return enemy;
      
    }
    
  }
  
}
