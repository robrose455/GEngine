package ge.core;

import ge.core.managers.SceneManager;
import ge.core.sprite.Sprite;
import ge.doublenote.managers.SongManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Game {

    public Game() {}

    public abstract void Init(SceneManager sm) throws IOException, InterruptedException;
    public abstract void DefineSprites();

    public abstract ArrayList<Sprite> getSpriteTemplates();

    public abstract SceneManager GetSceneManager();
    public abstract SongManager getSongManager();

}
