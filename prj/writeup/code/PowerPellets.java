import java.awt.*;

/**
 * Created by RyanNeumann on 5/2/17.
 */
public class PowerPellets extends Rectangle {

    public PowerPellets(int x, int y) {

        setBounds(x+10, y+8, 8, 8);

    }

    public void render(Graphics g) {

        SpriteSheet sheet = Game.spritesheet;
        g.drawImage(sheet.getSprite("pellet"), x, y + 5, 10, 10, null);

    }

}
