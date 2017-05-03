import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by RyanNeumann on 5/2/17.
 */
public class Level {

    public int width;
    public int height;

    public Tile[][] tiles;

    public List<PowerPellets> powerPellets;
    public List<Enemy> enemies;
    public List<Candy> candies;

    public int pelletCount;

    public Level(String path) {

        powerPellets = new ArrayList<>();
        enemies = new ArrayList<>();
        candies = new ArrayList<>();

        try {

            BufferedImage map = ImageIO.read(getClass().getResource(path));
            this.height = map.getHeight();
            this.width = map.getWidth();
            int[] pixels = new int[width*height];
            tiles = new Tile[width][height];
            map.getRGB(0, 0, width, height, pixels, 0, width);


            for(int xx = 0; xx < width; xx++){
                for(int yy = 0; yy < height; yy++){

                    int val = pixels[xx + (yy*width)];

                    if(val == 0xFF000000){
                        //Tile
                        tiles[xx][yy] = new Tile(xx*32, yy*32);


                    } else if(val == 0xFF00FF00) {
                        //Player
                        Game.player.x = xx*32;
                        Game.player.y = yy*32;

                    } else if(val == 0xFFFF0000) {
                        //Enemy
                        enemies.add(new Enemy(xx*32, yy*32));

                    } else if (val == 0xFF00FFFF) {
                        //
                        candies.add(new Candy(xx*32, yy*32));

                    } else {

                        powerPellets.add(new PowerPellets(xx*32, yy*32));

                    }

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void tick(){

        for(int i = 0; i < enemies.size(); i++) {

            enemies.get(i).tick();

            if(i == 0) {

                Game.test = 0;

            } else if (i == 1) {

                Game.test = 1;

            } else if (i == 2) {

                Game.test = 2;


            } else if (i == 3) {

                Game.test = 3;

            }


        }


    }



    public void render(Graphics g) {
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    if(tiles[x][y] != null) tiles[x][y].render(g);
            }
        }

        for(int i = 0; i < powerPellets.size(); i++) {

                powerPellets.get(i).render(g);

        }

        for(int i = 0; i < enemies.size(); i++) {

            enemies.get(i).render(g);

        }

        for(int i = 0; i < candies.size(); i++) {

            candies.get(i).render(g);

        }

    }

}
