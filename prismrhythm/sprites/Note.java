package ge.prismrhythm.sprites;

import ge.core.managers.KeyManager;
import ge.core.sprite.Sprite;

import java.awt.*;

public class Note extends Sprite {

    boolean used = false;
    boolean hit = false;

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
                x = 579;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            } else if (imagePath.equals("ORANGE")){
                x = 629;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            } else if (imagePath.equals("YELLOW")){
                x = 679;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            }  else if (imagePath.equals("WHITE")) {
                x = 729;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            } else if (imagePath.equals("PURPLE")) {
                x = 429;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            } else if (imagePath.equals("BLUE")) {
                x = 379;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            } else if (imagePath.equals("LBLUE")) {
                x = 329;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            } else if (imagePath.equals("GREEN")) {
                x = 279;
                g.setColor(Color.decode("#000000"));
                g.fillRect(x,y,40,40);
            }
        }
    }

    public void hit(){
        hit = true;
    }
    public boolean isHit() {
        return hit;
    }
    public boolean hasBeenUsed() {
        return used;
    }
    public void used() {
        used = true;
        Hide();
    }
}
