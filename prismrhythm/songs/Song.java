package ge.prismrhythm.songs;

import ge.core.managers.SceneManager;
import ge.prismrhythm.logic.NoteFactory;
import ge.prismrhythm.logic.commands.NoteCommand;

import java.io.IOException;
import java.util.Stack;

public abstract class Song {

    public SceneManager sm;
    public String filePath;
    public String name;
    public NoteFactory nf;
    public Stack<NoteCommand> noteQueue = new Stack<>();
    public boolean running = true;
    public boolean songEnded = false;
    public Song(SceneManager sm, String filePath, String name, NoteFactory nf) {

        //Will Store Sprite Track at Later Point
        this.sm = sm;
        this.filePath = filePath;
        this.name = name;
        this.nf = nf;

    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }

    public NoteFactory getNoteFactory() {
        return nf;
    }

    public abstract void LoadNotes() throws IOException;

    public abstract void SpawnNotes();

    public void GARBAGE_setRun() {
        running = true;
    }
    public boolean HasSongEnded() {
        return songEnded;
    }

}