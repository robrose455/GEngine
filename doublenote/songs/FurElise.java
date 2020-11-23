package ge.doublenote.songs;

import ge.doublenote.logic.NoteFactory;

import java.util.concurrent.TimeUnit;

public class FurElise extends Song {

    public FurElise(String filePath, String name, NoteFactory nf) {
        super(filePath,name,nf);

    }

    @Override
    public void SpawnNotes() {

        try {

            TimeUnit.MILLISECONDS.sleep(3000);

        }

        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}