import org.w3c.dom.css.Rect;

import java.awt.*;


/**
 * Created by RyanNeumann on 5/2/17.
 */
public class Player extends Rectangle{


    public boolean right,left,up,down;
    private int speed = 4;

    private int time = 0, targetTime = 10;
    private int imageIndex = 0;
    private int lastDir = 1;
    public boolean running;


    public Player(int x, int y){

        setBounds(x,y,32,32);

    }

    public void tick() {

        if(right && canMove(x+speed, y)) {
            x += speed;
            lastDir = 1;
        }

        if(left && canMove(x-speed, y)) {
            x -= speed;
            lastDir = -1;
        }


        if(up && canMove(x,y-speed))y-=speed;
        if(down && canMove(x, y+speed))y+=speed;

        Level level = Game.level;

        for(int i = 0; i < level.powerPellets.size(); i++){

            if(this.intersects(level.powerPellets.get(i))) {

                level.powerPellets.remove(i);
                level.pelletCount++;
                break;

            }
        }

        for(int i = 0; i < level.candies.size(); i++){

            if(this.intersects(level.candies.get(i))) {


                level.candies.remove(i);

                break;

            }
        }

        if(level.powerPellets.size() == 0) {
            //Game over, you win!

            Game.player = new Player(0,0);
            Game.level = new Level("/Map/board1.png");
            return;

        }

        time++;

        if (time == targetTime) {

            time = 0;
            imageIndex++;

        }

        for(int i = 0; i < Game.level.enemies.size(); i++) {

            Enemy en = Game.level.enemies.get(i);

            if (en.intersects(this)) {

                if (Game.level.candies.size() == 1) {
                    System.exit(0);
                } else {
                    level.enemies.remove(i);

                    if (i == 0) {


                        Game.label1.setText("Ghost 0: Eatten");

                    } else if (i == 1) {


                        Game.label2.setText("Ghost 1: Eatten");

                    } else if (i == 2) {


                        Game.label3.setText("Ghost 2: Eatten");

                    } else if (i == 3) {


                        Game.label4.setText("Ghost 3: Eatten");

                    }

                }

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

    int v = 0;

    public void render(Graphics g){

        SpriteSheet sheet = Game.spritesheet;

        if (lastDir == 1) {

            if ((imageIndex % 2) == 0) {
                g.drawImage(sheet.getSprite("pacman"), x, y , width, height, null);
            } else {

                g.drawImage(sheet.getSprite("open"), x, y, width, height, null);

            }

        } else {

            if ((imageIndex % 2) == 0) {
                g.drawImage(sheet.getSprite("pacman"), x + 32, y, -width, height, null);
            } else {

                g.drawImage(sheet.getSprite("open"), x + 32, y, -width, height, null);

            }

        }

    }

}