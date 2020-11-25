package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

public class BlueNoteCommand extends NoteCommand {

    public BlueNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateBlueNote();

    }

    @Override
    public String getColor() {
        return "Blue";
    }
}