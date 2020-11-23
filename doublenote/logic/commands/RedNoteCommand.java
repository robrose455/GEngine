package ge.doublenote.logic.commands;

import ge.doublenote.logic.NoteFactory;

public class RedNoteCommand extends NoteCommand {

    public RedNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateRedNote();

    }
}
