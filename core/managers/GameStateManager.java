package ge.core.managers;

import ge.core.State;
import ge.doublenote.songs.Song;
import ge.doublenote.managers.SongManager;
import ge.doublenote.songs.SongFactory;
import ge.doublenote.states.*;
import ge.doublenote.states.Menu;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameStateManager {

    boolean winner;

    int test;

    State curState;
    State menu;
    State track;
    State gameOver;

    ArrayList<State> states = new ArrayList<>();
    SongManager songM;
    SceneManager sm;
    Song s;
    SongFactory sf;


    public GameStateManager(SceneManager sm, SongManager songM) {

        System.out.println("--Creating Game State Manager--");

        winner = false;

        this.songM = songM;
        this.sm = sm;
        this.sf = new SongFactory(sm);

    }

    public boolean isWinner() {
        return winner;
    }

    public void Win() {
        winner = true;
    }

    public void SetTrack(String songName) {

        for(int i = 0; i < songM.getSongList().size(); i++) {

            try {
                if (songM.getSongList().get(i).getName().equals(songName)) {
                    s = sf.FurElise();
                }
            } catch (IOException e) {
                System.out.println("IO Exception");
            }

        }

        System.out.println("Song being loaded: " + s.getName());
        track = new Track(sm,s);
        states.add(track);
    }

    public void RemoveTrack() {

        states.remove(track);

    }

    public void LoadStates() throws FileNotFoundException, InterruptedException {


        menu = new Menu(sm);
        states.add(menu);

        gameOver = new GameOver(sm);
        states.add(gameOver);

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

        test++;
        System.out.println("Times this has been called: " + test);

        for (int i = 0; i < states.size(); i++) {
            if (n.equals(states.get(i).getName())) {
                curState = states.get(i);
            }
        }
        curState.Init();
        //System.out.println(curState);

    }

    public SongManager getSongManager() {
        return songM;
    }


}
