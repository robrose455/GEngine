package ge.doublenote.songs;

import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;

import java.util.concurrent.TimeUnit;

public class HotelRoomService extends Song {

    public HotelRoomService(SceneManager sm, String filePath, String name, NoteFactory nf) {
        super(sm, filePath,name,nf);

    }

    @Override
    public void LoadNotes() {

    }

    @Override
    public void SpawnNotes() {

        try {

            TimeUnit.MILLISECONDS.sleep(21000);

        }

        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
