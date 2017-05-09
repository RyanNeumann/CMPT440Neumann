import java.awt.*;

/**
 * file: Candy.java
 * author: Ryan Neumann
 * course: CMPT 440
 * assignment: Semester Project
 * due date: 10 May 2017
 * version: 1.0
 *
 * This file contains the code to pull the candy image,
 * as well as create the boundaries around them.
 *
 */


public class Candy extends Rectangle {

    public Candy(int x, int y) {

        setBounds(x+10, y+8, 8, 8);

    }

    public void render(Graphics g) {

        SpriteSheet sheet = Game.spritesheet;
        g.drawImage(sheet.getSprite("candy"), x, y, 10, 20, null);

    }
}
