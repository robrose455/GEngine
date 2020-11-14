package ge;

import ge.core.Scene;

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
    int height;
    int width;
    boolean imageFailed = false;
    public static BufferedImage image;

    //Is he dead or alive
    boolean isVisible;
    boolean isDead;

    //Designates controller for sprite (Arrow Keys or WASD)
    Controller playerControls = new NullController();

    //Constructor
    public Sprite(int x, int y, int dx, int dy, String ip, String ba, String n, Scene sc) {

        //Initialize All Variables to Default State or Given State
        this.name = n;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.sc = sc;
        this.speed = 10;
        this.boundAction = ba;
        this.isVisible = true;

        this.sHeight = sc.getHeight();
        this.sWidth = sc.getWidth();

        this.imagePath = ip;

        ImageReader ir = new ImageReader();
        this.image = ir.readImage(imagePath);
        System.out.println("Object Image: " + this.image);
        this.imageFailed = ir.didImageFail();

        if(!imageFailed) {
            height = image.getHeight();
            width = image.getWidth();
        } else {
            height = 50;
            width = 50;
        }
    }

    //When called will paint sprite onto scene

    public void DrawSprite(Graphics g) {

        if(isVisible) {

            if(imagePath.equals("Red")){
                g.setColor(Color.GREEN);
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("Blue")){
                g.setColor(Color.BLUE);
                g.fillRect(x,y,50,50);
            }

            else {
                g.drawImage(image, x, y, null);
            }
        }

    }

    public void CheckForBounds() {

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

    public void setDx(int x) { this.dx = dx; }
    public void setDy(int y) { this.dy = dy; }

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
    public void Report() {

        System.out.println("\nVariables for Sprite: " + name);
        System.out.println("Image Height: " + height);
        System.out.println("Image Width: " + width);
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        System.out.println("DX: " + dx);
        System.out.println("DY: " + dy);
        //System.out.println("Speed: " + speed);
        //System.out.println("Top Border: " + topBorder);
        //System.out.println("Bottom Border: " + bottomBorder);
       //System.out.println("Left Border: " + leftBorder);
       //System.out.println("Right Border: " + rightBorder);

    }

    //Checks for movement every frame the sprite is active
    public void Update() {


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
        bottomBorder = y + height;
        leftBorder = x;
        rightBorder = x + width;

    }

    //Declares what the sprite will do on collision
    public void CollisionAction() {

        isDead = true;
        speed = 0;

    }

    public String TypeOfObject() {

        System.out.println("Sprite");
        return "Sprite";

    }
}
