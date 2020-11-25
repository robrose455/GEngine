package ge.prismrhythm.logic.commands;


import ge.prismrhythm.logic.NoteFactory;

public abstract class NoteCommand {

    NoteFactory nf;

    public NoteCommand(NoteFactory nf) {
        this.nf = nf;
    }

    public abstract void execute();
    public abstract String getColor();

}
