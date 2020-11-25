package ge.prismrhythm.songs;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.NoteFactory;

import java.util.concurrent.TimeUnit;

public class MerryGoRoundOfLife extends Song {

    public MerryGoRoundOfLife(SceneManager sm,String filePath, String name, NoteFactory nf) {
        super(sm,filePath,name,nf);

    }

    @Override
    public void LoadNotes() {

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