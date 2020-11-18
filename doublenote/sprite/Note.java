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
                x = 575;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("ORANGE")){
                x = 625;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("YELLOW")){
                x = 675;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            }  else if (imagePath.equals("WHITE")) {
                x = 725;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("PURPLE")) {
                x = 425;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("BLUE")) {
                x = 375;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("LBLUE")) {
                x = 325;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("GREEN")) {
                x = 275;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,50,50);
            }
        }
        else {
            g.drawImage(image, x, y, null);
        }
    }
}
