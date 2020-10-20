package ge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpriteArrowController extends Controller {

    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    boolean rightPressed;

    public SpriteArrowController() {

    }

    public void actionPerformed(ActionEvent e) {


    }

    public boolean isUpPressed() {
        return upPressed;
    }
    public boolean isDownPressed() {
        return downPressed;
    }
    public boolean isLeftPressed() {
        return leftPressed;
    }
    public boolean isRightPressed() {
        return rightPressed;
    }

    public void upIsPressed() {
        upPressed = true;
    }
    public void downIsPressed() {
        downPressed = true;
    }
    public void leftIsPressed() {
        leftPressed = true;
    }
    public void rightIsPressed() {
        rightPressed = true;
    }

    public void ResetArrowKeys() {

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

    }
}
