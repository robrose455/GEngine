package ge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class SceneManager extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    int player_speed;
    int player_x;
    int player_y;

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    Action wAction;
    Action sAction;
    Action aAction;
    Action dAction;

    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();
    Sprite cranberry = new Sprite(player_x, player_y,100, 100, 1, player_speed,s);
    String controllerType;
    Timer t = new Timer(10, this);

    public SceneManager() {

        this.setBackground(Color.BLACK);

        player_x = 0;
        player_y = 0;

        player_speed = 100;

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

        cranberry.paintComponent(g);

    }

    public int getPlayer_x() {
        return player_x;
    }
    public int getPlayer_y() {
        return player_y;
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
    }

    public class UpAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            controllerType = cranberry.playerControls.typeOfController();
            if(controllerType == "Arrows") {
                cranberry.playerControls.movingUp();
            }
        }
    }
    public class DownAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            controllerType = cranberry.playerControls.typeOfController();
            if(controllerType == "Arrows") {
                cranberry.playerControls.movingDown();
            }
        }
    }
    public class LeftAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            controllerType = cranberry.playerControls.typeOfController();
            if(controllerType == "Arrows") {
                cranberry.playerControls.movingLeft();
            }
        }
    }
    public class RightAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            controllerType = cranberry.playerControls.typeOfController();

            if(controllerType == "Arrows") {
                cranberry.playerControls.movingRight();
            }
        }
    }

    public class wAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            controllerType = cranberry.playerControls.typeOfController();
            if(controllerType == "WASD") {
                cranberry.playerControls.movingUp();
            }
        }
    }
    public class sAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){

            controllerType = cranberry.playerControls.typeOfController();
            if(controllerType == "WASD") {
                cranberry.playerControls.movingDown();
            }
        }
    }
    public class aAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){

            controllerType = cranberry.playerControls.typeOfController();
            if(controllerType == "WASD") {
                cranberry.playerControls.movingLeft();
            }
        }
    }
    public class dAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){

            controllerType = cranberry.playerControls.typeOfController();
            System.out.println(controllerType);
            if(controllerType == "WASD") {
                cranberry.playerControls.movingRight();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Update();
    }

    public void Update() {

        if (cranberry.playerControls.isMovingUp()) {
            player_y -= player_speed;
            cranberry.setPlayer_y(player_y);
        }
        if (cranberry.playerControls.isMovingDown()) {
            player_y += player_speed;
            cranberry.setPlayer_y(player_y);
        }
        if (cranberry.playerControls.isMovingLeft()) {
            player_x -= player_speed;
            cranberry.setPlayer_x(player_x);
        }
        if (cranberry.playerControls.isMovingRight()) {
            player_x += player_speed;
            cranberry.setPlayer_x(player_x);
        }

        this.repaint();
        cranberry.playerControls.ResetKeys();


    }
}