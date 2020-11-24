package ge.doublenote.logic.commands;

import ge.doublenote.logic.NoteFactory;

public class PurpleNoteCommand extends NoteCommand {

    public PurpleNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreatePurpleNote();

    }

    @Override
    public String getColor() {
        return "Purple";
    }
}