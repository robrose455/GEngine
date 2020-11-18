package ge.doublenote.state;

import ge.core.SpriteManager;
import ge.core.Game;

import java.awt.*;

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
