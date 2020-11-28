package ge.prismrhythm.sprites;

import ge.core.managers.KeyManager;
import ge.core.sprite.Sprite;

import java.awt.*;

public class Note extends Sprite {

    boolean missed = false;
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

            switch (imagePath) {
                case "RED" -> {
                    x = 579;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
                case "ORANGE" -> {
                    x = 629;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
                case "YELLOW" -> {
                    x = 679;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
                case "WHITE" -> {
                    x = 729;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
                case "PURPLE" -> {
                    x = 429;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
                case "BLUE" -> {
                    x = 379;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
                case "LBLUE" -> {
                    x = 329;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
                case "GREEN" -> {
                    x = 279;
                    g.setColor(Color.decode("#000000"));
                    g.fillRect(x, y, 40, 40);
                }
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

    public void missed() {
        missed = true;
    }

    public boolean hasBeenMissed() {
        return missed;
    }
}
