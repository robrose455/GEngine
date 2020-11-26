package ge.core;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.managers.PRSceneManager;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

public class Scene extends JFrame {

    //Initialize Height and Width along with the manager for the Scene
    SceneManager sm;
    int height;
    int width;

    public Scene() {

        System.out.println("--Creating Scene--");
        //Default Canvas Height and Width
        height = 1000;
        width = 1000;

    }

    public void Start() throws IOException, InterruptedException {

        //Called in the main function to start the game
        DrawScene();

    }

    public void DrawScene() throws IOException, InterruptedException {

        //Create Scene
        this.setLayout(new BorderLayout());

        sm = new PRSceneManager(this);
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

}