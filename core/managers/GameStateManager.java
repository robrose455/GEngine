package ge.core.managers;

import ge.core.State;
import ge.doublenote.songs.Song;
import ge.doublenote.managers.SongManager;
import ge.doublenote.states.*;
import ge.doublenote.states.Menu;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameStateManager {

    boolean winner;

    State curState;
    State menu;
    State track;
    State gameOver;

    ArrayList<State> states = new ArrayList<>();
    SongManager songM;
    SceneManager sm;
    Song s;


    public GameStateManager(SceneManager sm, SongManager songM) {

        System.out.println("--Creating Game State Manager--");

        winner = false;
        this.songM = songM;
        this.sm = sm;

    }

    public boolean isWinner() {
        return winner;
    }

    public void Win() {
        winner = true;
    }

    public void SetTrack(String songName) {

        for(int i = 0; i < songM.getSongList().size(); i++) {

            if(songM.getSongList().get(i).getName().equals(songName)) {
                s = songM.getSongList().get(i);
            }

        }

        track = new Track(sm,s);
        states.add(track);
    }

    public void LoadStates() throws FileNotFoundException, InterruptedException {


        menu = new Menu(sm);
        states.add(menu);

        gameOver = new GameOver(sm);
        states.add(gameOver);

        s = songM.getSongList().get(3);
        track = new Track(sm, s);
        states.add(track);

        curState = states.get(0);
        curState.Init();

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
