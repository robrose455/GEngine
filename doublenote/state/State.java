package ge.doublenote.state;

import ge.core.SpriteManager;
import ge.core.Game;

import java.awt.*;
import java.io.FileNotFoundException;

public abstract class State {

    SpriteManager sprM;
    Game g;
    String name;

    public State(SpriteManager sprM) {

        this.sprM = sprM;
        this.g = sprM.getGame();

    }

    public abstract void Init() throws FileNotFoundException;
    public abstract void Update() throws FileNotFoundException;
    public abstract void DrawSprites(Graphics g);
    public abstract void DrawText(Graphics g);

    public String getName() { return name; };

}
