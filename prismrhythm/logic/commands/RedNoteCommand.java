package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

public class RedNoteCommand extends NoteCommand {

    public RedNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateRedNote();

    }

    @Override
    public String getColor() {
        return "Red";
    }

}
