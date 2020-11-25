package ge.prismrhythm.logic;

import ge.core.managers.KeyManager;
import ge.core.managers.SceneManager;
import ge.prismrhythm.sprites.Note;
import java.util.ArrayList;

public class NoteFactory {

    SceneManager sm;
    KeyManager km;

    ArrayList<Note> redNotes = new ArrayList<>();
    ArrayList<Note> orangeNotes = new ArrayList<>();
    ArrayList<Note> yellowNotes = new ArrayList<>();
    ArrayList<Note> whiteNotes = new ArrayList<>();
    ArrayList<Note> purpleNotes = new ArrayList<>();
    ArrayList<Note> blueNotes = new ArrayList<>();
    ArrayList<Note> lblueNotes = new ArrayList<>();
    ArrayList<Note> greenNotes = new ArrayList<>();

    int noteSpeed = 6;


    public NoteFactory(SceneManager sm) {

        this.sm = sm;
        this.km = sm.getKeyManager();

    }

    public void CreateRedNote() {
        Note redNote = new Note(0, 10,0, noteSpeed, "RED", "DIE", "RedNote", km);
        redNotes.add(redNote);
    }
    public void CreateOrangeNote() {
        Note orangeNote = new Note(0, 10,0, noteSpeed, "ORANGE", "DIE", "OrangeNote", km);
        orangeNotes.add(orangeNote);
    }
    public void CreateYellowNote() {
        Note yellowNote = new Note(0, 10,0, noteSpeed, "YELLOW", "DIE", "YellowNote", km);
        yellowNotes.add(yellowNote);
    }
    public void CreateWhiteNote() {
        Note whiteNote = new Note(0, 10,0, noteSpeed, "WHITE", "DIE", "WhiteNote", km);
        whiteNotes.add(whiteNote);
    }
    public void CreateBlueNote() {
        Note blueNote = new Note(0, 10,0, noteSpeed, "BLUE", "DIE", "BlueNote", km);
        blueNotes.add(blueNote);
    }
    public void CreatePurpleNote() {
        Note purpleNote = new Note(0, 10,0, noteSpeed, "PURPLE", "DIE", "PurpleNote", km);
        purpleNotes.add(purpleNote);
    }
    public void CreateLBlueNote() {
        Note lblueNote = new Note(0, 10,0, noteSpeed, "LBLUE", "DIE", "LBlueNote", km);
        lblueNotes.add(lblueNote);
    }
    public void CreateGreenNote() {
        Note greenNote = new Note(0, 10,0, noteSpeed, "GREEN", "DIE", "GreenNote", km);
        greenNotes.add(greenNote);
    }

    public ArrayList<Note> getRedNotes() {
        return redNotes;
    }
    public ArrayList<Note> getOrangeNotes() {
        return orangeNotes;
    }
    public ArrayList<Note> getYellowNotes() {
        return yellowNotes;
    }
    public ArrayList<Note> getWhiteNotes() {
        return whiteNotes;
    }
    public ArrayList<Note> getPurpleNotes() {
        return purpleNotes;
    }
    public ArrayList<Note> getBlueNotes() {
        return blueNotes;
    }
    public ArrayList<Note> getLblueNotes() {
        return lblueNotes;
    }
    public ArrayList<Note> getGreenNotes() {
        return greenNotes;
    }


}
