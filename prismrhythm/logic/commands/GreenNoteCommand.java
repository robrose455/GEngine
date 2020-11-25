package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

public class GreenNoteCommand extends NoteCommand {

    public GreenNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateGreenNote();

    }

    @Override
    public String getColor() {
        return "Green";
    }
}