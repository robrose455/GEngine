package ge.core.sprite;

import ge.core.KeyManager;

public class PlayerSprite extends Sprite {

    //Designates controller for sprite (Arrow Keys or WASD)
    public String playerControls;
    public KeyManager km;

    //Constructor
    public PlayerSprite(int x, int y, int dx, int dy, String playerControls, String ip, String ba, String n, KeyManager km) {

        super(x,y,dx,dy,ip,ba,n, km);
            //Initialize All Variables to Default State or Given State
            this.playerControls = playerControls;
            this.km = km;

    }


    //Checks movement through player controller
    @Override
    public void CheckForMovement(){ }

    @Override
    public void Update() {

        CheckForMovement();

    }

    @Override
    public String TypeOfObject() {

        System.out.println("PLayer Sprite");
        return "PlayerSprite";

    }

    public String getPlayerControls() {

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
        System.out.println("Speed: " + speed);
        System.out.println("Top Border: " + topBorder);
        System.out.println("Bottom Border: " + bottomBorder);
        System.out.println("Left Border: " + leftBorder);
        System.out.println("Right Border: " + rightBorder);
        System.out.println("Type of Controller: " + getPlayerControls());

    }

}
