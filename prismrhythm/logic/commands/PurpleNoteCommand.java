package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

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