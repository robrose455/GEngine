package ge.prismrhythm.songs;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.NoteFactory;

import javax.sound.sampled.Clip;
import java.io.IOException;

public class SongFactory {

    SceneManager sm;
    NoteFactory nf;

    public SongFactory(SceneManager sm) {

        this.sm = sm;
        this.nf = new NoteFactory(sm);

    }

    public Song FurEliseNightmare() throws IOException {
        Clip c = sm.getAudioManager().LoadSong("/resources/songs/furelise.wav");
        Song furelisenightmare = new FurEliseNightmare(sm, c, "Fur Elise",nf);
        return furelisenightmare;
    }

    public Song Tutorial() throws IOException {
        Clip c = sm.getAudioManager().LoadSong("/resources/songs/furelise.wav");
        Song tutorial = new Tutorial(sm, c, "Tutorial",nf);
        return tutorial;
    }
}
