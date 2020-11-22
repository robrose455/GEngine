package ge.doublenote.songs;

import ge.doublenote.logic.NoteFactory;

import java.util.concurrent.TimeUnit;

public class ToadFactory extends Song {

    public ToadFactory(String filePath, String name, NoteFactory nf) {
        super(filePath,name,nf);

    }

    @Override
    public void SpawnNotes() {

        try {

            nf.CreateRedNote();
            TimeUnit.MILLISECONDS.sleep(480);
            nf.CreateOrangeNote();
            nf.CreateRedNote();
            TimeUnit.MILLISECONDS.sleep(480);
            nf.CreateYellowNote();
            TimeUnit.MILLISECONDS.sleep(480);
            nf.CreateWhiteNote();
            nf.CreateBlueNote();
            nf.CreateRedNote();
            TimeUnit.MILLISECONDS.sleep(480);
            nf.CreatePurpleNote();
            TimeUnit.MILLISECONDS.sleep(480);
            nf.CreateBlueNote();
            nf.CreateRedNote();
            TimeUnit.MILLISECONDS.sleep(480);
            nf.CreateGreenNote();
            nf.CreateLBlueNote();

        }

        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
