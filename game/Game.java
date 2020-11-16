package ge.game;

import ge.core.sprite.Sprite;
import ge.core.Scene;
import ge.core.SceneManager;

import java.util.ArrayList;

public abstract class Game {

    public Game(Scene s) {}

    public abstract void Init(SceneManager sm);
    public abstract ArrayList<Sprite> GetSprites();
    public abstract ArrayList<Sprite> GetPlayerSprites();
    public abstract void CreateSprite(String name);
    public abstract void CreatePlayerSprite(String name);
    public abstract void DefineSprites();
    public abstract void Update();
    public abstract void setCurState(int index);
    public abstract SceneManager GetSceneManager();
    public abstract void DeleteSprite(String n);

}
