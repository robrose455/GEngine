package ge.doublenote.songs;

import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;
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

        NoteCommand nc = new RedNoteCommand(nf);
        noteQueue.add(nc);

        ///Read Json File

    }

    @Override
    public void SpawnNotes() {

        try {

        while(running) {

            TimeUnit.MILLISECONDS.sleep(1500);
            NoteCommand n = noteQueue.pop();
            n.execute();

                if(sm.getKeyManager().t()) {
                    running = false;
                }
            }
        }

        catch(InterruptedException ex)

        {
            Thread.currentThread().interrupt();
        }
    }
}