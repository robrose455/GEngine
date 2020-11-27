package ge.prismrhythm.logic.managers;

import ge.core.State;
import ge.core.managers.SceneManager;
import ge.prismrhythm.songs.Song;
import ge.prismrhythm.songs.SongFactory;
import ge.prismrhythm.states.*;
import ge.prismrhythm.states.Menu;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameStateManager {

    State curState;
    State menu;
    State track;
    State end;

    ArrayList<State> states = new ArrayList<>();
    SongManager songM;
    SceneManager sm;
    Song s;
    SongFactory sf;


    public GameStateManager(SceneManager sm) {

        System.out.println("--Creating Game State Manager--");

        this.sm = sm;
        this.sf = new SongFactory(sm);
        this.songM = new SongManager();

        songM.AddTitle("Tutorial");
        songM.AddTitle("Fur Elise");

        try {
            LoadStates();
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }

    public void SetTrack(String songTitle) {

        for(int i = 0; i < songM.getSongTitles().size(); i++) {

            try {

                if (songTitle.equals("Fur Elise")) {
                    s = sf.FurEliseNightmare();
                } else if (songTitle.equals("Tutorial")) {
                    s = sf.Tutorial();
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

        end = new End(sm);
        states.add(end);

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

        for (int i = 0; i < states.size(); i++) {
            if (n.equals(states.get(i).getName())) {
                curState = states.get(i);
            }
        }
        curState.Init();
    }

    public void Update() {

        try {
            curState.Update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SongManager getSongManager() {
        return songM;
    }

    public void isA() {
        System.out.println("I am a Game State Manager");
    }


}
