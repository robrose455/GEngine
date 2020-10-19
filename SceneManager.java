package ge;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneManager extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    int oldX;
    int oldY;
    int newX;
    int newY;
    int player_x;
    int player_y;
    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    boolean rightPressed;

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    Timer t = new Timer(10, this);

    public SceneManager() {

        oldX = 0;
        oldY = 0;
        newX = 0;
        newY = 0;
        player_x = 0;
        player_y = 0;

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

        addMouseListener(this);
        addMouseMotionListener(this);

        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upA");
        this.getActionMap().put("upA", upAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downA");
        this.getActionMap().put("downA", downAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftA");
        this.getActionMap().put("leftA", leftAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightA");
        this.getActionMap().put("rightA", rightAction);

        t.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("Drawing Rectanlge");
        g.setColor(Color.RED);
        g.fillRect(player_x, player_y, 10, 50);

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

    public class UpAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going up");
            upPressed = true;
        }
    }
    public class DownAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going down");
            downPressed = true;
        }
    }
    public class LeftAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going left");
            leftPressed = true;
        }
    }
    public class RightAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going right");
            rightPressed = true;
        }
    }
    public void actionPerformed(ActionEvent e) {

        Update();

    }

    public void Update() {

        if (upPressed) {
            player_y -= 10;
        }
        if (downPressed) {
            player_y += 10;
        }
        if (rightPressed) {
            player_x += 10;
        }
        if (leftPressed) {
            player_x -= 10;
        }
        this.repaint();
        ResetKeys();

    }

    public void ResetKeys() {

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

    }
}