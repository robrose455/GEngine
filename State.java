package ge;

import java.awt.*;
import java.util.ArrayList;

abstract public class State {

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
