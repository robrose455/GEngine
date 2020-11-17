package ge.game.state;

import ge.core.SpriteManager;
import ge.core.sprite.Sprite;

import java.awt.*;
import java.util.ArrayList;

public class Win extends State {

    public Win(SpriteManager sprM) {
        super(sprM);

    }
    @Override
    public void Init() {

        for (int i = 0; i < sprM.getSprites().size(); i++) {
            sprM.getSprites().get(i).Hide();
        }

    }

    @Override
    public void Update() {

        System.out.println("You beat the game");

    }

    @Override
    public void DrawSprites(Graphics g) {

        DrawText(g);

    }

    @Override
    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 45);

        g.setFont(bigFont);
        g.setColor(Color.WHITE);
        g.drawString("YOU WIN", 375, 400);


    }
}
