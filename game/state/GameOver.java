package ge.game.state;

import ge.core.SpriteManager;
import ge.core.sprite.Sprite;

import java.awt.*;
import java.util.ArrayList;

public class GameOver extends State {

    public GameOver(SpriteManager sprM) {
        super(sprM);

        this.name = "gameOver";

    }
    @Override
    public void Init() {

        for (int i = 0; i < sprM.getSprites().size(); i++) {
            sprM.getSprites().get(i).Hide();
        }

    }

    @Override
    public void Update() {

        if(g.GetSceneManager().getMouseManager().WasMouseClicked()) {
            g.setCurState("levelOne");
            g.GetSceneManager().getMouseManager().Reset();
        }

    }

    @Override
    public void DrawSprites(Graphics g) {

        DrawText(g);

    }

    @Override
    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 45);
        Font medFont = new Font("Verdana", Font.PLAIN, 30);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(bigFont);
        g.setColor(Color.WHITE);
        g.drawString("ERIC SPEED RUN", 315, 100);

        g.setFont(medFont);
        g.drawString("GAME OVER", 400, 200);
        g.drawString("CLICK ANYWHERE TO RETRY", 270, 300);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

        g.setFont(medFont);
        g.drawString("Controls: WASD or Arrow Keys", 50, 900);

    }
}
