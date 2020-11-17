package ge.game.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;

import java.awt.*;

public class LevelOne extends State {

    SpriteManager sprM;
    boolean redWin = false;
    boolean blueWin = false;
    Sprite red;
    Sprite blue;

    public LevelOne(SpriteManager sprM) {
        super(sprM);

        this.sprM = sprM;
        this.name = "levelOne";
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

        red = sprM.getSprites().get(0);
        red.setSpeed(3);

        blue = sprM.getSprites().get(1);
        blue.setSpeed(3);

            for (int i = 0; i < sprM.getSprites().size(); i++) {
                sprM.getSprites().get(i).Show();
            }

            ResetState();


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
            g.setCurState("levelTwo");
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
        g.drawString("Level One", 450, 50);

    }

    public void ResetState() {

        red.ResetToPos(100,900);
        blue.ResetToPos(900,900);
        sprM.getSprites().get(2).ResetToPos(425,400);
        sprM.getSprites().get(3).ResetToPos(550,400);


        redWin = false;
        blueWin = false;

    }
}
