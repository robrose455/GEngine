package ge;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Sprite extends JPanel {

    String name;

    int x;
    int y;
    int size_x;
    int size_y;
    int dx;
    int dy;
    int speed;

    int topBorder;
    int bottomBorder;
    int leftBorder;
    int rightBorder;

    String boundAction;

    Scene sc;
    int sHeight;
    int sWidth;

    String imagePath;
    int imageHeight;
    int imageWidth;

    boolean isVisible;

    Controller playerControls;

    public static BufferedImage image;

    public Sprite(int x, int y, int spe, Controller playerControls, Scene sc, String ip, String ba, String n) {

            this.name = n;
            this.x = x;
            this.y = y;
            this.dx = 0;
            this.dy = 0;

            this.speed = spe;
            this.boundAction = ba;
            this.playerControls = playerControls;
            this.sc = sc;
            this.isVisible = true;

            this.sHeight = sc.getHeight();
            this.sWidth = sc.getWidth();

            this.imagePath = ip;

            ImageReader ir = new ImageReader();
            image = ir.readImage(imagePath);

            imageHeight = image.getHeight();
            imageWidth = image.getWidth();


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(isVisible) {
            g.drawImage(image, x, y, null);
        }

    }

    public void CheckForMovement() {

        if (playerControls.isMovingUp()) {

            y -= speed;

            if (y <= 0) {
                switch (boundAction) {
                    case "WRAP" -> y = y + sc.getHeight();
                    case "STOP" -> speed = 0;
                    case "DIE" -> {
                        speed = 0;
                        Hide();
                    }
                }
            } else {
                setY(y);
            }
        }

        if (playerControls.isMovingDown()) {

            y += speed;

            if (y >= sc.getHeight()) {
                switch (boundAction) {
                    case "WRAP" -> y = y - sc.getHeight();
                    case "STOP" -> speed = 0;
                    case "DIE" -> {
                        speed = 0;
                        Hide();
                    }
                }
            } else {
                setY(y);
            }
        }

        if (playerControls.isMovingLeft()) {

            x -= speed;

            System.out.println(x);
            if (x <= 0) {

                switch (boundAction) {
                    case "WRAP" -> x = x + sc.getWidth();
                    case "STOP" -> speed = 0;
                    case "DIE" -> {
                        speed = 0;
                        Hide();
                    }
                }

            } else {
                setX(x);
            }

        }

        if (playerControls.isMovingRight()) {

            x += speed;

            if (x >= sc.getWidth()) {
                switch (boundAction) {
                    case "WRAP" -> x = x - sc.getWidth();
                    case "STOP" -> speed = 0;
                    case "DIE" -> {
                        speed = 0;
                        Hide();
                    }
                }
            } else {
                setX(x);
            }
        }

    }

    public void CheckCollisions() {

        boolean isCollided = false;

        topBorder = y;
        bottomBorder = y + imageHeight;
        leftBorder = x;
        rightBorder = x + imageWidth;


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

    public int getTopBorder() {
        return topBorder;
    }
    public int getBottomBorder() {
        return bottomBorder;
    }
    public int getRightBorder() {
        return rightBorder;
    }
    public int getLeftBorder() {
        return leftBorder;
    }

    public String getName() {
        return name;
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

    public void Report() {

        System.out.println("Variables for Sprite: " + name);
        System.out.println("Image Height: " + imageHeight);
        System.out.println("Image Width: " + imageWidth);
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        //System.out.println("DX: " + dx);
        //System.out.println("DY: " + dy);
        //System.out.println("Speed: " + speed);
        System.out.println("Top Border: " + topBorder);
        System.out.println("Bottom Border: " + bottomBorder);
        System.out.println("Left Border: " + leftBorder);
        System.out.println("Right Border: " + rightBorder);
    }

    public void Update() {

        CheckForMovement();
        CheckCollisions();
        playerControls.ResetKeys();

    }

}
