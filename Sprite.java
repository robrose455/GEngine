package ge;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends JPanel {

    String name;

    //Positional Parameters
    int x;
    int y;
    int dx;
    int dy;
    int speed;

    //Collision Detection Parameters
    int topBorder;
    int bottomBorder;
    int leftBorder;
    int rightBorder;

    //What to do when out of bounds
    String boundAction;

    //Scene Reference and Parameters
    Scene sc;
    int sHeight;
    int sWidth;

    //Image Parameters
    String imagePath;
    int imageHeight;
    int imageWidth;

    public static BufferedImage image;

    //Is he dead or alive
    boolean isVisible;
    boolean isDead;

    //Designates controller for sprite (Arrow Keys or WASD)
    Controller playerControls;

    //Constructor
    public Sprite(int x, int y, int spe, Controller playerControls, Scene sc, String ip, String ba, String n) {

            //Initialize All Variables to Default State or Given State
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

    //When called will paint sprite onto scene
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(isVisible) {
            g.drawImage(image, x, y, null);
        }

    }

    //Checks movement through player controller
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

    //Get and Set
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

    public boolean getVisibility() {
        return isVisible;
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
    public void setSpeed(int s) {
        this.speed = s;
    }

    public void changeVisibility() {

        if (isVisible) {
            isVisible = false;
        } else {
            isVisible = true;
        }
    }

    //Called to declare this variable has died in-game
    public void Death(boolean b) {
        this.isDead = b;
    }

    //Changes Visibility
    public void Hide() {
        isVisible = false;
    }
    public void Show() {
        isVisible = true;
    }

    //Shows needed Parameters about given variable
    //Can be called by default by clicking on the scene
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

    //Checks for movement every frame the sprite is active
    public void Update() {

        CheckForMovement();
        playerControls.ResetKeys();

    }

    //Collision Detection
    public boolean collidesWith(Sprite s) {

        boolean collision = false;

        if (this.isVisible && s.getVisibility()) {

            updateBorders();
            s.updateBorders();

            int aTop = topBorder;
            int aBottom = bottomBorder;
            int aLeft = leftBorder;
            int aRight = rightBorder;

            int bTop = s.getTopBorder();
            int bBottom = s.getBottomBorder();
            int bLeft = s.getLeftBorder();
            int bRight = s.getRightBorder();

            collision = true;

            if ((aBottom < bTop) ||
                    (aTop > bBottom) ||
                    (aRight < bLeft) ||
                    (aLeft > bRight)) {

                collision = false;

            }
        }

        //If Collision is detected, perform the collision action (In this case, death :D )
        if(collision) {

            CollisionAction();
            s.CollisionAction();
        }

        return collision;
    }

    //Helper function for collisions detection
    public void updateBorders() {

        topBorder = y;
        bottomBorder = y + imageHeight;
        leftBorder = x;
        rightBorder = x + imageWidth;

    }

    //Declares what the sprite will do on collision
    public void CollisionAction() {

        isDead = true;
        speed = 0;

    }

}
