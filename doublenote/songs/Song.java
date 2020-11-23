package ge.doublenote.songs;

import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;
import ge.doublenote.logic.commands.NoteCommand;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Song {

    public SceneManager sm;
    public String filePath;
    public String name;
    public NoteFactory nf;
    public Stack<NoteCommand> noteQueue = new Stack<>();
    public boolean running = true;
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

    public abstract void LoadNotes();

    public abstract void SpawnNotes();

}
