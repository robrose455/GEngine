package ge.game.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;

import java.awt.*;
import java.util.ArrayList;

public class LevelTwo extends State {

    SpriteManager sprM;
    boolean redWin = false;
    boolean blueWin = false;

    public LevelTwo(SpriteManager sprM) {
        super(sprM);

        this.sprM = sprM;
        System.out.println("--Creating Level One--");

    }

    @Override
    public void Init() {

        if(sprM.getSprites().size() == 0) {

            sprM.addPlayerSprite("RedPlayer");
            sprM.addPlayerSprite("BluePlayer");
            sprM.addSprite("RedTarget");
            sprM.addSprite("BlueTarget");

        }

        for (int i = 0; i < sprM.getSprites().size(); i++) {
            sprM.getSprites().get(i).Show();
        }

        ResetSprites();


    }

    @Override
    public void Update() {

        if (sprM.getSprites().get(0).collidesWith(sprM.getSprites().get(3))){
            System.out.println("Red Target Achieved");
            //Go To Level 2
            redWin = true;
        }

        if (sprM.getSprites().get(1).collidesWith(sprM.getSprites().get(2))) {
            System.out.println("Blue Target Achieved");
            //Go To Level 2
            blueWin = true;
        }

        if (redWin && blueWin) {
            g.setCurState(5);
        }

        if (sprM.getSprites().get(0).Death() || sprM.getSprites().get(1).Death()) {
            g.setCurState(1);
        }

        for (int i = 0; i < sprM.getSprites().size(); i++) {
            sprM.getSprites().get(i).Update();
        }

    }

    @Override
    public void DrawSprites(Graphics g) {

        for (int i = 0; i < sprM.getSprites().size(); i++) {
            sprM.getSprites().get(i).DrawSprite(g);
        }

        DrawText(g);

    }

    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 25);
        Font medFont = new Font("Verdana", Font.PLAIN, 20);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(medFont);
        g.setColor(Color.WHITE);
        g.drawString("Level Two", 450, 50);

    }

    public void ResetSprites() {

        sprM.getSprites().get(0).ResetToPos(100,900);
        sprM.getSprites().get(1).ResetToPos(900,900);

    }
}