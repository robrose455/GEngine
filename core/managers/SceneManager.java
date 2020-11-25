package ge.core.managers;

import ge.core.Game;
import ge.core.Scene;
import ge.prismrhythm.managers.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SceneManager extends JPanel implements ActionListener {

    //Scene Canvas Reference
    Scene s;

    //Reference to the current loaded game
    Game game;

    //Handles Key Inputs
    KeyManager km;

    //Handles Mouse Inputs
    MouseManager mm;

    //Handles current state of game (win or loss)
    GameStateManager gsm;

    //Create Timer
    Timer t = new Timer(10, this);

    public SceneManager(Scene s) throws IOException, InterruptedException {

        System.out.println("--Creating Scene Manager--");

        this.setBackground(Color.BLACK);

        this.s = s;

        this.mm = new MouseManager(this);
        //Load Game Code
        game = s.getGame();

        //Key Manager pulls SpriteList and Listens for Key Presses
        this.km = new KeyManager(this);

        //Game State Manager Contains all game states for game
        this.gsm = new GameStateManager(this, game.getSongManager());

        game.Init(this);

        t.start();
    }

    public void actionPerformed(ActionEvent e) {

        //System.out.println("Using Scene");

        try {

            Update();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        gsm.drawState(g);

    }

    public void Update() throws FileNotFoundException, InterruptedException {

        gsm.getCurState().Update();
        this.repaint();

    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public KeyManager getKeyManager() { return km; }

    public MouseManager getMouseManager() {
        return mm;
    }


}