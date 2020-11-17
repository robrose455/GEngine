package ge.game.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;
import ge.game.Game;

import java.awt.*;
import java.util.ArrayList;

public abstract class State {

    SpriteManager sprM;
    Game g;
    String name;

    public State(SpriteManager sprM) {

        this.sprM = sprM;
        this.g = sprM.getGame();

    }

    public abstract void Init();
    public abstract void Update();

    public abstract void DrawSprites(Graphics g);
    public abstract void DrawText(Graphics g);
    public void HasWon() {
        g.getGameStateManager().Win();
    }
    public String getName() { return name; };

}
