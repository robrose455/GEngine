package ge.prismrhythm.logic.managers;

import ge.core.Scene;
import ge.core.managers.KeyManager;
import ge.core.managers.MouseManager;
import ge.core.managers.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PRSceneManager extends SceneManager {

    //Scene Canvas Reference
    Scene s;

    //Handles Key Inputs
    KeyManager km;

    //Handles Mouse Inputs
    MouseManager mm;

    //Handles current state of game (win or loss)
    GameStateManager gsm;

    //Create Timer
    Timer t = new Timer(10, this);

    public PRSceneManager(Scene s) {
        super();

        System.out.println("--Creating Prism Scene Manager--");

        //Default Background set for Scene
        this.setBackground(Color.BLACK);

        //Reference to current scene
        this.s = s;

        //Mouse Manager Handles all Mouse Inputs
        this.mm = new MouseManager(this);

        //Key Manager pulls SpriteList and Listens for Key Presses
        this.km = new KeyManager(this);

        //Game State Manager Contains all game states for game
        this.gsm = new GameStateManager(this);

        //Timer that will call action performed each frame (10ms)
        t.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Called every frame
        Update();

    }

    @Override
    public void Update() {

        //Update Logical Components of the Game
        gsm.Update();
        //Update Visual Components of the Game
        this.repaint();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw The Current State to the Screen
        gsm.drawState(g);

    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public KeyManager getKeyManager() {
        return km;
    }
}