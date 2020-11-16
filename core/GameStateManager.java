package ge.core;

import ge.game.state.LevelOne;
import ge.game.state.Menu;
import ge.game.state.State;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    boolean winner;

    State curState;

    State menu;
    State levelOne;

    ArrayList<State> states = new ArrayList<>();
    SpriteManager sprM;

    public GameStateManager(SpriteManager sprM) {

        winner = false;
        this.sprM = sprM;

    }

    public boolean isWinner() {
        return winner;
    }

    public void Win() {
        winner = true;
    }

    public void LoadStates() {


        menu = new Menu(sprM, sprM.getActiveSprites());
        states.add(menu);

        levelOne = new LevelOne(sprM, sprM.getActiveSprites());
        states.add(levelOne);


        curState = states.get(0);
        curState.Init();

    }

    public void drawState(Graphics g) {
        curState.DrawSprites(g);
    }

    public State getCurState() {
        return curState;
    }

    public void setCurState(int index) {

        curState = states.get(index);
        curState.Init();

    }


}
