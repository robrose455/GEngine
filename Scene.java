package ge;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Scene extends JFrame {

    //Initialize Height and Width along with the manager for the Scene
    SceneManager sm;
    int height;
    int width;

    public Scene() {

        //Default Canvas Height and Width
        height = 1000;
        width = 1000;

    }

    public void Start() {

        //Called in the main function to start the game
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

}