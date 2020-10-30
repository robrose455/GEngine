package ge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SceneManager extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    int player_speed = 10;
    int player_x = 10;
    int player_y = 10;
    int player2_x = 500;
    int player2_y = 500;
    String controllerType;

    String cranImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\Cranberry.png";
    String appleImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\apple.png";

    boolean isPaused = false;

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
    Scene sc = new Scene();
    SpriteManager sprM = new SpriteManager(this);

    Timer t = new Timer(10, this);

    public SceneManager(Scene s) {

        this.setBackground(Color.BLACK);

        this.sc = s;
        player_x = 10;
        player_y = 10;

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

        InitSprites();
        t.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).paintComponent(g);
        }

    }

    public int getPlayer_x() {
        return player_x;
    }

    public int getPlayer_y() {
        return player_y;
    }

    public void setPlayer_x(int x) {
        player_x = x;
    }

    public void setPlayer_y(int y) {
        player_y = y;
    }

    public void mouseClicked(MouseEvent e) {


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

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
               controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "Arrows") {
                    sprM.getActiveSprites().get(i).playerControls.movingUp();
                }
            }
        }
    }

    public class DownAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
                controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "Arrows") {
                    sprM.getActiveSprites().get(i).playerControls.movingDown();
                }
            }
        }
    }

    public class LeftAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {

                controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "Arrows") {
                    sprM.getActiveSprites().get(i).playerControls.movingLeft();

                }
            }
        }
    }

    public class RightAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
                controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "Arrows") {
                    sprM.getActiveSprites().get(i).playerControls.movingRight();
                }
            }
        }
    }

    public class wAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
                controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "WASD") {
                    sprM.getActiveSprites().get(i).playerControls.movingUp();
                }
            }
        }
    }

    public class sAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
                controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "WASD") {
                    sprM.getActiveSprites().get(i).playerControls.movingDown();
                }
            }
        }
    }

    public class aAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
                controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "WASD") {
                    sprM.getActiveSprites().get(i).playerControls.movingLeft();
                }
            }
        }
    }

    public class dAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
                controllerType = sprM.getActiveSprites().get(i).playerControls.typeOfController();
                if (controllerType == "WASD") {
                    sprM.getActiveSprites().get(i).playerControls.movingRight();
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Update();
    }

    public void Update() {

        // Update each active sprite for movement commands and collisions
        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).Update();
        }

        sprM.getActiveSprites().get(0).collidesWith(sprM.getActiveSprites().get(1));

        // Repaint all sprites onto the frame with updated parameters
        this.repaint();

    }

    public void Pause() {

        //Pause Function to be added when user hits Space Bar

    }

    public void InitSprites() {

        Sprite cranberry = new Sprite(player_x, player_y, player_speed, w, sc, cranImagePath, "WRAP", "Cranberry");
        Sprite redberry = new Sprite(player2_x, player2_y, player_speed, s, sc, cranImagePath, "WRAP", "RedBerry");

        sprM.addSprite(cranberry);
        sprM.addSprite(redberry);

    }
}