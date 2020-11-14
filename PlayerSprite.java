package ge;

import ge.core.Scene;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSprite extends Sprite {

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
    Controller playerControls;

    //Constructor
    public PlayerSprite(int x, int y, int dx, int dy, Controller playerControls, String ip, String ba, String n,Scene sc) {

        super(x,y,dx,dy,ip,ba,n,sc);
            //Initialize All Variables to Default State or Given State
            this.name = n;
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
            this.sc = sc;
            this.speed = 10;
            this.boundAction = ba;
            this.playerControls = playerControls;
            this.isVisible = true;

            this.sHeight = sc.getHeight();
            this.sWidth = sc.getWidth();

            this.imagePath = ip;

            ImageReader ir = new ImageReader();
            image = ir.readImage(imagePath);
            imageFailed = ir.didImageFail();
            
            if(!imageFailed) {
                height = image.getHeight();
                width = image.getWidth();
            } else {
                height = 100;
                width = 100;
            }

    }

    //Checks movement through player controller
    public void CheckForMovement() {

        if (playerControls.isMovingUp()) {

            dy = -3;
            dx = 0;

        }

        if (playerControls.isMovingDown()) {

            dy = 3;
            dx = 0;


        }

        if (playerControls.isMovingLeft()) {

            dx = -3;
            dy = 0;


        }

        if (playerControls.isMovingRight()) {

            System.out.println("I REALLY should be moving right");
            dx = 3;
            dy = 0;

        }

        CheckForBounds();
        y += dy;
        x += dx;

    }

    @Override
    public void Update() {

        CheckForMovement();
        playerControls.ResetKeys();

    }

    @Override
    public String TypeOfObject() {

        System.out.println("PLayer Sprite");
        return "PlayerSprite";

    }

    public Controller getPlayerControls() {

        return playerControls;

    }

    @Override
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
        System.out.println("Type of Controller: " + getPlayerControls());

    }

    @Override
    public void DrawSprite(Graphics g) {

        if(isVisible) {

            if(imageFailed){
                g.setColor(Color.RED);
                g.fillRect(x,y,100,100);
            }

            else {
                g.drawImage(image, x, y, null);
            }
        }

    }

}
