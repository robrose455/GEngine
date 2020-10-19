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
    int player_speed;

    int player1_x;
    int player1_y;

    int player2_x;
    int player2_y;

    boolean upPressed;
    boolean downPressed;
    boolean leftPressed;
    boolean rightPressed;

    boolean wPressed;
    boolean sPressed;
    boolean aPressed;
    boolean dPressed;

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    Action wAction;
    Action sAction;
    Action aAction;
    Action dAction;

    Timer t = new Timer(10, this);

    public SceneManager() {

        this.setBackground(Color.BLACK);

        oldX = 0;
        oldY = 0;
        newX = 0;
        newY = 0;

        player1_x = 0;
        player1_y = 0;

        player2_x = 300;
        player2_y = 0;

        player_speed = 10;

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

        wPressed = false;
        sPressed = false;
        aPressed = false;
        dPressed = false;

        addMouseListener(this);
        addMouseMotionListener(this);

        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        wAction = new wAction();
        sAction = new sAction();
        aAction = new aAction();
        dAction = new dAction();

        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upA");
        this.getActionMap().put("upA", upAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downA");
        this.getActionMap().put("downA", downAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftA");
        this.getActionMap().put("leftA", leftAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightA");
        this.getActionMap().put("rightA", rightAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "wA");
        this.getActionMap().put("wA", wAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("S"), "sA");
        this.getActionMap().put("sA", sAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "aA");
        this.getActionMap().put("aA", aAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "dA");
        this.getActionMap().put("dA", dAction);

        t.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("Drawing Rectanlge");
        g.setColor(Color.RED);
        g.fillRect(player1_x, player1_y, 10, 50);
        g.setColor(Color.YELLOW);
        g.fillRect(player2_x, player2_y, 10, 50);

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

    public class wAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going up");
            wPressed = true;
        }
    }
    public class sAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going down");
            sPressed = true;
        }
    }
    public class aAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going left");
            aPressed = true;
        }
    }
    public class dAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            System.out.println("Bitch we going right");
            dPressed = true;
        }
    }


    public void actionPerformed(ActionEvent e) {

        Update();

    }

    public void Update() {

        if (upPressed) {
            player1_y -= player_speed;
        }
        if (downPressed) {
            player1_y += player_speed;
        }
        if (rightPressed) {
            player1_x += player_speed;
        }
        if (leftPressed) {
            player1_x -= player_speed;
        }

        if (wPressed) {
            player2_y -= player_speed;
        }
        if (sPressed) {
            player2_y += player_speed;
        }
        if (aPressed) {
            player2_x -= player_speed;
        }
        if (dPressed) {
            player2_x += player_speed;
        }

        this.repaint();
        ResetKeys();

    }

    public void ResetKeys() {

        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;

        wPressed = false;
        sPressed = false;
        aPressed = false;
        dPressed = false;

    }
}