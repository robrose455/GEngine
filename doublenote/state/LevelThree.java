package ge.doublenote.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;

import java.awt.*;

public class LevelThree extends Level {

    SpriteManager sprM;
    boolean redWin = false;
    boolean blueWin = false;

    Sprite red;
    Sprite blue;

    public LevelThree(SpriteManager sprM) {
        super(sprM);

        this.sprM = sprM;
        this.name = "levelThree";
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

        red = sprM.getSprites().get(0);
        red.setSpeed(2);

        blue = sprM.getSprites().get(1);
        blue.setSpeed(2);

        ResetSprites();


    }

    @Override
    public void Update() {

        if (blue.collidesWith(sprM.getSprites().get(3))){
            System.out.println("Red Target Achieved");
            //Go To Level 2
            HasWon();
        }

        if (red.collidesWith(sprM.getSprites().get(2))) {
            System.out.println("Blue Target Achieved");
            //Go To Level 2
            HasWon();
        }

        if (red.Death() || blue.Death()) {
            g.setCurState("gameOver");
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
        g.drawString("Level Three", 450, 50);

    }

    public void ResetSprites() {

        red.ResetToPos(100,900);
        blue.ResetToPos(900,900);
        sprM.getSprites().get(2).ResetToPos(10,10);
        sprM.getSprites().get(3).ResetToPos(900,10);

        blueWin = false;
        redWin = false;

    }
}