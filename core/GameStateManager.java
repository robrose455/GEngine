package ge.core;

import ge.doublenote.Song;
import ge.doublenote.SongManager;
import ge.doublenote.state.*;
import ge.doublenote.state.Menu;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameStateManager {

    boolean winner;

    State curState;

    State menu;
    State track;
    State gameOver;
    State win;

    ArrayList<State> states = new ArrayList<>();
    SpriteManager sprM;
    SongManager songM;

    public GameStateManager(SpriteManager sprM, SongManager songM) {

        System.out.println("--Creating Game State Manager--");

        winner = false;
        this.songM = songM;
        this.sprM = sprM;

    }

    public boolean isWinner() {
        return winner;
    }

    public void Win() {
        winner = true;
    }

    public void LoadStates() throws FileNotFoundException, InterruptedException {


        menu = new Menu(sprM);
        states.add(menu);

        gameOver = new GameOver(sprM);
        states.add(gameOver);

        win = new Win(sprM);
        states.add(win);

        //Test before interface works
        Song s = songM.getSongList().get(0);
        track = new Track(sprM, s);
        states.add(track);

        curState = states.get(0);
        curState.Init();

    }

    public void setTrack(String name) {

        //How Track Will be set in future
    }

    public void drawState(Graphics g) {
        curState.DrawSprites(g);
    }

    public State getCurState() {
        return curState;
    }

    public void setCurState(String n) throws FileNotFoundException, InterruptedException {

        //System.out.println("Cur State Index to be: " + index);
        for (int i = 0; i < states.size(); i++) {
            if (n.equals(states.get(i).getName())) {
                curState = states.get(i);
            }
        }
        curState.Init();
        //System.out.println(curState);

    }


}
