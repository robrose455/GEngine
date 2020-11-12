package ge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneManager extends JPanel implements  ActionListener {

    //Determines if game condition is completed.
    int points = 1000;

    //Basic hardcoded parameters for sprites to be used in the game.
    //In actual game engine I would assume this could be done in a gui.
    int player_speed = 10;
    int player_x = 10;
    int player_y = 10;
    int player2_x = 500;
    int player2_y = 500;
    String controllerType;
    String cranImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\cranberry.png";
    String appleImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\apple.png";

    //Create both options for sprite controllers to be used as parameters
    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

    //Scene Canvas Reference
    Scene sc;

    //Handles Sprite Drawing, Adding, and Removal
    SpriteManager sprM = new SpriteManager(this);

    //Handles Key Inputs
    KeyManager km = new KeyManager(this);

    //Handles Mouse Inputs
    MouseManager mm = new MouseManager(this);

    //Handles all text on Scene
    TextManager tm = new TextManager(this);

    //Handles current state of game (win or loss)
    GameStateManager gsm = new GameStateManager(this);

    //Create Timer
    Timer t = new Timer(10, this);

    public SceneManager(Scene s) {

        //Set Initial Background
        this.setBackground(Color.BLACK);

        //Initialize all Listeners and Sprites
        this.sc = s;

        player_x = 10;
        player_y = 10;
        player_speed = 10;

        //Initialize All Designated Sprites to be Active Sprites
        InitSprites();
        //Start Timer
        t.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //For each Active Sprite -> Paint onto Scene
        sprM.drawSprites(g);
        tm.drawText(g);


        Font smallFont = new Font("Verdana",Font.PLAIN, 12);
        if (gsm.isWinner()) {
            g.setFont(smallFont);
            g.drawString("You did it!", 350, 130);
            g.setFont(smallFont);
            g.drawString("Score: " + points, 350, 160);
        }


    }

    public void actionPerformed(ActionEvent e) {
        Update();
    }

    public void Update() {

        // Update each active sprite for movement commands and collisions
        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).Update();
        }

        if(sprM.getActiveSprites().get(0).collidesWith(sprM.getActiveSprites().get(1))) {
             gsm.Win();
        }
        // Repaint all sprites onto the frame with updated parameters
        this.repaint();

        // Every frame the game is not completed, subtract points from score
        if(!gsm.isWinner()) {

            points--;

        }

    }

    public void InitSprites() {

        Sprite cranberry = new Sprite(player_x, player_y, player_speed, w, sc, cranImagePath, "WRAP", "Cranberry");
        Sprite redberry = new Sprite(player2_x, player2_y, player_speed, s, sc, cranImagePath, "WRAP", "RedBerry");

        sprM.addSprite(cranberry);
        sprM.addSprite(redberry);

    }
}