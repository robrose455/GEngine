package ge;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Sprite extends JPanel {

    int x;
    int y;
    int size_x;
    int size_y;
    int dx;
    int dy;
    int player_speed;

    String boundAction;

    Scene sc;
    int sHeight;
    int sWidth;

    String imagePath;

    boolean isVisible;

    Controller playerControls;


    public static BufferedImage image;

    public Sprite(int x, int y, int sx, int sy, int ps, Controller playerControls, Scene sc, String ip, String ba) {

            this.x = x;
            this.y = y;
            this.dx = 0;
            this.dy = 0;
            this.size_x = sx;
            this.size_y = sy;
            this.player_speed = ps;
            this.boundAction = ba;
            this.playerControls = playerControls;
            this.sc = sc;
            this.isVisible = true;

            this.sHeight = sc.getHeight();
            this.sWidth = sc.getWidth();

            this.imagePath = ip;

            ImageReader ir = new ImageReader();
            image = ir.readImage(imagePath);

            playerControls.typeOfController();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(isVisible) {
            g.drawImage(image, x, y, null);
        }

    }

    public void CheckForMovement() {

        if (playerControls.isMovingUp()) {

            y -= player_speed;

            if (y <= 0) {
                switch (boundAction) {
                    case "WRAP" -> y = y + sc.getHeight();
                    case "STOP" -> player_speed = 0;
                    case "DIE" -> {
                        player_speed = 0;
                        Hide();
                    }
                }
            } else {
                setY(y);
            }
        }

        if (playerControls.isMovingDown()) {

            y += player_speed;

            if (y >= sc.getHeight()) {
                switch (boundAction) {
                    case "WRAP" -> y = y - sc.getHeight();
                    case "STOP" -> player_speed = 0;
                    case "DIE" -> {
                        player_speed = 0;
                        Hide();
                    }
                }
            } else {
                setY(y);
            }
        }

        if (playerControls.isMovingLeft()) {

            x -= player_speed;

            System.out.println(x);
            if (x <= 0) {

                switch (boundAction) {
                    case "WRAP" -> x = x + sc.getWidth();
                    case "STOP" -> player_speed = 0;
                    case "DIE" -> {
                        player_speed = 0;
                        Hide();
                    }
                }

            } else {
                setX(x);
            }

        }

        if (playerControls.isMovingRight()) {

            x += player_speed;

            if (x >= sc.getWidth()) {
                switch (boundAction) {
                    case "WRAP" -> x = x - sc.getWidth();
                    case "STOP" -> player_speed = 0;
                    case "DIE" -> {
                        player_speed = 0;
                        Hide();
                    }
                }
            } else {
                setX(x);
            }
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
