package ge.doublenote.songs;

import ge.doublenote.logic.NoteFactory;

import java.util.concurrent.TimeUnit;

public class Beefoven extends Song {

    public Beefoven(String filePath, String name, NoteFactory nf) {
        super(filePath,name,nf);

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
