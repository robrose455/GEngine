package ge.core;

import ge.game.state.*;
import ge.game.state.Menu;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    boolean winner;

    State curState;

    State menu;
    State levelOne;
    State gameOver;
    State win;

    ArrayList<State> states = new ArrayList<>();
    SpriteManager sprM;

    public GameStateManager(SpriteManager sprM) {

        System.out.println("--Creating Game State Manager--");

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


        menu = new Menu(sprM);
        states.add(menu);

        levelOne = new LevelOne(sprM);
        states.add(levelOne);

        gameOver = new GameOver(sprM);
        states.add(gameOver);

        win = new Win(sprM);
        states.add(win);

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

        System.out.println("Cur State Index to be: " + index);
        curState = states.get(index);
        curState.Init();
        System.out.println(curState);

    }


}
