package ge.doublenote.songs;

import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;
import ge.doublenote.logic.commands.BlueNoteCommand;
import ge.doublenote.logic.commands.NoteCommand;
import ge.doublenote.logic.commands.RedNoteCommand;

import java.util.concurrent.TimeUnit;

public class FurElise extends Song {

    public FurElise(SceneManager sm, String filePath, String name, NoteFactory nf) {
        super(sm, filePath,name,nf);
        LoadNotes();

    }

    @Override
    public void LoadNotes() {

        NoteCommand nc = new BlueNoteCommand(nf);
        noteQueue.add(nc);

        ///Read Json File

    }

    @Override
    public void SpawnNotes() {

        try {

        while(running) {

            TimeUnit.MILLISECONDS.sleep(100);

            if(noteQueue.size() != 0) {
                NoteCommand n = noteQueue.pop();
                n.execute();
                System.out.println("Executing Note");
            }

                if(sm.getKeyManager().t()) {
                    System.out.println("Hit This inside Fur Elise");
                    running = false;
                    LoadNotes();
                }
            }
        }

        catch(InterruptedException ex)

        {
            Thread.currentThread().interrupt();
        }
    }
}