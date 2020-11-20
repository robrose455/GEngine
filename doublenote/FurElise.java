package ge.doublenote;

import java.util.concurrent.TimeUnit;

public class FurElise extends Song {

    public FurElise(String filePath, String name, NoteFactory nf) {
        super(filePath,name,nf);

    }

    @Override
    public void SpawnNotes() {

        System.out.println("Inside Beef Oven");
        try {

            TimeUnit.MILLISECONDS.sleep(3000);

            nf.CreateOrangeNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateYellowNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateOrangeNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateYellowNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateOrangeNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateYellowNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateOrangeNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateYellowNote();
            TimeUnit.MILLISECONDS.sleep(125);
            nf.CreateOrangeNote();
            TimeUnit.MILLISECONDS.sleep(125);

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