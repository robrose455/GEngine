package ge.core;

import ge.core.GameStateManager;
import ge.core.sprite.Sprite;
import ge.core.Scene;
import ge.core.SceneManager;
import ge.doublenote.SongManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class Game {

    public Game() {}

    public abstract void Init(SceneManager sm) throws FileNotFoundException;
    public abstract void DefineSprites();

    public abstract ArrayList<Sprite> getSpriteTemplates();

    public abstract void Update() throws FileNotFoundException;

    public abstract void setCurState(String n) throws FileNotFoundException;

    public abstract SceneManager GetSceneManager();
    public abstract GameStateManager getGameStateManager();
    public abstract SongManager getSongManager();

}
