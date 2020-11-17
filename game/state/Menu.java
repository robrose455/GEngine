package ge.game.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;

import java.awt.*;
import java.util.ArrayList;

public class Menu extends State {


    public Menu(SpriteManager sprM, ArrayList<Sprite> spriteList) {
        super(sprM, spriteList);

        System.out.println("--Creating State: Menu--");


    }

    @Override
    public void Init() {

        System.out.println("Making Sprites");

    }

    @Override
    public void Update() {

        if(g.GetSceneManager().getMouseManager().WasMouseClicked()) {
            g.setCurState(1);
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
        g.drawString("DOUBLE NOTE", 315, 100);

        g.setFont(medFont);
        g.drawString("MATCH RED WITH BLUE AND BLUE WITH RED", 150, 200);
        g.drawString("CLICK ANYWHERE TO START", 270, 300);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

        g.setFont(medFont);
        g.drawString("Controls: WASD or Arrow Keys", 50, 900);

    }

}
