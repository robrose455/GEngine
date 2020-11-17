package ge.core.sprite.controller;

import ge.core.sprite.controller.Controller;

import java.awt.event.ActionEvent;

public class SpriteArrowController extends Controller {

    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    boolean rightPressed;

    public SpriteArrowController() {
    }

    public boolean isMovingUp() {
        return upPressed;
    }
    public boolean isMovingDown() {
        return downPressed;
    }
    public boolean isMovingLeft() {
        return leftPressed;
    }
    public boolean isMovingRight() {
        return rightPressed;
    }

    public void movingUp() {
        upPressed = true;
    }
    public void movingDown() {
        downPressed = true;
    }
    public void movingLeft() {
        leftPressed = true;
    }
    public void movingRight() {
        rightPressed = true;
    }

    //Resets Keys for the next frame
    public void ResetKeys() {

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

    }

    public String typeOfController() {
        return "Arrows";
    }
}
