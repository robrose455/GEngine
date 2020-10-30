package ge;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class SceneObject extends JPanel {

    int x;
    int y;
    int size_x;
    int size_y;
    int dx;
    int dy;
    int speed;

    Scene sc;
    int sHeight;
    int sWidth;

    String imagePath;

    boolean isVisible;

    public static BufferedImage image;

    public SceneObject(int x, int y, int sx, int sy, int ps, Scene sc, String ip) {

        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.size_x = sx;
        this.size_y = sy;
        this.speed = ps;

        this.sc = sc;
        this.isVisible = true;

        this.sHeight = sc.getHeight();
        this.sWidth = sc.getWidth();

        this.imagePath = ip;

        ImageReader ir = new ImageReader();
        image = ir.readImage(imagePath);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(isVisible) {
            g.drawImage(image, x, y, null);
        }

    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setPos(int x, int y) {
        setX(x);
        setY(y);
    }

    public void changeVisibility() {

        if (isVisible) {
            isVisible = false;
        } else {
            isVisible = true;
        }
    }

    public void Hide() {
        isVisible = false;
    }
    public void Show() {
        isVisible = true;
    }

}
