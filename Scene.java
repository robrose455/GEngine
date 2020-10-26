package ge;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Scene extends JFrame {

    SceneManager sm;
    int height;
    int width;

    public Scene() {

        height = 1000;
        width = 1000;

    }

    public void Start() {

        System.out.println("Drawing Scene");
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

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

}