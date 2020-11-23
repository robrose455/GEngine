package ge.doublenote.songs;

import ge.doublenote.logic.NoteFactory;

import java.util.concurrent.TimeUnit;

public class HotelRoomService extends Song {

    public HotelRoomService(String filePath, String name, NoteFactory nf) {
        super(filePath,name,nf);

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
