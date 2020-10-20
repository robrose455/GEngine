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

            playerControls.typeOfController();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, player_x, player_y, null);

    }

    public void setPlayer_x(int x){
        player_x = x;
    }
    public void setPlayer_y(int y){
        player_y = y;
    }
    public void setPos(int x, int y) {
        setPlayer_x(x);
        setPlayer_y(y);
    }

}
