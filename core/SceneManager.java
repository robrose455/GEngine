package ge.core;

import ge.core.sprite.controller.SpriteArrowController;
import ge.core.sprite.controller.SpriteWASDController;
import ge.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneManager extends JPanel implements  ActionListener {

    //Scene Canvas Reference
    Scene s;

    //Reference to the current loaded game
    Game game;

    //Handles Sprite Drawing, Adding, and Removal
    SpriteManager sprM;

    //Handles Key Inputs
    KeyManager km;

    //Handles Mouse Inputs
    MouseManager mm;

    //Handles current state of game (win or loss)
    GameStateManager gsm;

    //Create Timer
    Timer t = new Timer(10, this);

    public SceneManager(Scene s) {

        System.out.println("--Creating Scene Manager--");

        this.setBackground(Color.BLACK);

        this.s = s;
        this.mm = new MouseManager(this);

        //Load Game Code
        game = s.getGame();

        //Sprite Manager takes Game Code and Contains SpriteList
        this.sprM = new SpriteManager(game);

        //Key Manager pulls SpriteList and Listens for Key Presses
        this.km = new KeyManager(this, sprM);

        //Game State Manager Contains all game states for game
        this.gsm = new GameStateManager(sprM);

        game.Init(this);

        t.start();

    }

    public void actionPerformed(ActionEvent e) {
        Update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gsm.drawState(g);
    }

    public void Update() {
        game.Update();
        this.repaint();
    }

    public Scene getScene() {
        return s;
    }

    public Game getGame() { return game; }

    public SpriteManager getSpriteManager() {
        return sprM;
    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public KeyManager getKeyManager() { return km; }

    public MouseManager getMouseManager() {
        return mm;
    }


}