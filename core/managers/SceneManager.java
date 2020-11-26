package ge.core.managers;

import ge.prismrhythm.logic.managers.GameStateManager;

import javax.swing.*;
import java.awt.event.*;

public abstract class SceneManager extends JPanel implements ActionListener {


    public SceneManager() { }

    public abstract void actionPerformed(ActionEvent e);
    public abstract void Update();
    public abstract GameStateManager getGameStateManager();
    public abstract KeyManager getKeyManager();

}