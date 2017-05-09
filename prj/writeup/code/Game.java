import oracle.jvm.hotspot.jfr.JFR;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.security.Key;

/**
 * file: Game.java
 * author: Ryan Neumann
 * course: CMPT 440
 * assignment: Semester Project
 * due date: 10 May 2017
 * version: 1.0
 * <p>
 * This file contains the code the main Game,
 * which sets up the JFrame for the screen,
 * as well as starts the main class to initialize
 * the game.
 */
public class Game extends Canvas implements Runnable, KeyListener {
  
  public boolean isRunning = false;
  
  public static final int WIDTH = 1280, HEIGHT = 960;
  public static final String TITLE = "Pac-Man";
  
  public Thread thread;
  
  public static Player player;
  public static Level level;
  public static SpriteSheet spritesheet;
  public static int test = 0;
  
  public Game() {
    
    Dimension dimension = new Dimension(Game.WIDTH, Game.HEIGHT);
    setPreferredSize(dimension);
    setMinimumSize(dimension);
    setMaximumSize(dimension);
    
    addKeyListener(this);
    player = new Player(Game.WIDTH / 2, Game.HEIGHT / 2);
    level = new Level("/Map/board1.png");
    spritesheet = new SpriteSheet("/Map/");
    
  }
  
  public synchronized void start() {
    
    if (isRunning) return;
    isRunning = true;
    thread = new Thread(this);
    thread.start();
    
  }
  
  public synchronized void stop() {
    
    if (!isRunning) return;
    isRunning = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      
      e.printStackTrace();
      
    }
  }
  
  public void tick() {
    
    player.tick();
    level.tick();
    
  }
  
  public void render() {
    
    BufferStrategy bs = getBufferStrategy();
    if (bs == null) {
      
      createBufferStrategy(3);
      return;
    }
    
    Graphics g = bs.getDrawGraphics();
    g.setColor(Color.black);
    g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
    player.render(g);
    level.render(g);
    g.dispose();
    bs.show();
    
  }
  
  
  @Override
  
  public void run() {
    
    int fps = 0;
    double timer = System.currentTimeMillis();
    long lastTime = System.nanoTime();
    double targetTicks = 60.0;
    double delta = 0;
    double ns = 1000000000 / targetTicks;
    
    while (isRunning) {
      
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      
      while (delta >= 1) {
        
        tick();
        render();
        fps++;
        delta--;
        
      }
      
      if (System.currentTimeMillis() - timer >= 1000) {

//                System.out.println(fps);
        fps = 0;
        timer += 1000;
        
      }
      
    }
    
    stop();
    
  }
  
  public static JLabel label1 = new JLabel("Ghost 0: Finding Path");
  public static JLabel label2 = new JLabel("Ghost 1: Finding Path");
  public static JLabel label3 = new JLabel("Ghost 2: Finding Path");
  public static JLabel label4 = new JLabel("Ghost 3: Finding Path");
  public static JPanel panel = new JPanel(new GridLayout(4, 1));
  
  public static void main(String[] args) {
    
    Game game = new Game();
    JFrame frame = new JFrame();
    frame.setLayout(new GridLayout(1, 2));
    frame.setTitle(Game.TITLE);
    
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(label4);
    frame.add(game);
    frame.add(panel);
    frame.setResizable(false);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    
    frame.setVisible(true);
    
    game.start();
  }
  
  
  @Override
  public void keyPressed(KeyEvent e) {
    
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = true;
    if (e.getKeyCode() == KeyEvent.VK_LEFT) player.left = true;
    if (e.getKeyCode() == KeyEvent.VK_UP) player.up = true;
    if (e.getKeyCode() == KeyEvent.VK_DOWN) player.down = true;
    
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.right = false;
    if (e.getKeyCode() == KeyEvent.VK_LEFT) player.left = false;
    if (e.getKeyCode() == KeyEvent.VK_UP) player.up = false;
    if (e.getKeyCode() == KeyEvent.VK_DOWN) player.down = false;
    
  }
  
  @Override
  public void keyTyped(KeyEvent e) {
    
    
  }
  
  
}

