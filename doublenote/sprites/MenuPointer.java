package ge.doublenote.sprites;

import ge.core.managers.KeyManager;
import ge.core.sprite.Sprite;

import java.awt.*;

public class MenuPointer extends Sprite {

    int xbase = 260;
    int ybase = 260;
    int [] xArr = {xbase, xbase + 25, xbase};
    int [] yArr = {ybase, ybase + 25, ybase + 50};
    int arrLength = 3;

    int numSongs;

    public MenuPointer(int x, int y, int dx, int dy, String ip, String ba, String n, KeyManager km, int numSongs) {
        super(x, y, dx, dy, ip, ba, n, km);

        this.numSongs = numSongs;

    }

    @Override
    public void DrawSprite(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillPolygon(xArr,yArr,arrLength);

    }

    public void Update() {
        CheckForMovement();
        km.ResetMovement();
    }

    public void CheckForMovement() {

        if (km.movingUp() && (yArr[0] > ybase )) {

            yArr[0] -= 50;
            yArr[1] -= 50;
            yArr[2] -= 50;

        }

        if (km.movingDown() && (yArr[0] < ((numSongs-1)* 50) + ybase)) {

            yArr[0] += 50;
            yArr[1] += 50;
            yArr[2] += 50;

        }
    }

    public void Reset() {

        yArr[0] = 260;
        yArr[1] = 260 + 25;
        yArr[2] = 260 + 50;

    }
}
