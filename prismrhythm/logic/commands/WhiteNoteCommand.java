package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

public class WhiteNoteCommand extends NoteCommand {

    public WhiteNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateWhiteNote();

    }

    @Override
    public String getColor() {
        return "White";
    }
}