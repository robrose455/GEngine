package ge.prismrhythm.songs;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.NoteFactory;

import java.util.concurrent.TimeUnit;

public class Beefoven extends Song {

    public Beefoven(SceneManager sm, String filePath, String name, NoteFactory nf) {
        super(sm,filePath,name,nf);

    }

    @Override
    public void LoadNotes() {

    }

    @Override
    public void SpawnNotes() {

        try {

                TimeUnit.MILLISECONDS.sleep(480);


        }

        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
