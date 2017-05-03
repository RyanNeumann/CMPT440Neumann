import java.awt.*;

/**
 * Created by RyanNeumann on 5/2/17.
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
