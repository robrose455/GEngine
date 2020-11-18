package ge.doublenote.sprite;

import ge.core.KeyManager;
import ge.core.sprite.Sprite;

import java.awt.*;

public class Note extends Sprite {

    public Note(int x, int y, int dx, int dy, String ip, String ba, String n, KeyManager km) {
        super(x, y, dx, dy, ip, ba, n, km);

    }

    @Override
    public void CheckForMovement() {
        ScrollTrack();
    }

    public void ScrollTrack() {

        y += dy;

    }

    @Override
    public void DrawSprite(Graphics g) {

        if(isVisible) {

            if(imagePath.equals("RED")){
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("ORANGE")){
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("YELLOW")){
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            }  else if (imagePath.equals("WHITE")) {
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("BLUE")) {
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("PURPLE")) {
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("GREEN")) {
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("LBLUE")) {
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            }
        }
        else {
            g.drawImage(image, x, y, null);
        }
    }
}
