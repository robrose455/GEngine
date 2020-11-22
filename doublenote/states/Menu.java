package ge.doublenote.states;

import ge.core.managers.SceneManager;
import ge.core.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Menu extends State implements ActionListener {

    JButton btn1;
    JButton btn2;
    JButton btn3;

    public Menu(SceneManager sm) {
        super(sm);

        this.name = "menu";

        btn1 = new JButton("Toads Factory");
        btn2 = new JButton("Coconut Mall");
        btn3 = new JButton("Hall of the Mountain King");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        sm.add(btn1,BorderLayout.WEST);
        sm.add(btn2,BorderLayout.WEST);
        sm.add(btn3,BorderLayout.WEST);

        System.out.println("--Creating State: Menu--");


    }

    @Override
    public void Init() {



    }

    @Override
    public void Update() throws FileNotFoundException, InterruptedException {

        if(sm.getMouseManager().WasMouseClicked()) {
            sm.getGameStateManager().setCurState("Track");
            sm.getMouseManager().Reset();
        }

    }

    @Override
    public void DrawSprites(Graphics g) {

        DrawText(g);

    }
    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 45);
        Font medFont = new Font("Verdana", Font.PLAIN, 30);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(bigFont);

        g.setColor(Color.WHITE);
        g.drawString("Double Note", 335, 100);

        g.setFont(medFont);
        g.drawString("Select a Song by Clicking", 305, 250);

        g.setFont(medFont);
        g.drawString("Merry Go Round of Life", 315, 300);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        try {

            /*if (e.getSource() == btn1){
                sm.getGameStateManager().SetTrack("Toads Factory");

            }

            if (e.getSource() == btn2){
                sm.getGameStateManager().SetTrack("Coconut Mall");
            }

            if (e.getSource() == btn3){
                sm.getGameStateManager().SetTrack("Hall of the Mountain King");
            }*/

            sm.getGameStateManager().setCurState("Track");
            sm.remove(btn1);
            sm.remove(btn2);
            sm.remove(btn3);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
