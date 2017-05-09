import java.awt.*;
import java.util.Random;

/**
 * file: Enemy.java
 * author: Ryan Neumann
 * course: CMPT 440
 * assignment: Semester Project
 * due date: 10 May 2017
 * version: 1.0
 * <p>
 * This file contains the AI and states
 * of the Ghosts.  Each enemy has their
 * own state, in correlation to Pacman.
 * If pacman is out of sight, they will wander.
 * If pacman is in the line of sight, they will
 * follow him.
 * If pacman eats the candy, they will run.
 * Once pacman eats the candy, the enemies are
 * able to be eatten.
 */
public class Enemy extends Rectangle {
  
  
  private int random = 0, smart = 1, findPath = 2, run = 3;
  
  public int state = random;
  
  private int right = 0, left = 1, up = 2, down = 3;
  
  private int dir = -1;
  
  public Random randomGen;
  
  private int time = 0;
  
  private int targetTime = 60 * 4;
  
  private int spd = 2;
  
  private int lastDir = -1;
  
  
  public Enemy(int x, int y) {
    
    randomGen = new Random();
    setBounds(x, y, 32, 32);
    dir = randomGen.nextInt(4);
    
  }
  
  public void tick() {
    
    Level level = Game.level;
    
    if (state == random) {
      
      if (Game.test == 0) {
        
        Game.label1.setText("Ghost 0: Random");
        
      } else if (Game.test == 1) {
        
        Game.label2.setText("Ghost 1: Random");
        
        
      } else if (Game.test == 2) {
        
        Game.label3.setText("Ghost 2: Random");
        
      } else if (Game.test == 3) {
        
        Game.label4.setText("Ghost 3: Random");
        
        
      }
      System.out.print("Random...\n");
      
      
      if (dir == right) {
        
        if (canMove(x + spd, y)) {
          
          x += spd;
          
        } else {
          
          dir = randomGen.nextInt(4);
          
        }
        
      } else if (dir == left) {
        
        if (canMove(x - spd, y)) {
          
          x -= spd;
          
        } else {
          
          dir = randomGen.nextInt(4);
          
        }
        
      } else if (dir == up) {
        
        if (canMove(x, y - spd)) {
          
          y -= spd;
          
        } else {
          
          dir = randomGen.nextInt(4);
          
        }
        
        
      } else if (dir == down) {
        
        if (canMove(x, y + spd)) {
          
          y += spd;
          
        } else {
          
          dir = randomGen.nextInt(4);
          
        }
        
      }
      
      time++;
      
      if (time == targetTime) {
        
        if (Game.level.candies.size() > 0) {
          
          state = smart;
          
        } else {
          
          state = run;
          
          
        }
        time = 0;
        
      }
      
    } else if (state == smart) {
      
      if (Game.test == 0) {
        
        Game.label1.setText("Ghost 0: Smart");
        
      } else if (Game.test == 1) {
        
        Game.label2.setText("Ghost 1: Smart");
        
        
      } else if (Game.test == 2) {
        
        Game.label3.setText("Ghost 2: Smart");
        
      } else if (Game.test == 3) {
        
        Game.label4.setText("Ghost 3: Smart");
        
        
      }
      
      System.out.print("Smart...\n");
      
      //follow the player
      boolean move = false;
      
      if (x < Game.player.x) {
        
        if (canMove(x + spd, y)) {
          
          x += spd;
          move = true;
          lastDir = left;
          
        }
        
      }
      
      if (x > Game.player.x) {
        
        if (canMove(x - spd, y)) {
          
          x -= spd;
          move = true;
          lastDir = right;
        }
        
      }
      
      if (y < Game.player.y) {
        
        if (canMove(x, y - spd)) {
          
          y -= spd;
          move = true;
          lastDir = down;
          
        }
        
      }
      
      
      if (y > Game.player.y) {
        
        if (canMove(x, y + spd)) {
          
          y += spd;
          move = true;
          lastDir = up;
          
        }
        
      }
      
      if (x == Game.player.x && y == Game.player.y) move = true;
      
      if (!move) {
        
        state = findPath;
        
      }
      
      
      time++;
      if (time == targetTime) {
        
        state = random;
        time = 0;
        
      }
      
      
    } else if (state == findPath) {
      
      if (Game.test == 0) {
        
        Game.label1.setText("Ghost 0: Finding Path");
        
      } else if (Game.test == 1) {
        
        Game.label2.setText("Ghost 1: Finding Path");
        
        
      } else if (Game.test == 2) {
        
        Game.label3.setText("Ghost 2: Finding Path");
        
      } else if (Game.test == 3) {
        
        Game.label4.setText("Ghost 3: Finding Path");
        
        
      }
      
      System.out.print("Finding Path...\n");
      if (lastDir == right) {
        
        if (y < Game.player.y) {
          
          if (canMove(x, y + spd)) {
            
            y += spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
            
          }
          
        } else {
          
          if (canMove(x, y - spd)) {
            
            y -= spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
            
          }
        }
        
        if (canMove(x + spd, y)) {
          
          x += spd;
          
        }
        
        
      } else if (lastDir == left) {
        
        if (y < Game.player.y) {
          
          if (canMove(x, y + spd)) {
            
            y += spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
          }
          
        } else {
          
          if (canMove(x, y - spd)) {
            
            y -= spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
            
          }
        }
        
        if (canMove(x - spd, y)) {
          
          x -= spd;
          
        }
        
        
      } else if (lastDir == up) {
        
        if (x < Game.player.x) {
          
          if (canMove(x + spd, y)) {
            
            x += spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
            
          }
          
        } else {
          
          if (canMove(x - spd, y)) {
            
            x -= spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
            
          }
        }
        
        if (canMove(x, y - spd)) {
          
          y -= spd;
          
        }
        
        
      } else if (lastDir == down) {
        
        if (x < Game.player.x) {
          
          if (canMove(x + spd, y)) {
            
            x += spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
            
          }
          
        } else {
          
          if (canMove(x - spd, y)) {
            
            x -= spd;
            if (Game.level.candies.size() == 0) {
              
              state = run;
              
            } else {
              
              state = smart;
              
            }
            
          }
        }
        
        if (canMove(x, y + spd)) {
          
          y += spd;
          
        }
        
      }
      
      time++;
      if (time == targetTime) {
        
        if (Game.level.candies.size() > 0) {
          
          System.out.print("Wandering...\n");
          
          state = random;
          
        } else {
          
          state = run;
          
        }
        time = 0;
        
      }
      
    } else if (state == run) {
      
      if (Game.test == 0) {
        
        Game.label1.setText("Ghost 0: Running");
        
      } else if (Game.test == 1) {
        
        Game.label2.setText("Ghost 1: Running");
        
        
      } else if (Game.test == 2) {
        
        Game.label3.setText("Ghost 2: Running");
        
      } else if (Game.test == 3) {
        
        Game.label4.setText("Ghost 3: Running");
        
        
      }
      
      System.out.print("Running...\n");
      
      //run from the player
      boolean move = false;
      
      if (x > Game.player.x) {
        
        if (canMove(x + spd, y)) {
          
          x += spd;
          move = true;
          lastDir = left;
          
        }
        
      }
      
      if (x < Game.player.x) {
        
        if (canMove(x - spd, y)) {
          
          x -= spd;
          move = true;
          lastDir = right;
        }
        
      }
      
      if (y < Game.player.y) {
        
        if (canMove(x, y - spd)) {
          
          y -= spd;
          move = true;
          lastDir = down;
          
        }
        
      }
      
      
      if (y > Game.player.y) {
        
        if (canMove(x, y + spd)) {
          
          y += spd;
          move = true;
          lastDir = up;
          
        }
        
      }
      
      if (x == Game.player.x && y == Game.player.y) move = true;
      
      if (!move) {
        
        state = random;
        
      }
    }
  }
  
  
  private boolean canMove(int nextx, int nexty) {
    
    Rectangle bounds = new Rectangle(nextx, nexty, width, height);
    Level level = Game.level;
    
    for (int xx = 0; xx < level.tiles.length; xx++) {
      
      for (int yy = 0; yy < level.tiles[0].length; yy++) {
        
        if (level.tiles[xx][yy] != null) {
          
          if (bounds.intersects(level.tiles[xx][yy])) {
            
            return false;
            
          }
          
        }
        
      }
      
    }
    
    return true;
    
  }
  
  
  public void render(Graphics g) {
    
    SpriteSheet sheet = Game.spritesheet;
    
    Level level = Game.level;
    
    
    if (level.candies.size() > 0) {
      
      g.drawImage(sheet.getSprite("enemy"), x, y, 32, 32, null);
      
      
    } else {
      
      g.drawImage(sheet.getSprite("enemy2"), x, y, 32, 32, null);
      
    }
    
    
  }
  
}
