package ge.core;

import ge.core.SceneManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    SceneManager sm;
    boolean mouseClicked = false;

    public MouseManager(SceneManager sm) {

        System.out.println("--Creating Mouse Manager--");
        this.sm = sm;
        sm.addMouseListener(this);
        sm.addMouseMotionListener(this);

    }

    public void mouseClicked(MouseEvent e) {

        System.out.println("Mouse is clicked");
        mouseClicked = true;

    }
    public void mouseEntered(MouseEvent e) {

        //System.out.println("Mouse is Entered");
    }
    public void mouseExited(MouseEvent e) {

        //System.out.println("Mouse is Exited");
    }
    public void mousePressed(MouseEvent e) {

        //System.out.println("Mouse is Pressed");
    }
    public void mouseReleased(MouseEvent e) {

        //System.out.println("Mouse is Released");
    }
    public void mouseDragged(MouseEvent e) {

        //System.out.println("Mouse is Dragged");
    }
    public void mouseMoved(MouseEvent e) {

        //System.out.println("Mouse is Moved");
    }
    public boolean WasMouseClicked() {
        return mouseClicked;
    }
    public void Reset() {
        mouseClicked = false;
    }


}
