package ge.prismrhythm.sprites;

import ge.core.managers.KeyManager;
import ge.core.sprite.Sprite;

import java.awt.*;

public class NoteHitter extends Sprite {

    boolean pressed;

    public NoteHitter(int x, int y, int dx, int dy, String ip, String ba, String n, KeyManager km) {
        super(x, y, dx, dy, ip, ba, n, km);

        pressed = false;
        isVisible = false;


    }

    @Override
    public void Update() {

        CheckHits();

    }

    public void CheckHits() {


        if (km.j() && name.equals("RedHitter")) {
            Show();
            pressed = true;
        } else if (km.k() && name.equals("OrangeHitter")) {
            Show();
            pressed = true;
        } else if (km.l() && name.equals("YellowHitter")) {
            Show();
            pressed = true;
        } else if (km.sc() && name.equals("WhiteHitter")) {
            Show();
            pressed = true;
        } else if (km.f() && name.equals("PurpleHitter")) {
            Show();
            pressed = true;
        } else if (km.d() && name.equals("BlueHitter")) {
            Show();
            pressed = true;
        } else if (km.s() && name.equals("LBlueHitter")) {
            Show();
            pressed = true;
        } else if (km.a() && name.equals("GreenHitter")) {
            Show();
            pressed = true;
        } else {
            pressed = false;
            Hide();
        }

    }

    public void DrawSprite(Graphics g) {

        if(isVisible) {

            switch (imagePath) {
                case "RED" -> {
                    g.setColor(Color.decode("#fc0303"));
                    g.fillRect(x, y, 50, 50);
                }
                case "ORANGE" -> {
                    g.setColor(Color.decode("#ff8000"));
                    g.fillRect(x, y, 50, 50);
                }
                case "YELLOW" -> {
                    g.setColor(Color.decode("#f6fa02"));
                    g.fillRect(x, y, 50, 50);
                }
                case "WHITE" -> {
                    g.setColor(Color.decode("#9a9da1"));
                    g.fillRect(x, y, 50, 50);
                }
                case "BLUE" -> {
                    g.setColor(Color.decode("#0509fa"));
                    g.fillRect(x, y, 50, 50);
                }
                case "PURPLE" -> {
                    g.setColor(Color.decode("#c203fc"));
                    g.fillRect(x, y, 50, 50);
                }
                case "GREEN" -> {
                    g.setColor(Color.decode("#00ff11"));
                    g.fillRect(x, y, 50, 50);
                }
                case "LBLUE" -> {
                    g.setColor(Color.decode("#00ab80"));
                    g.fillRect(x, y, 50, 50);
                }
            }
        }
    }

    public boolean isPressed() {
        return pressed;
    }

}
