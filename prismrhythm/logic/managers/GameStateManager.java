package ge.prismrhythm.logic.managers;
import ge.core.State;
import ge.core.managers.SceneManager;
import ge.prismrhythm.songs.LoadedClip;
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

    SongFactory sf;
    Song s;

    LoadedClip feClip;
    LoadedClip tuClip;

    public GameStateManager(SceneManager sm) {

        System.out.println("--Creating Game State Manager--");

        this.sm = sm;
        this.sf = new SongFactory(sm);
        this.songM = new SongManager();

        songM.AddTitle("Tutorial");
        songM.AddTitle("Fur Elise");

        LoadClips();

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
                    s = sf.FurEliseNightmare(feClip);
                } else if (songTitle.equals("Tutorial")) {
                    s = sf.Tutorial(tuClip);
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

    public void setCurState(String n) throws FileNotFoundException, InterruptedException {

        for (State state : states) {
            if (n.equals(state.getName())) {
                curState = state;
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

    public void LoadClips() {
        feClip = new LoadedClip(sm.getAudioManager().LoadSong("/resources/songs/furelise.wav"));
        tuClip = new LoadedClip(sm.getAudioManager().LoadSong("/resources/songs/tutorial.wav"));
    }


}
