package ge.core;
import ge.core.managers.SceneManager;

import java.awt.*;
import java.io.FileNotFoundException;

public abstract class State {

    public SceneManager sm;
    public String name;

    public State(SceneManager sm) {

        this.sm = sm;

    }

    public abstract void Init() throws FileNotFoundException, InterruptedException;
    public abstract void Update() throws FileNotFoundException, InterruptedException;
    public abstract void DrawSprites(Graphics g);
    public abstract void DrawText(Graphics g);
    public String getName() { return name; };

}
