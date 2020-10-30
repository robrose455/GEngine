package ge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SceneManager extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    //Determines if game condition is completed.
    boolean winner = false;
    int points = 1000;

    //Basic hardcoded parameters for sprites to be used in the game.
    //In actual game engine I would assume this could be done in a gui.
    int player_speed = 10;
    int player_x = 10;
    int player_y = 10;
    int player2_x = 500;
    int player2_y = 500;
    String controllerType;
    String cranImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\Cranberry.png";
    String appleImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\apple.png";

    //For Future Pause Function
    boolean isPaused = false;

    //Key Listeners
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    Action wAction;
    Action sAction;
    Action aAction;
    Action dAction;

    //Create both options for sprite controllers to be used as parameters
    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

    //Scene Reference
    Scene sc = new Scene();

    //Sprite Manager contains organized use of all the active sprites on the scene inside an ArrayList<Sprite>
    SpriteManager sprM = new SpriteManager(this);

    //Create Timer
    Timer t = new Timer(10, this);

    public SceneManager(Scene s) {

        //Initialize all Listeners and Sprites
        this.setBackground(Color.BLACK);
        this.sc = s;
        player_x = 10;
        player_y = 10;

        player_speed = 10;

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

        /*
        Code for key listeners. Refer to comment below for plans
        */
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

        //Initialize All Designated Sprites to be Active Sprites
        InitSprites();
        //Start Timer
        t.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //For each Active Sprite -> Paint onto Scene
        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).paintComponent(g);
        }

        g.setColor(Color.WHITE);

        Font bigFont = new Font("Verdana", Font.BOLD, 25);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);
        g.setFont(bigFont);

        g.drawString("Match the Sprites", 350, 100);

        g.setFont(bigFont);
        g.drawString("Controls: WASD or Arrow Keys", 50, 900);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

        if (winner) {
            g.setFont(smallFont);
            g.drawString("You did it!", 350, 130);
            g.setFont(smallFont);
            g.drawString("Score: " + points, 350, 160);
        }


    }

    //Mouse Listeners
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

    /*
           My implementation for key listeners in Java.
           Very rigid in the keys it can understand.
           Have to add new class for every key.
           Will want to either find new implementation or pull all key listeners out into seperate class
     */
    //Implementation for "Up Arrow"
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
    //Implementation for "Down Arrow"
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
    //Implementation for "Left Arrow"
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
    //Implementation for "Right Arrow"
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
    //Implementation for "W Key"
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
    //Implementation for "S Key"
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
    //Implementation for "A Key"
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
    //Implementation for "D Key"
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

        if(sprM.getActiveSprites().get(0).collidesWith(sprM.getActiveSprites().get(1))) {
            winner = true;
        }
        // Repaint all sprites onto the frame with updated parameters
        this.repaint();

        // Every frame the game is not completed, subtract points from score
        if(!winner) {

            points--;

        }

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