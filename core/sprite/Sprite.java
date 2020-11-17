package ge.core.sprite;

import ge.core.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends JPanel {


    public String name;

    //Positional Parameters
    public int x;
    public int y;
    public int dx;
    public int dy;
    public int speed;

    //Collision Detection Parameters
    public int topBorder;
    public int bottomBorder;
    public int leftBorder;
    public int rightBorder;

    //What to do when out of bounds
    public String boundAction;

    //Scene Reference and Parameters

    public int sHeight = 1000;
    public int sWidth = 1000;

    //Image Parameters
    public String imagePath;
    public int height;
    public int width;
    public boolean imageFailed = false;
    public  BufferedImage image;

    //Is he dead or alive
    public boolean isVisible;
    public boolean isDead;

    //Designates controller for sprite (Arrow Keys or WASD)

    //Constructor
    public Sprite(int x, int y, int dx, int dy, String ip, String ba, String n) {

        //Initialize All Variables to Default State or Given State
        System.out.println("--Creating Sprite--");
        this.name = n;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.speed = 10;
        this.boundAction = ba;
        this.isVisible = true;

        this.imagePath = ip;

        ImageReader ir = new ImageReader();
        this.image = ir.readImage(imagePath);
        this.imageFailed = ir.didImageFail();

        if(!imageFailed) {
            height = image.getHeight();
            width = image.getWidth();
        } else {
            height = 50;
            width = 50;
        }
    }

    public void ResetToPos(int x, int y) {

        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.isDead = false;

    }
    //When called will paint sprite onto scene
    public void DrawSprite(Graphics g) {

        if(isVisible) {

            if(imagePath.equals("Red")){
                g.setColor(Color.RED);
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("Blue")){
                g.setColor(Color.BLUE);
                g.fillRect(x,y,50,50);
            } else if (imagePath.equals("BlueT")){
                g.setColor(Color.BLUE);
                g.fillOval(x,y, 25,25);
            }  else if (imagePath.equals("RedT")) {
                g.setColor(Color.RED);
                g.fillOval(x, y, 25, 25);
            }
        }
            else {
                g.drawImage(image, x, y, null);
            }
    }

    public void CheckForBounds() {

        if (y <= 0) {
            switch (boundAction) {
                case "WRAP" -> y = y + 1000;
                case "STOP" -> {
                    dx = 0;
                    dy = 0;
                }
                case "DIE" -> {
                    dx = 0;
                    dy = 0;
                    Hide();
                }
            }
        } else {
            setY(y);
        }

        if (y >= 1000) {
            switch (boundAction) {
                case "WRAP" -> y = y - 1000;
                case "STOP" -> {
                    dx = 0;
                    dy = 0;
                }
                case "DIE" -> {
                    dx = 0;
                    dy = 0;
                    Hide();
                }
            }
        } else {
            setY(y);
        }

        if (x <= 0) {

            switch (boundAction) {
                case "WRAP" -> x = x + 1000;
                case "STOP" -> {
                    dx = 0;
                    dy = 0;
                }
                case "DIE" -> {
                    dx = 0;
                    dy = 0;
                    Hide();
                }

            }

        } else {
            setX(x);
        }

        if (x >= 1000) {
            switch (boundAction) {
                case "WRAP" -> x = x - 1000;
                case "STOP" -> {
                    dx = 0;
                    dy = 0;
                }
                case "DIE" -> {
                    dx = 0;
                    dy = 0;
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
    public boolean Death() {
        return isDead;
    }

    //Changes Visibility
    public void Hide() {
        isVisible = false;
        isDead = true;
    }
    public void Show() {
        isVisible = true;
        isDead = false;
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
    public void Update() {}

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


    }

    public String TypeOfObject() {

        System.out.println("Sprite");
        return "Sprite";

    }
}
