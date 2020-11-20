package ge.doublenote.state;

import ge.core.AudioManager;
import ge.core.KeyManager;
import ge.core.SceneManager;
import ge.core.SpriteManager;
import ge.core.sprite.Sprite;
import ge.doublenote.NoteFactory;
import ge.doublenote.PointCounter;
import ge.doublenote.Song;
import ge.doublenote.sprite.NoteHitter;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Track extends State {

    SpriteManager sprM;
    SceneManager sm;
    AudioManager am;
    PointCounter pc;
    NoteFactory nf;
    KeyManager km;
    Song s;


    Sprite redHitter;
    Sprite orangeHitter;
    Sprite yellowHitter;
    Sprite whiteHitter;
    Sprite purpleHitter;
    Sprite blueHitter;
    Sprite lblueHitter;
    Sprite greenHitter;

    ArrayList<Sprite> hitterList = new ArrayList<>();

    public Track(SpriteManager sprM, Song s) {
        super(sprM);

        this.pc = new PointCounter();
        this.am = new AudioManager();
        this.sprM = sprM;
        this.name = "Track";
        this.s = s;
        this.sm = sprM.getGame().GetSceneManager();
        this.km = sm.getKeyManager();

    }

    @Override
    public void Init() throws FileNotFoundException, InterruptedException {

        am.PlaySong(s.getFilePath());
        if(hitterList.size() == 0) {

            Sprite redHitter = new NoteHitter(575, 900, 0, 0,  "RED", "DIE", "RedHitter", sm.getKeyManager());
            this.redHitter = redHitter;
            hitterList.add(redHitter);

            Sprite orangeHitter = new NoteHitter(625, 900, 0, 0,  "ORANGE", "DIE", "OrangeHitter", sm.getKeyManager());
            this.orangeHitter = orangeHitter;
            hitterList.add(orangeHitter);

            Sprite yellowHitter = new NoteHitter(675, 900, 0, 0,  "YELLOW", "DIE", "YellowHitter", sm.getKeyManager());
            this.yellowHitter = yellowHitter;
            hitterList.add(yellowHitter);

            Sprite whiteHitter = new NoteHitter(725, 900, 0, 0,  "WHITE", "DIE", "WhiteHitter", sm.getKeyManager());
            this.whiteHitter = whiteHitter;
            hitterList.add(whiteHitter);

            Sprite purpleHitter = new NoteHitter(425, 900, 0, 0,  "PURPLE", "DIE", "PurpleHitter", sm.getKeyManager());
            this.purpleHitter = purpleHitter;
            hitterList.add(purpleHitter);

            Sprite blueHitter = new NoteHitter(375, 900, 0, 0,  "BLUE", "DIE", "BlueHitter", sm.getKeyManager());
            this.blueHitter = blueHitter;
            hitterList.add(blueHitter);

            Sprite lblueHitter = new NoteHitter(325, 900, 0, 0,  "LBLUE", "DIE", "LBlueHitter", sm.getKeyManager());
            this.lblueHitter = lblueHitter;
            hitterList.add(lblueHitter);

            Sprite greenHitter = new NoteHitter(275, 900, 0, 0,  "GREEN", "DIE", "GreenHitter", sm.getKeyManager());
            this.greenHitter = greenHitter;
            hitterList.add(greenHitter);

        }

        this.nf = s.getNoteFactory();
        nf.CreateRedNote();
        nf.CreateOrangeNote();
        nf.CreateYellowNote();
        nf.CreateWhiteNote();
        nf.CreatePurpleNote();
        nf.CreateBlueNote();
        nf.CreateGreenNote();
        nf.CreateLBlueNote();

        StartNoteSpawns();

    }
    @Override
    public void Update() {

        for (int i = 0; i < hitterList.size(); i++) {
            hitterList.get(i).Update();
        }

        //Red Notes
        for (int i = 0; i < nf.getRedNotes().size(); i++) {
            if(redHitter.collidesWith(nf.getRedNotes().get(i))){
                System.out.println("r dub");
                nf.getRedNotes().get(i).hit();
                if(nf.getRedNotes().get(i).isHit() && !(nf.getRedNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getRedNotes().get(i).used();
                }
            }
            nf.getRedNotes().get(i).Update();
        }

        //Orange Notes
        for (int i = 0; i < nf.getOrangeNotes().size(); i++) {
            if(orangeHitter.collidesWith(nf.getOrangeNotes().get(i))){
                System.out.println("o dub");
                nf.getOrangeNotes().get(i).hit();
                if(nf.getOrangeNotes().get(i).isHit() && !(nf.getOrangeNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getOrangeNotes().get(i).used();
                }
            }
            nf.getOrangeNotes().get(i).Update();
        }
        //Yellow Notes
        for (int i = 0; i < nf.getYellowNotes().size(); i++) {
            if(yellowHitter.collidesWith(nf.getYellowNotes().get(i))){
                System.out.println("dub");
                nf.getYellowNotes().get(i).hit();
                if(nf.getYellowNotes().get(i).isHit() && !(nf.getYellowNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getYellowNotes().get(i).used();
                }
            }
            nf.getYellowNotes().get(i).Update();
        }
        //White Notes
        for (int i = 0; i < nf.getWhiteNotes().size(); i++) {
            if(whiteHitter.collidesWith(nf.getWhiteNotes().get(i))){
                System.out.println("dub");
                nf.getWhiteNotes().get(i).hit();
                if(nf.getWhiteNotes().get(i).isHit() && !(nf.getWhiteNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getWhiteNotes().get(i).used();
                }
            }
            nf.getWhiteNotes().get(i).Update();
        }
        //Purple Notes
        for (int i = 0; i < nf.getPurpleNotes().size(); i++) {
            if(purpleHitter.collidesWith(nf.getPurpleNotes().get(i))){
                System.out.println("dub");
                nf.getPurpleNotes().get(i).hit();
                if(nf.getPurpleNotes().get(i).isHit() && !(nf.getPurpleNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getPurpleNotes().get(i).used();
                }
            }
            nf.getPurpleNotes().get(i).Update();
        }
        //Blue Notes
        for (int i = 0; i < nf.getBlueNotes().size(); i++) {
            if(blueHitter.collidesWith(nf.getBlueNotes().get(i))){
                System.out.println("dub");
                nf.getBlueNotes().get(i).hit();
                if(nf.getBlueNotes().get(i).isHit() && !(nf.getBlueNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getBlueNotes().get(i).used();
                }
            }
            nf.getBlueNotes().get(i).Update();
        }
        //Lblue Notes
        for (int i = 0; i < nf.getLblueNotes().size(); i++) {
            if(lblueHitter.collidesWith(nf.getLblueNotes().get(i))){
                System.out.println("dub");
                nf.getLblueNotes().get(i).hit();
                if(nf.getLblueNotes().get(i).isHit() && !(nf.getLblueNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getLblueNotes().get(i).used();
                }
            }
            nf.getLblueNotes().get(i).Update();
        }
        //Green Notes
        for (int i = 0; i < nf.getGreenNotes().size(); i++) {
            if(greenHitter.collidesWith(nf.getGreenNotes().get(i))){
                System.out.println("green dub");
                nf.getGreenNotes().get(i).hit();
                if(nf.getGreenNotes().get(i).isHit() && !(nf.getGreenNotes().get(i).hasBeenUsed())){
                    pc.addPoints(10);
                    nf.getGreenNotes().get(i).used();
                }
            }
            nf.getGreenNotes().get(i).Update();
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
            System.out.println("Drawing Note");
            System.out.println("Size of :" + nf.getRedNotes().size());
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
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(medFont);
        g.setColor(Color.WHITE);
        g.drawString(s.getName(), 25, 100);

        g.setFont(smallFont);
        g.drawString("Difficulty: Medium", 25, 150);

        g.setFont(bigFont);
        g.drawString("POINTS: " + (pc.getPoints()), 25, 200);

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

    public void StartNoteSpawns() {
        NoteThread thread = new NoteThread();
        thread.start();
    }


    public class NoteThread extends Thread {

        public void run() {
            s.SpawnNotes();
        }
    }
}
