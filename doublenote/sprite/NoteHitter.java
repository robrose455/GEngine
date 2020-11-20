package ge.doublenote.sprite;

import ge.core.KeyManager;
import ge.core.sprite.Sprite;

import java.awt.*;

public class NoteHitter extends Sprite {

    boolean l = true;

    public NoteHitter(int x, int y, int dx, int dy, String ip, String ba, String n, KeyManager km) {
        super(x, y, dx, dy, ip, ba, n, km);

        isVisible = false;


    }

    @Override
    public void Update() {

        CheckHits();

    }

    public void CheckHits() {


        if (km.j() && name.equals("RedHitter")) {
            Show();
        } else if (km.k() && name.equals("OrangeHitter")) {
            Show();
        } else if (km.l() && name.equals("YellowHitter")) {
            Show();
        } else if (km.sc() && name.equals("WhiteHitter")) {
            Show();
        } else if (km.f() && name.equals("PurpleHitter")) {
            Show();
        } else if (km.d() && name.equals("BlueHitter")) {
            Show();
        } else if (km.s() && name.equals("LBlueHitter")) {
            Show();
        } else if (km.a() && name.equals("GreenHitter")) {
            Show();
        } else {
            Hide();
        }

    }

    public void DrawSprite(Graphics g) {

        if(isVisible) {

            if(imagePath.equals("RED")){
                g.setColor(Color.decode("#fc0303"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("ORANGE")){
                g.setColor(Color.decode("#ff8000"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("YELLOW")){
                g.setColor(Color.decode("#f6fa02"));
                g.fillRect(x,y,50,50);
            }  else if (imagePath.equals("WHITE")) {
                g.setColor(Color.decode("#9a9da1"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("BLUE")) {
                g.setColor(Color.decode("#0509fa"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("PURPLE")) {
                g.setColor(Color.decode("#c203fc"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("GREEN")) {
                g.setColor(Color.decode("#00ff11"));
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("LBLUE")) {
                g.setColor(Color.decode("#00ab80"));
                g.fillRect(x,y,50,50);
            }
        }
        else {
            g.drawImage(image, x, y, null);
        }
    }

    public KeyManager getKeyManager() {
        return km;
    }


}
