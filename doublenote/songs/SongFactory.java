package ge.doublenote.songs;

import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;
import ge.doublenote.managers.SongManager;

import java.io.IOException;

public class SongFactory {

    SceneManager sm;

    NoteFactory nf;

    public SongFactory(SceneManager sm) {

        this.sm = sm;
        this.nf = new NoteFactory(sm);

    }

    public Song FurElise() throws IOException {

        Song furelise = new FurElise(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/FurElise.wav", "Fur Elise",nf);
        return furelise;
    }
}
