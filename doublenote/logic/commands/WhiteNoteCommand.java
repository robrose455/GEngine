package ge.doublenote.logic.commands;

import ge.doublenote.logic.NoteFactory;

public class WhiteNoteCommand extends NoteCommand {

    public WhiteNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateWhiteNote();

    }
}