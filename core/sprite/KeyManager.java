package ge.core.sprite;


import ge.core.SceneManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyManager implements ActionListener {

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    Action wAction;
    Action sAction;
    Action aAction;
    Action dAction;

    SceneManager sm;
    String controllerType;
    
    public KeyManager(SceneManager sm) {

        this.sm = sm;

        upAction = new KeyManager.UpAction();
        downAction = new KeyManager.DownAction();
        leftAction = new KeyManager.LeftAction();
        rightAction = new KeyManager.RightAction();

        wAction = new KeyManager.wAction();
        sAction = new KeyManager.sAction();
        aAction = new KeyManager.aAction();
        dAction = new KeyManager.dAction();
        
        sm.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upA");
        sm.getActionMap().put("upA", upAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downA");
        sm.getActionMap().put("downA", downAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftA");
        sm.getActionMap().put("leftA", leftAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightA");
        sm.getActionMap().put("rightA", rightAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("W"), "wA");
        sm.getActionMap().put("wA", wAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("S"), "sA");
        sm.getActionMap().put("sA", sAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("A"), "aA");
        sm.getActionMap().put("aA", aAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("D"), "dA");
        sm.getActionMap().put("dA", dAction);
        
        
    }

    //Implementation for "Up Arrow"
    public class UpAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                    controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("Arrows")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingUp();
                }
            }
        }
    }
    //Implementation for "Down Arrow"
    public class DownAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("Arrows")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingDown();
                }
            }
        }
    }
    //Implementation for "Left Arrow"
    public class LeftAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("Arrows")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingLeft();

                }
            }
        }
    }
    //Implementation for "Right Arrow"
    public class RightAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("Arrows")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingRight();
                }
            }
        }
    }
    //Implementation for "W Key"
    public class wAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("WASD")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingUp();
                }
            }
        }
    }
    //Implementation for "S Key"
    public class sAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("WASD")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingDown();
                }
            }
        }
    }
    //Implementation for "A Key"
    public class aAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("WASD")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingLeft();
                }
            }
        }
    }
    //Implementation for "D Key"
    public class dAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < sm.getSpriteManager().getActivePlayerSprites().size(); i++) {
                controllerType = ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().typeOfController();
                if (controllerType.equals("WASD")) {
                    ((PlayerSprite) sm.getSpriteManager().getActivePlayerSprites().get(i)).getPlayerControls().movingRight();
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        sm.actionPerformed(e);
    }
    
}
