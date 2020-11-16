package ge;

import java.awt.*;
import java.util.ArrayList;

public class Menu extends State {


    public Menu(SpriteManager sprM, ArrayList<Sprite> spriteList) {
        super(sprM, spriteList);


    }

    @Override
    public void Init() {

        System.out.println("Making Sprites");

        g.CreatePlayerSprite("RedPlayer");
        g.CreatePlayerSprite("BluePlayer");
        g.CreateSprite("BlueTarget");

    }

    @Override
    public void Update() {

        //System.out.println("Update in Menu");
        spriteList = sprM.getActiveSprites();
        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).Update();
        }

        //Checks for collision
        if(sprM.getActiveSprites().get(0).collidesWith(sprM.getActiveSprites().get(1))) {
            System.out.println("Change Scene");
            g.setCurState(1);
        }

    }

    @Override
    public void DrawSprites(Graphics g) {

        for (int i = 0; i < spriteList.size(); i++) {
            //System.out.println(spriteList.get(i).imagePath);
            spriteList.get(i).DrawSprite(g);
        }

        DrawText(g);

    }
    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 25);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(bigFont);
        g.setColor(Color.WHITE);
        g.drawString("Level One", 350, 100);

        g.setFont(bigFont);
        g.drawString("Controls: WASD or Arrow Keys", 50, 900);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

    }

}
