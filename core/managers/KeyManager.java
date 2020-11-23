package ge.core.managers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class KeyManager implements ActionListener {

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    Action fPressAction;
    Action fReleaseAction;

    Action dPressAction;
    Action dReleaseAction;

    Action sPressAction;
    Action sReleaseAction;

    Action aPressAction;
    Action aReleaseAction;

    Action jPressAction;
    Action jReleaseAction;

    Action kPressAction;
    Action kReleaseAction;

    Action lPressAction;
    Action lReleaseAction;

    Action scPressAction;
    Action scReleaseAction;

    Action tPressAction;
    Action tReleaseAction;

    Action enterPressAction;
    Action enterReleaseAction;

    Action spaceAction;

    boolean down = false;
    boolean up = false;
    boolean left = false;
    boolean right = false;

    boolean s = false;
    boolean f = false;
    boolean a = false;
    boolean d = false;

    boolean j = false;
    boolean k = false;
    boolean l = false;
    boolean sc = false;

    boolean t = false;

    boolean enter = false;

    SceneManager sm;
    
    public KeyManager(SceneManager sm) {

        System.out.println("--Creating Key Manager--");
        this.sm = sm;

        upAction = new KeyManager.UpAction();
        downAction = new KeyManager.DownAction();
        leftAction = new KeyManager.LeftAction();
        rightAction = new KeyManager.RightAction();

        fPressAction = new KeyManager.fPressAction();
        fReleaseAction = new KeyManager.fReleaseAction();

        dPressAction = new KeyManager.dPressAction();
        dReleaseAction = new KeyManager.dReleaseAction();

        sPressAction = new KeyManager.sPressAction();
        sReleaseAction = new KeyManager.sReleaseAction();

        aPressAction = new KeyManager.aPressAction();
        aReleaseAction = new KeyManager.aReleaseAction();

        jPressAction = new KeyManager.jPressAction();
        jReleaseAction = new KeyManager.jReleaseAction();

        kPressAction = new KeyManager.kPressAction();
        kReleaseAction = new KeyManager.kReleaseAction();

        lPressAction = new KeyManager.lPressAction();
        lReleaseAction = new KeyManager.lReleaseAction();

        scPressAction = new KeyManager.scPressAction();
        scReleaseAction = new KeyManager.scReleaseAction();

        tPressAction = new KeyManager.tPressAction();
        tReleaseAction = new KeyManager.tReleaseAction();

        enterPressAction = new KeyManager.enterPressAction();
        enterReleaseAction = new KeyManager.enterReleaseAction();

        spaceAction = new KeyManager.spaceAction();
        
        sm.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upA");
        sm.getActionMap().put("upA", upAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downA");
        sm.getActionMap().put("downA", downAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftA");
        sm.getActionMap().put("leftA", leftAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightA");
        sm.getActionMap().put("rightA", rightAction);

        KeyStroke F_KEY_PRESSED = KeyStroke.getKeyStroke('F', 0, false);
        KeyStroke F_KEY_RELEASED = KeyStroke.getKeyStroke('F', 0, true);

        sm.getInputMap().put(F_KEY_PRESSED, "fPA");
        sm.getActionMap().put("fPA", fPressAction);

        sm.getInputMap().put(F_KEY_RELEASED, "fRA");
        sm.getActionMap().put("fRA", fReleaseAction);

        KeyStroke D_KEY_PRESSED = KeyStroke.getKeyStroke('D', 0, false);
        KeyStroke D_KEY_RELEASED = KeyStroke.getKeyStroke('D', 0, true);

        sm.getInputMap().put(D_KEY_PRESSED, "dPA");
        sm.getActionMap().put("dPA", dPressAction);

        sm.getInputMap().put(D_KEY_RELEASED, "dRA");
        sm.getActionMap().put("dRA", dReleaseAction);

        KeyStroke S_KEY_PRESSED = KeyStroke.getKeyStroke('S', 0, false);
        KeyStroke S_KEY_RELEASED = KeyStroke.getKeyStroke('S', 0, true);

        sm.getInputMap().put(S_KEY_PRESSED, "sPA");
        sm.getActionMap().put("sPA", sPressAction);

        sm.getInputMap().put(S_KEY_RELEASED, "sRA");
        sm.getActionMap().put("sRA", sReleaseAction);

        KeyStroke A_KEY_PRESSED = KeyStroke.getKeyStroke('A', 0, false);
        KeyStroke A_KEY_RELEASED = KeyStroke.getKeyStroke('A', 0, true);

        sm.getInputMap().put(A_KEY_PRESSED, "aPA");
        sm.getActionMap().put("aPA", aPressAction);

        sm.getInputMap().put(A_KEY_RELEASED, "aRA");
        sm.getActionMap().put("aRA", aReleaseAction);

        KeyStroke J_KEY_PRESSED = KeyStroke.getKeyStroke('J', 0, false);
        KeyStroke J_KEY_RELEASED = KeyStroke.getKeyStroke('J', 0, true);

        sm.getInputMap().put(J_KEY_PRESSED, "jPA");
        sm.getActionMap().put("jPA", jPressAction);

        sm.getInputMap().put(J_KEY_RELEASED, "jRA");
        sm.getActionMap().put("jRA", jReleaseAction);

        KeyStroke K_KEY_PRESSED = KeyStroke.getKeyStroke('K', 0, false);
        KeyStroke K_KEY_RELEASED = KeyStroke.getKeyStroke('K', 0, true);

        sm.getInputMap().put(K_KEY_PRESSED, "kPA");
        sm.getActionMap().put("kPA", kPressAction);

        sm.getInputMap().put(K_KEY_RELEASED, "kRA");
        sm.getActionMap().put("kRA", kReleaseAction);

        KeyStroke L_KEY_PRESSED = KeyStroke.getKeyStroke('L', 0, false);
        KeyStroke L_KEY_RELEASED = KeyStroke.getKeyStroke('L', 0, true);

        sm.getInputMap().put(L_KEY_PRESSED, "lPA");
        sm.getActionMap().put("lPA", lPressAction);

        sm.getInputMap().put(L_KEY_RELEASED, "lRA");
        sm.getActionMap().put("lRA", lReleaseAction);

        KeyStroke SC_KEY_PRESSED = KeyStroke.getKeyStroke(';', 0, false);
        KeyStroke SC_KEY_RELEASED = KeyStroke.getKeyStroke(';', 0, true);

        sm.getInputMap().put(SC_KEY_PRESSED, "scPA");
        sm.getActionMap().put("scPA", scPressAction);

        sm.getInputMap().put(SC_KEY_RELEASED, "scRA");
        sm.getActionMap().put("scRA", scReleaseAction);

        KeyStroke T_KEY_PRESSED = KeyStroke.getKeyStroke('T', 0, false);
        KeyStroke T_KEY_RELEASED = KeyStroke.getKeyStroke('T', 0, true);

        sm.getInputMap().put(T_KEY_PRESSED, "tPA");
        sm.getActionMap().put("tPA", tPressAction);

        sm.getInputMap().put(T_KEY_RELEASED, "tRA");
        sm.getActionMap().put("tRA", tReleaseAction);

        KeyStroke ENTER_KEY_PRESSED = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        KeyStroke ENTER_KEY_RELEASED = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true);

        sm.getInputMap().put(ENTER_KEY_PRESSED, "enPA");
        sm.getActionMap().put("enPA", enterPressAction);

        sm.getInputMap().put(ENTER_KEY_RELEASED, "enRA");
        sm.getActionMap().put("enRA", enterReleaseAction);

        sm.getInputMap().put(KeyStroke.getKeyStroke(' '), "spaceA");
        sm.getActionMap().put("spaceA", spaceAction);

        
        
    }

    public class UpAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            up = true;
        }
    }

    public class DownAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
                down = true;
        }
    }

    public class LeftAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            left = true;
        }
    }

    public class RightAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            right = true;
        }
    }

    public class fPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            f = true;
        }
    }

    public class fReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Released");
            f = false;
        }
    }

    public class dPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            d = true;
        }
    }

    public class dReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Released");
            d = false;
        }
    }

    public class sPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            s = true;
        }
    }

    public class sReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Released");
            s = false;
        }
    }

    public class aPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            a = true;
        }
    }

    public class aReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Released");
            a = false;
        }
    }


    public class jPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            j = true;
        }
    }

    public class jReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Released");
            j = false;
        }
    }

    public class kPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            k = true;
        }
    }

    public class kReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            k = false;
        }
    }

    public class lPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            l = true;
        }
    }

    public class lReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            l = false;
        }
    }

    public class scPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            sc = true;
        }
    }

    public class scReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            sc = false;
        }
    }

    public class tPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            t = true;
        }
    }


    public class tReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            t = false;
        }
    }

    public class enterPressAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            enter = true;
        }
    }

    public class enterReleaseAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

            enter = false;
        }
    }


    public class spaceAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {

        }
    }

    public void actionPerformed(ActionEvent e) { }

    public boolean movingDown() {
        return down;
    }
    public boolean movingUp() {
        return up;
    }
    public boolean movingLeft() {
        return left;
    }
    public boolean movingRight() {
        return right;
    }

    public boolean s() {
        return s;
    }
    public boolean f() {
        return f;
    }
    public boolean a() {
        return a;
    }
    public boolean d() {
        return d;
    }

    public boolean j() { return j;}
    public boolean k() { return k;}
    public boolean l() {
        return l;
    }
    public boolean sc() { return sc;}

    public boolean t() { return t; }
    public boolean enter() { return enter;}

    public void ResetMovement() {
        down = false;
        up = false;
        left = false;
        right = false;
    }

    
}
