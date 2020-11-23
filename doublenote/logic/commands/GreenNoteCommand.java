package ge.doublenote.logic.commands;

import ge.doublenote.logic.NoteFactory;

public class GreenNoteCommand extends NoteCommand {

    public GreenNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateGreenNote();

    }
}