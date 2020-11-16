package ge.game.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;

import java.awt.*;
import java.util.ArrayList;

public class LevelOne extends State {

    public LevelOne(SpriteManager sprM, ArrayList<Sprite> spriteList) {
        super(sprM, spriteList);


    }

    @Override
    public void Init() {

        g.CreateSprite("RedTarget");
        System.out.println("Updating position..");
        UpdatePos("RedPlayer",0,0);

    }

    @Override
    public void Update() {

        spriteList = sprM.getActiveSprites();
        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).Update();
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
        g.drawString("Level Two", 350, 100);

        g.setFont(bigFont);
        g.drawString("Controls: WASD or Arrow Keys", 50, 900);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

    }

    public void UpdatePos(String name, int x, int y) {

        for (int i = 0; i < spriteList.size(); i++) {
            String n = (spriteList.get(i).getName());
            if (n.equals(name)) {
                spriteList.get(i).setPos(x,y);
            }
        }

    }

}
