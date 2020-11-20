package ge.doublenote;

import ge.core.KeyManager;
import ge.core.SceneManager;
import ge.core.sprite.Sprite;
import ge.doublenote.sprite.Note;
import java.util.ArrayList;
public class NoteFactory {

    SceneManager sm;
    KeyManager km;

    ArrayList<Sprite> redNotes = new ArrayList<>();
    ArrayList<Sprite> orangeNotes = new ArrayList<>();
    ArrayList<Sprite> yellowNotes = new ArrayList<>();
    ArrayList<Sprite> whiteNotes = new ArrayList<>();
    ArrayList<Sprite> purpleNotes = new ArrayList<>();
    ArrayList<Sprite> blueNotes = new ArrayList<>();
    ArrayList<Sprite> lblueNotes = new ArrayList<>();
    ArrayList<Sprite> greenNotes = new ArrayList<>();


    public NoteFactory(SceneManager sm) {

        this.sm = sm;
        this.km = sm.getKeyManager();

    }

    public void CreateRedNote() {
        System.out.println("Making Note:");
        Sprite redNote = new Note(0, 10,0, 4, "RED", "DIE", "RedNote", km);
        redNotes.add(redNote);
    }
    public void CreateOrangeNote() {
        Sprite orangeNote = new Note(0, 10,0, 4, "ORANGE", "DIE", "OrangeNote", km);
        orangeNotes.add(orangeNote);
    }
    public void CreateYellowNote() {
        Sprite yellowNote = new Note(0, 10,0, 4, "YELLOW", "DIE", "YellowNote", km);
        yellowNotes.add(yellowNote);
    }
    public void CreateWhiteNote() {
        Sprite whiteNote = new Note(0, 10,0, 4, "WHITE", "DIE", "WhiteNote", km);
        whiteNotes.add(whiteNote);
    }
    public void CreateBlueNote() {
        Sprite blueNote = new Note(0, 10,0, 4, "BLUE", "DIE", "BlueNote", km);
        blueNotes.add(blueNote);
    }
    public void CreatePurpleNote() {
        Sprite purpleNote = new Note(0, 10,0, 4, "PURPLE", "DIE", "PurpleNote", km);
        purpleNotes.add(purpleNote);
    }
    public void CreateLBlueNote() {
        Sprite lblueNote = new Note(0, 10,0, 4, "LBLUE", "DIE", "LBlueNote", km);
        lblueNotes.add(lblueNote);
    }
    public void CreateGreenNote() {
        Sprite greenNote = new Note(0, 10,0, 4, "GREEN", "DIE", "GreenNote", km);
        greenNotes.add(greenNote);
    }

    public ArrayList<Sprite> getRedNotes() {
        return redNotes;
    }
    public ArrayList<Sprite> getOrangeNotes() {
        return orangeNotes;
    }
    public ArrayList<Sprite> getYellowNotes() {
        return yellowNotes;
    }
    public ArrayList<Sprite> getWhiteNotes() {
        return whiteNotes;
    }
    public ArrayList<Sprite> getPurpleNotes() {
        return purpleNotes;
    }
    public ArrayList<Sprite> getBlueNotes() {
        return blueNotes;
    }
    public ArrayList<Sprite> getLblueNotes() {
        return lblueNotes;
    }
    public ArrayList<Sprite> getGreenNotes() {
        return greenNotes;
    }


}
