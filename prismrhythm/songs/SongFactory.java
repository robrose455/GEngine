package ge.prismrhythm.songs;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.NoteFactory;

import java.io.IOException;

public class SongFactory {

    SceneManager sm;

    NoteFactory nf;

    public SongFactory(SceneManager sm) {

        this.sm = sm;
        this.nf = new NoteFactory(sm);

    }

    public Song FurEliseNightmare() throws IOException {
        Song furelisenightmare = new FurEliseNightmare(sm, "/resources/songs/fen.wav", "Fur Elise",nf);
        return furelisenightmare;
    }

    public Song Tutorial() throws IOException {
        Song tutorial = new Tutorial(sm, "/resources/songs/tutorial.wav", "Tutorial",nf);
        return tutorial;
    }
}
