package ge.game.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;

import java.awt.*;
import java.util.ArrayList;

public class LevelOne extends State {

    public LevelOne(SpriteManager sprM, ArrayList<Sprite> spriteList) {
        super(sprM, spriteList);

        System.out.println("--Creating Level One--");

    }

    @Override
    public void Init() {

        spriteList = sprM.getActiveSprites();
        System.out.println("Size of SpriteList in Level One beg: " + spriteList.size());
        g.CreatePlayerSprite("RedPlayer");
        g.CreatePlayerSprite("BluePlayer");

        g.CreateSprite("RedTarget");
        g.CreateSprite("BlueTarget");
        System.out.println("Size of SpriteList in Level One: " + spriteList.size());

    }

    @Override
    public void Update() {

        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).Update();
        }

        if (spriteList.get(0).collidesWith(spriteList.get(3))){
            System.out.println("Red Target Achieved");
            spriteList.get(3).Hide();
        }

        if (spriteList.get(1).collidesWith(spriteList.get(2))) {
            System.out.println("Blue Target Achieved");
            spriteList.get(2).Hide();
        }

        if (spriteList.get(0).Death() || spriteList.get(1).Death()) {
            g.setCurState(2);
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
        Font medFont = new Font("Verdana", Font.PLAIN, 20);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(medFont);
        g.setColor(Color.WHITE);
        g.drawString("Level One", 450, 50);

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
