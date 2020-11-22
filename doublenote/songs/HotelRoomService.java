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

            nf.CreateLBlueNote();
            TimeUnit.MILLISECONDS.sleep(159);
            nf.CreateLBlueNote();
            TimeUnit.MILLISECONDS.sleep(159);
            nf.CreateBlueNote();
            TimeUnit.MILLISECONDS.sleep(159);
            nf.CreatePurpleNote();
            TimeUnit.MILLISECONDS.sleep(159);
            nf.CreateRedNote();







        }

        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
