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

    public Song FurElise() throws IOException {

        Song furelise = new FurElise(sm,"/resources/songs/FurElise.wav", "Fur Elise",nf);
        return furelise;
    }

    public Song Hotmk() throws IOException {

        Song hotmk = new Hotmk(sm,"/resources/songs/hotmk.wav", "Hall of the Mountain King (Medium)",nf);
        return hotmk;

    }

    public Song CoconutMall() {

        Song coconutmall = new CoconutMall(sm,"/resources/songs/coconutmall.wav", "Coconut Mall",nf);
        return coconutmall;

    }
}
