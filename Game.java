package ge;

import java.util.ArrayList;

abstract class Game {

    public Game(Scene s) {}

    public abstract void Init(SceneManager sm);
    public abstract ArrayList<Sprite> GetSprites();
    public abstract void CreateSprite(String name);
    public abstract void DefineSprites();
    public abstract void Update();

}
