package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

public class OrangeNoteCommand extends NoteCommand {

    public OrangeNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateOrangeNote();

    }

    @Override
    public String getColor() {
        return "Orange";
    }
}