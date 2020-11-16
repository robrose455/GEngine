package ge.core;

import ge.game.Game;

import java.awt.*;
import javax.swing.*;

public class Scene extends JFrame {

    //Initialize Height and Width along with the manager for the Scene
    SceneManager sm;
    Game game;
    int height;
    int width;

    public Scene() {

        //Default Canvas Height and Width
        height = 1000;
        width = 1000;

    }

    public void Start(Game game) {

        //Called in the main function to start the game
        this.game = game;
        DrawScene();

    }

    public void DrawScene() {

        //Create Scene
        sm = new SceneManager(this);
        this.add(sm, BorderLayout.CENTER);
        this.setSize(width,height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Get Canvas Height and Canvas Width

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public Game getGame() { return game; }
    public void setGame(Game g) { this.game = g; }

}