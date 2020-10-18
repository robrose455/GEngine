package ge;

import javax.swing.*;
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

        System.out.println("Mouse is clicked");
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

        System.out.println("Jaina is a retard");
    }

    public void mouseMoved(MouseEvent e) {

    }
}