package ge;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Sprite extends JPanel {

    int player_x;
    int player_y;
    int size_x;
    int size_y;
    int playerSpeed;
    int playerColor;
    Controller playerControls;


    public static BufferedImage image;

    public Sprite(int px, int py, int sx, int sy, int pc, int ps, Controller playerControls) {

            this.player_x = px;
            this.player_y = py;
            this.size_x = sx;
            this.size_y = sy;
            this.playerColor = pc;
            this.playerSpeed = ps;
            this.playerControls = playerControls;

            ImageReader ir = new ImageReader();
            image = ir.readImage("C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\Cranberry.png");

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*switch (playerColor) {

            case 1 :
                g.setColor(Color.RED);
                break;
            case 2 :
                g.setColor(Color.BLUE);
                break;
            case 3 :
                g.setColor(Color.YELLOW);
                break;
            case 4 :
                g.setColor(Color.GREEN);
                break;
        }*/

        g.drawImage(image, player_x, player_y, null);

    }
    
}
