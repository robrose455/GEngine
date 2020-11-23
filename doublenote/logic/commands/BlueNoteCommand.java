package ge.doublenote.logic.commands;

import ge.doublenote.logic.NoteFactory;

public class BlueNoteCommand extends NoteCommand {

    public BlueNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateBlueNote();

    }
}