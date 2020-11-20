package ge.core;

import ge.core.sprite.Sprite;
import ge.doublenote.songs.SongManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class Game {

    public Game() {}

    public abstract void Init(SceneManager sm) throws FileNotFoundException, InterruptedException;
    public abstract void DefineSprites();

    public abstract ArrayList<Sprite> getSpriteTemplates();

    public abstract void Update() throws FileNotFoundException, InterruptedException;

    public abstract void setCurState(String n) throws FileNotFoundException, InterruptedException;

    public abstract SceneManager GetSceneManager();
    public abstract GameStateManager getGameStateManager();
    public abstract SongManager getSongManager();

}
