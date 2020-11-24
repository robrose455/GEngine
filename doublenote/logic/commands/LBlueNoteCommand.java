package ge.doublenote.logic.commands;

import ge.doublenote.logic.NoteFactory;

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