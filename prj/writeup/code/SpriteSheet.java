import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by RyanNeumann on 5/2/17.
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

        } catch(IOException e){

            System.out.println("Failed to load image");

        }

    }

    public BufferedImage getSprite(String name){

        if(name == "pacman") {

            return pacMan;

        } else if(name == "open") {

            return pacManOpen;

        } else if (name == "pellet") {

            return pellet;

        }  else if (name == "candy") {

            return candy;

        } else if (name == "enemy2") {

            return enemy2;

        }   else {

            return enemy;

        }

    }

}
