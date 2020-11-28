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

    public Song FurEliseNightmare(LoadedClip c) throws IOException {
        return new FurEliseNightmare(sm, c, "Fur Elise",nf);
    }

    public Song Tutorial(LoadedClip c) throws IOException {
        return new Tutorial(sm, c, "Tutorial",nf);
    }
}
