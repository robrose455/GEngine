package ge.doublenote.state;

import ge.core.SpriteManager;

import java.awt.*;
import java.io.FileNotFoundException;

public class Menu extends State {


    public Menu(SpriteManager sprM) {
        super(sprM);

        this.name = "menu";

        System.out.println("--Creating State: Menu--");


    }

    @Override
    public void Init() { }

    @Override
    public void Update() throws FileNotFoundException {

        if(g.GetSceneManager().getMouseManager().WasMouseClicked()) {
            g.setCurState("Track");
            g.GetSceneManager().getMouseManager().Reset();
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

}
