package ge;

import ge.core.Scene;
import ge.core.SceneManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Game {

    public Game(Scene s) {}

    public abstract void Init(SceneManager sm);
    public abstract ArrayList<Sprite> GetSprites();
    public abstract ArrayList<Sprite> GetPlayerSprites();
    public abstract void CreateSprite(String name);
    public abstract void DefineSprites();
    public abstract void Update();

}
