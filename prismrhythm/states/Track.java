package ge.prismrhythm.states;

import ge.core.managers.AudioManager;
import ge.core.managers.KeyManager;
import ge.core.managers.SceneManager;
import ge.core.State;
import ge.core.sprite.Sprite;
import ge.prismrhythm.logic.NoteFactory;
import ge.prismrhythm.logic.PointCounter;
import ge.prismrhythm.songs.Song;
import ge.prismrhythm.sprites.NoteHitter;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Track extends State {

    SceneManager sm;
    AudioManager am;
    PointCounter pc;
    NoteFactory nf;
    KeyManager km;
    Song song;

    Sprite redHitter;
    Sprite orangeHitter;
    Sprite yellowHitter;
    Sprite whiteHitter;
    Sprite purpleHitter;
    Sprite blueHitter;
    Sprite lblueHitter;
    Sprite greenHitter;

    ArrayList<NoteHitter> hitterList = new ArrayList<>();
    boolean songEnded = false;

    public Track(SceneManager sm, Song song) {
        super(sm);

        this.name = "Track";
        this.pc = new PointCounter();
        this.song = song;
        this.sm = sm;
        this.am = sm.getAudioManager();
        this.km = sm.getKeyManager();

    }

    @Override
    public void Init() throws InterruptedException {

        song.GARBAGE_setRun();
        song.getClip().PlaySong();
        if(hitterList.size() == 0) {

            NoteHitter redHitter = new NoteHitter(575, 900, 0, 0,  "RED", "DIE", "RedHitter", sm.getKeyManager());
            this.redHitter = redHitter;
            hitterList.add(redHitter);

            NoteHitter orangeHitter = new NoteHitter(625, 900, 0, 0,  "ORANGE", "DIE", "OrangeHitter", sm.getKeyManager());
            this.orangeHitter = orangeHitter;
            hitterList.add(orangeHitter);

            NoteHitter yellowHitter = new NoteHitter(675, 900, 0, 0,  "YELLOW", "DIE", "YellowHitter", sm.getKeyManager());
            this.yellowHitter = yellowHitter;
            hitterList.add(yellowHitter);

            NoteHitter whiteHitter = new NoteHitter(725, 900, 0, 0,  "WHITE", "DIE", "WhiteHitter", sm.getKeyManager());
            this.whiteHitter = whiteHitter;
            hitterList.add(whiteHitter);

            NoteHitter purpleHitter = new NoteHitter(425, 900, 0, 0,  "PURPLE", "DIE", "PurpleHitter", sm.getKeyManager());
            this.purpleHitter = purpleHitter;
            hitterList.add(purpleHitter);

            NoteHitter blueHitter = new NoteHitter(375, 900, 0, 0,  "BLUE", "DIE", "BlueHitter", sm.getKeyManager());
            this.blueHitter = blueHitter;
            hitterList.add(blueHitter);

            NoteHitter lblueHitter = new NoteHitter(325, 900, 0, 0,  "LBLUE", "DIE", "LBlueHitter", sm.getKeyManager());
            this.lblueHitter = lblueHitter;
            hitterList.add(lblueHitter);

            NoteHitter greenHitter = new NoteHitter(275, 900, 0, 0,  "GREEN", "DIE", "GreenHitter", sm.getKeyManager());
            this.greenHitter = greenHitter;
            hitterList.add(greenHitter);

        }

        this.nf = song.getNoteFactory();

        StartNoteSpawns();

    }
    @Override
    public void Update() throws FileNotFoundException, InterruptedException {

        for (int i = 0; i < hitterList.size(); i++) {
            hitterList.get(i).Update();
        }

        //Red Notes
        for (int i = 0; i < nf.getRedNotes().size(); i++) {
            if (redHitter.collidesWith(nf.getRedNotes().get(i))) {
                nf.getRedNotes().get(i).hit();
                if (nf.getRedNotes().get(i).isHit() && !(nf.getRedNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getRedNotes().get(i).used();
                }
            }

            if (nf.getRedNotes().get(i).getY() > 1200) {
                if(!nf.getRedNotes().get(i).isHit()){
                    nf.getRedNotes().get(i).missed();
                }
                if (nf.getRedNotes().get(i).hasBeenMissed() && !(nf.getRedNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getRedNotes().get(i).used();
                }

            }
            nf.getRedNotes().get(i).Update();
        }

        //Orange Notes
        for (int i = 0; i < nf.getOrangeNotes().size(); i++) {
            if (orangeHitter.collidesWith(nf.getOrangeNotes().get(i))) {
                nf.getOrangeNotes().get(i).hit();
                if (nf.getOrangeNotes().get(i).isHit() && !(nf.getOrangeNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getOrangeNotes().get(i).used();
                }
            }

            if (nf.getOrangeNotes().get(i).getY() > 1200) {
                if(!nf.getOrangeNotes().get(i).isHit()){
                    nf.getOrangeNotes().get(i).missed();
                }
                if (nf.getOrangeNotes().get(i).hasBeenMissed() && !(nf.getOrangeNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getOrangeNotes().get(i).used();
                }

            }
            nf.getOrangeNotes().get(i).Update();
        }
        //Yellow Notes
        for (int i = 0; i < nf.getYellowNotes().size(); i++) {
            if (yellowHitter.collidesWith(nf.getYellowNotes().get(i))) {
                nf.getYellowNotes().get(i).hit();
                if (nf.getYellowNotes().get(i).isHit() && !(nf.getYellowNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getYellowNotes().get(i).used();
                }
            }

            if (nf.getYellowNotes().get(i).getY() > 1200) {
                if(!nf.getYellowNotes().get(i).isHit()){
                    nf.getYellowNotes().get(i).missed();
                }
                if (nf.getYellowNotes().get(i).hasBeenMissed() && !(nf.getYellowNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getYellowNotes().get(i).used();
                }

            }
            nf.getYellowNotes().get(i).Update();
        }
        //White Notes
        for (int i = 0; i < nf.getWhiteNotes().size(); i++) {
            if (whiteHitter.collidesWith(nf.getWhiteNotes().get(i))) {
                nf.getWhiteNotes().get(i).hit();
                if (nf.getWhiteNotes().get(i).isHit() && !(nf.getWhiteNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getWhiteNotes().get(i).used();
                }
            }

            if (nf.getWhiteNotes().get(i).getY() > 1200) {
                if(!nf.getWhiteNotes().get(i).isHit()){
                    nf.getWhiteNotes().get(i).missed();
                }
                if (nf.getWhiteNotes().get(i).hasBeenMissed() && !(nf.getWhiteNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getWhiteNotes().get(i).used();
                }

            }
            nf.getWhiteNotes().get(i).Update();
        }
        //Purple Notes
        for (int i = 0; i < nf.getPurpleNotes().size(); i++) {
            if (purpleHitter.collidesWith(nf.getPurpleNotes().get(i))) {
                nf.getPurpleNotes().get(i).hit();
                if (nf.getPurpleNotes().get(i).isHit() && !(nf.getPurpleNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getPurpleNotes().get(i).used();
                }
            }

            if (nf.getPurpleNotes().get(i).getY() > 1200) {
                if(!nf.getPurpleNotes().get(i).isHit()){
                    nf.getPurpleNotes().get(i).missed();
                }
                if (nf.getPurpleNotes().get(i).hasBeenMissed() && !(nf.getPurpleNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getPurpleNotes().get(i).used();
                }

            }
            nf.getPurpleNotes().get(i).Update();
        }
        //Blue Notes
        for (int i = 0; i < nf.getBlueNotes().size(); i++) {
            if (blueHitter.collidesWith(nf.getBlueNotes().get(i))) {
                nf.getBlueNotes().get(i).hit();
                if (nf.getBlueNotes().get(i).isHit() && !(nf.getBlueNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getBlueNotes().get(i).used();
                }
            }

            if (nf.getBlueNotes().get(i).getY() > 1200) {
                if(!nf.getBlueNotes().get(i).isHit()){
                    nf.getBlueNotes().get(i).missed();
                }
                if (nf.getBlueNotes().get(i).hasBeenMissed() && !(nf.getBlueNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getBlueNotes().get(i).used();
                }

            }
            nf.getBlueNotes().get(i).Update();
        }
        //Lblue Notes
        for (int i = 0; i < nf.getLblueNotes().size(); i++) {
            if (lblueHitter.collidesWith(nf.getLblueNotes().get(i))) {
                nf.getLblueNotes().get(i).hit();
                if (nf.getLblueNotes().get(i).isHit() && !(nf.getLblueNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getLblueNotes().get(i).used();
                }
            }

            if (nf.getLblueNotes().get(i).getY() > 1200) {
                if(!nf.getLblueNotes().get(i).isHit()){
                    nf.getLblueNotes().get(i).missed();
                }
                if (nf.getLblueNotes().get(i).hasBeenMissed() && !(nf.getLblueNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getLblueNotes().get(i).used();
                }

            }
            nf.getLblueNotes().get(i).Update();
        }
        //Green Notes
        for (int i = 0; i < nf.getGreenNotes().size(); i++) {
            if (greenHitter.collidesWith(nf.getGreenNotes().get(i))) {
                nf.getGreenNotes().get(i).hit();
                if (nf.getGreenNotes().get(i).isHit() && !(nf.getGreenNotes().get(i).hasBeenUsed())) {
                    pc.AddPoints();
                    nf.getGreenNotes().get(i).used();
                }
            }

            if (nf.getGreenNotes().get(i).getY() > 1200) {
                if(!nf.getGreenNotes().get(i).isHit()){
                    nf.getGreenNotes().get(i).missed();
                }
                if (nf.getGreenNotes().get(i).hasBeenMissed() && !(nf.getGreenNotes().get(i).hasBeenUsed())) {
                    pc.ResetStreak();
                    nf.getGreenNotes().get(i).used();
                }

            }
            nf.getGreenNotes().get(i).Update();
        }

        songEnded = song.HasSongEnded();
        if (songEnded) {
            song.getClip().StopSong();
            sm.getGameStateManager().setCurState("end");
        }

    }

    @Override
    public void DrawSprites(Graphics g) {

        DrawTrack(g);

        //Draw the Hitters
        for (int i = 0; i < hitterList.size(); i++) {
            hitterList.get(i).DrawSprite(g);
        }

        //Red Notes
        for (int i = 0; i < nf.getRedNotes().size(); i++) {
            nf.getRedNotes().get(i).DrawSprite(g);
        }
        //Orange Notes
        for (int i = 0; i < nf.getOrangeNotes().size(); i++) {
            nf.getOrangeNotes().get(i).DrawSprite(g);
        }
        //Yellow Notes
        for (int i = 0; i < nf.getYellowNotes().size(); i++) {
            nf.getYellowNotes().get(i).DrawSprite(g);
        }
        //White Notes
        for (int i = 0; i < nf.getWhiteNotes().size(); i++) {
            nf.getWhiteNotes().get(i).DrawSprite(g);
        }
        //Purple Notes
        for (int i = 0; i < nf.getPurpleNotes().size(); i++) {
            nf.getPurpleNotes().get(i).DrawSprite(g);
        }
        //Blue Notes
        for (int i = 0; i < nf.getBlueNotes().size(); i++) {
            nf.getBlueNotes().get(i).DrawSprite(g);
        }
        //Lblue Notes
        for (int i = 0; i < nf.getLblueNotes().size(); i++) {
            nf.getLblueNotes().get(i).DrawSprite(g);
        }
        //Green Notes
        for (int i = 0; i < nf.getGreenNotes().size(); i++) {
            nf.getGreenNotes().get(i).DrawSprite(g);
        }

        DrawText(g);

    }

    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 25);
        Font medFont = new Font("Verdana", Font.PLAIN, 20);

        g.setFont(bigFont);
        g.setColor(Color.WHITE);
        g.drawString(song.getName(), 25, 100);

        g.setFont(bigFont);
        g.drawString("POINTS: " + (pc.getPoints()), 25, 200);
        g.drawString("Multiplier: " + (pc.getMultiplier()) + "x",25, 230);

        g.setFont(medFont);
        g.setColor(Color.BLACK);
        g.drawString("A",290,935);
        g.drawString("S",340,935);
        g.drawString("D",390,935);
        g.drawString("F",440,935);

        g.drawString("J",590,935);
        g.drawString("K",640,935);
        g.drawString("L",690,935);
        g.drawString(";",740,935);

    }

    public void DrawTrack(Graphics g) {

        //Red Side Track
        g.setColor(Color.decode("#FA8282"));
        g.fillRect(575,0,50,1000);

        g.setColor(Color.decode("#f78c5e"));
        g.fillRect(625,0,50,1000);

        g.setColor(Color.decode("#f1f58e"));
        g.fillRect(675,0,50,1000);

        g.setColor(Color.decode("#f7f4f2"));
        g.fillRect(725,0,50,1000);

        //Blue Side Track
        g.setColor(Color.decode("#a668a2"));
        g.fillRect(425,0,50,1000);

        g.setColor(Color.decode("#818de3"));
        g.fillRect(375,0,50,1000);

        g.setColor(Color.decode("#77e6c8"));
        g.fillRect(325,0,50,1000);

        g.setColor(Color.decode("#6dd17a"));
        g.fillRect(275,0,50,1000);

        g.setColor(Color.BLACK);
        g.fillRect(0,890,1000,10);
        g.fillRect(0,950,1000,20);

        g.drawLine(324,0,324,950);
        g.drawLine(374,0,374,950);
        g.drawLine(424,0,424,950);

        g.drawLine(624,0,624,950);
        g.drawLine(674,0,674,950);
        g.drawLine(724,0,724,950);

        g.setColor(Color.GRAY);
        g.fillRect(265, 0, 8,1000);
        g.fillRect(477, 0, 8,1000);
        g.fillRect(565, 0, 8,1000);
        g.fillRect(777, 0, 8,1000);

    }

    public void StartNoteSpawns() throws InterruptedException {

        NoteThread thread = new NoteThread();
        thread.start();

    }


    public class NoteThread extends Thread {


        public void run() {
            song.SpawnNotes();
            System.out.println("Thread Kill");
        }

    }
}