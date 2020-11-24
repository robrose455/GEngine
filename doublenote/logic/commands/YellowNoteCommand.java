package ge.doublenote.logic.commands;

import ge.doublenote.logic.NoteFactory;

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