package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

public class LBlueNoteCommand extends NoteCommand {

    public LBlueNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateLBlueNote();

    }

    @Override
    public String getColor() {
        return "LBlue";
    }
}