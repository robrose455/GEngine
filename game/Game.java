package ge.game;

import ge.core.sprite.Sprite;
import ge.core.Scene;
import ge.core.SceneManager;

import java.util.ArrayList;

public abstract class Game {

    public Game() {}

    public abstract void Init(SceneManager sm);
    public abstract ArrayList<Sprite> getSpriteTemplates();
    public abstract void DefineSprites();
    public abstract void Update();
    public abstract void setCurState(int index);
    public abstract SceneManager GetSceneManager();

}
