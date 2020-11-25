package ge.prismrhythm.logic.commands;

import ge.prismrhythm.logic.NoteFactory;

public class YellowNoteCommand extends NoteCommand {

    public YellowNoteCommand(NoteFactory nf) {
        super(nf);
    }

    @Override
    public void execute() {

        nf.CreateYellowNote();

    }

    @Override
    public String getColor() {
        return "Yellow";
    }
}