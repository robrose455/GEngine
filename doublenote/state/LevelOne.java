package ge.doublenote.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;

import java.awt.*;

public class LevelOne extends Level {

    SpriteManager sprM;
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

            sprM.addPlayerSprite("RedHitter");
            sprM.addPlayerSprite("OrangeHitter");
            sprM.addPlayerSprite("YellowHitter");
            sprM.addPlayerSprite("WhiteHitter");

            sprM.addPlayerSprite("BlueHitter");
            sprM.addPlayerSprite("PurpleHitter");
            sprM.addPlayerSprite("GreenHitter");
            sprM.addPlayerSprite("LBlueHitter");

        }

    }

    @Override
    public void Update() {

        for (int i = 0; i < sprM.getSprites().size(); i++) {
            sprM.getSprites().get(i).Update();
        }

    }

    @Override
    public void DrawSprites(Graphics g) {

        DrawTrack(g);
        for (int i = 0; i < sprM.getSprites().size(); i++) {
            sprM.getSprites().get(i).DrawSprite(g);
        }
        DrawText(g);

    }

    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 25);
        Font medFont = new Font("Verdana", Font.PLAIN, 20);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(bigFont);
        g.setColor(Color.WHITE);
        g.drawString("Level One", 50, 100);

        g.setColor(Color.BLACK);
        g.drawString("A",290,935);
        g.drawString("S",340,935);
        g.drawString("D",390,935);
        g.drawString("F",440,935);

        g.drawString("J",590,935);
        g.drawString("K",640,935);
        g.drawString("L",690,935);
        g.drawString(";",740,935);

    }

    public void DrawTrack(Graphics g) {

        //Red Side Track
        g.setColor(Color.decode("#FA8282"));
        g.fillRect(575,0,50,1000);

        g.setColor(Color.decode("#f78c5e"));
        g.fillRect(625,0,50,1000);

        g.setColor(Color.decode("#f1f58e"));
        g.fillRect(675,0,50,1000);

        g.setColor(Color.decode("#f7f4f2"));
        g.fillRect(725,0,50,1000);


        //Blue Side Track
        g.setColor(Color.decode("#a668a2"));
        g.fillRect(425,0,50,1000);

        g.setColor(Color.decode("#818de3"));
        g.fillRect(375,0,50,1000);

        g.setColor(Color.decode("#77e6c8"));
        g.fillRect(325,0,50,1000);

        g.setColor(Color.decode("#6dd17a"));
        g.fillRect(275,0,50,1000);

    }
}
