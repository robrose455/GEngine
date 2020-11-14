package ge;

import ge.core.Scene;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSprite extends Sprite {

    //Designates controller for sprite (Arrow Keys or WASD)
    Controller playerControls;

    //Constructor
    public PlayerSprite(int x, int y, int dx, int dy, Controller playerControls, String ip, String ba, String n,Scene sc) {

        super(x,y,dx,dy,ip,ba,n,sc);
            //Initialize All Variables to Default State or Given State

            this.playerControls = playerControls;

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

}
