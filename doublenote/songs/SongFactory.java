package ge.doublenote.songs;

import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;

import java.io.IOException;

public class SongFactory {

    SceneManager sm;

    NoteFactory nf;

    public SongFactory(SceneManager sm) {

        this.sm = sm;
        this.nf = new NoteFactory(sm);

    }

    public Song FurElise() throws IOException {

        Song furelise = new FurElise(sm,"/resources/songs/FurElise.wav", "Fur Elise",nf);
        return furelise;
    }

    public Song Hotmk() throws IOException {

        Song hotmk = new Hotmk(sm,"/resources/songs/hotmk.wav", "Hall of the Mountain King (Medium)",nf);
        return hotmk;

    }
}
