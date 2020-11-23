package ge.doublenote.logic.commands;


import ge.doublenote.logic.NoteFactory;

public abstract class NoteCommand {

    NoteFactory nf;

    public NoteCommand(NoteFactory nf) {
        this.nf = nf;
    }

    public abstract void execute();

}
