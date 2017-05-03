import java.awt.*;

/**
 * Created by RyanNeumann on 5/2/17.
 */
public class Tile extends Rectangle {

    public Tile(int x, int y) {

        setBounds(x,y,32,32);

    }

    public void render(Graphics g) {

        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }

}
