package ge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SceneManager extends JPanel implements MouseListener, MouseMotionListener {

    int oldX;
    int oldY;
    int newX;
    int newY;

    public SceneManager() {

        oldX = 0;
        oldY = 0;
        newX = 0;
        newY = 0;

        addMouseListener(this);
        addMouseMotionListener(this);

    }

    public void paintComponent(Graphics g) {

    }

    public int getOldX() {
        return oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }

    public void mouseClicked(MouseEvent e) {

        //System.out.println("Mouse is clicked");
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
        oldX = newX;
        oldY = newY;

        newX = e.getX();
        newY = e.getY();

    }
}