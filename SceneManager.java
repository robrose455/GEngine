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
    String cranImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\cranberry.png";

    //Create both options for sprite controllers to be used as parameters
    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

    //Scene Canvas Reference
    Scene sc;

    //Reference to the current loaded game
    Game game;

    //Handles Sprite Drawing, Adding, and Removal
    SpriteManager sprM;

    //Handles Key Inputs
    KeyManager km;

    //Handles Mouse Inputs
    MouseManager mm;

    //Handles all text on Scene
    TextManager tm;

    //Handles current state of game (win or loss)
    GameStateManager gsm;

    //Create Timer
    Timer t = new Timer(10, this);

    public SceneManager(Scene s) {

        //Set Initial Background
        this.setBackground(Color.BLACK);

        //Initialize all Listeners and Sprites
        this.sc = s;
        game = sc.getGame();
        game.Init(this);

        this.sprM = new SpriteManager(this,game);
        this.km = new KeyManager(this);
        this.mm = new MouseManager(this);
        this.tm = new TextManager(this);
        this.gsm = new GameStateManager(this);


        //Initialize All Designated Sprites to be Active Sprites
        //TestGame();
        //Start Timer
        t.start();

    }

    @Override

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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

        //Update Each Frame According to Game Logic
        game.Update();
        //Repaint All Changes Made
        this.repaint();

        // Every frame the game is not completed, subtract points from score
        if(!gsm.isWinner()) {

            points--;

        }

    }

    public void TestGame() {

        Sprite cranberry = new Sprite(player_x, player_y, player_speed, w, cranImagePath, "WRAP", "Cranberry",sc);
        Sprite redberry = new Sprite(player2_x, player2_y, player_speed, s, cranImagePath, "WRAP", "RedBerry",sc);

        sprM.addSprite(cranberry);
        sprM.addSprite(redberry);

    }

    public Scene getScene() {
        return sc;
    }
}