package ge.game.state;

import ge.core.sprite.Sprite;
import ge.core.SpriteManager;
import ge.game.Game;

import java.awt.*;
import java.util.ArrayList;

public abstract class State {

    SpriteManager sprM;
    ArrayList<Sprite> spriteList;
    ArrayList<Sprite> spritePlayerList;
    Game g;

    public State(SpriteManager sprM, ArrayList<Sprite> spriteList) {

        this.sprM = sprM;
        this.spriteList = spriteList;
        this.g = sprM.getGame();

    }

    public abstract void Init();
    public abstract void Update();

    public abstract void DrawSprites(Graphics g);
    public abstract void DrawText(Graphics g);


}
