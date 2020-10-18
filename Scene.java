package ge;

import java.awt.*;
import javax.swing.*;

public class Scene extends JFrame {

    SceneManager sm;

    int mouseX;
    int mouseY;

    public Scene() {


    }

    public void Start() {

        System.out.println("Drawing Scene");
        DrawScene();

    }

    public void DrawScene() {

        //Create Scene
        sm = new SceneManager();
        this.add(sm, BorderLayout.CENTER);
        this.setSize(1000,1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void getMousePos() {

        mouseX = sm.getNewX();
        mouseY = sm.getNewY();


    }

}