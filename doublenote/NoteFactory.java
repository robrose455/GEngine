package ge.doublenote;

import ge.core.KeyManager;
import ge.core.SceneManager;
import ge.core.SpriteManager;
import ge.core.sprite.Sprite;
import ge.doublenote.sprite.Note;
import ge.doublenote.sprite.NoteHitter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NoteFactory {

    Song s;
    SpriteManager sprM;
    KeyManager km;

    ArrayList<Sprite> redNotes = new ArrayList<>();
    ArrayList<Sprite> orangeNotes = new ArrayList<>();
    ArrayList<Sprite> yellowNotes = new ArrayList<>();
    ArrayList<Sprite> whiteNotes = new ArrayList<>();
    ArrayList<Sprite> purpleNotes = new ArrayList<>();
    ArrayList<Sprite> blueNotes = new ArrayList<>();
    ArrayList<Sprite> lblueNotes = new ArrayList<>();
    ArrayList<Sprite> greenNotes = new ArrayList<>();


    public NoteFactory(Song s, SpriteManager sprM, SceneManager sm) {

        this.s = s;
        this.sprM = sprM;
        this.km = sm.getKeyManager();

    }

    public void CreateRedNote() {
        Sprite redNote = new Note(0, 10,0, 6, "RED", "DIE", "RedNote", km);
        redNotes.add(redNote);
    }
    public void CreateOrangeNote() {
        Sprite orangeNote = new Note(0, 10,0, 6, "ORANGE", "DIE", "OrangeNote", km);
        orangeNotes.add(orangeNote);
    }
    public void CreateYellowNote() {
        Sprite yellowNote = new Note(0, 10,0, 2, "YELLOW", "DIE", "YellowNote", km);
        yellowNotes.add(yellowNote);
    }
    public void CreateWhiteNote() {
        Sprite whiteNote = new Note(0, 10,0, 2, "WHITE", "DIE", "WhiteNote", km);
        whiteNotes.add(whiteNote);
    }
    public void CreateBlueNote() {
        Sprite blueNote = new Note(0, 10,0, 2, "BLUE", "DIE", "BlueNote", km);
        blueNotes.add(blueNote);
    }
    public void CreatePurpleNote() {
        Sprite purpleNote = new Note(0, 10,0, 2, "PURPLE", "DIE", "PurpleNote", km);
        purpleNotes.add(purpleNote);
    }
    public void CreateLBlueNote() {
        Sprite lblueNote = new Note(0, 10,0, 2, "LBLUE", "DIE", "LBlueNote", km);
        lblueNotes.add(lblueNote);
    }
    public void CreateGreenNote() {
        Sprite greenNote = new Note(0, 10,0, 2, "GREEN", "DIE", "GreenNote", km);
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
