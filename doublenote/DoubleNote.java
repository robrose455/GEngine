package ge.doublenote;

import ge.core.Game;
import ge.core.sprite.Sprite;
import ge.core.GameStateManager;
import ge.core.SceneManager;
import ge.core.SpriteManager;
import ge.doublenote.sprite.Note;
import ge.doublenote.sprite.NoteHitter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DoubleNote extends Game {

    ArrayList<Sprite> spriteTemplates = new ArrayList<>();

    SceneManager sm;
    SpriteManager sprM;
    GameStateManager gsm;
    SongManager songM = new SongManager();

    public DoubleNote() {
        super();

        System.out.println("--Creating Game--");

    }

    @Override
    public void Init(SceneManager sm) throws FileNotFoundException, InterruptedException {


        this.sm = sm;

        LoadSongs();

        DefineSprites();

        this.sprM = sm.getSpriteManager();
        this.gsm = sm.getGameStateManager();

        gsm.LoadStates();

    }

    public void Update() throws FileNotFoundException, InterruptedException {

        if(gsm.isWinner()) {
            gsm.setCurState("win");
        }
        gsm.getCurState().Update();

    }

    @Override
    public void DefineSprites() {

        //Place to define template for all sprites in game
        Sprite redHitter = new NoteHitter(575, 900, 0, 0,  "RED", "DIE", "RedHitter", sm.getKeyManager());
        spriteTemplates.add(redHitter);

        Sprite orangeHitter = new NoteHitter(625, 900, 0, 0,  "ORANGE", "DIE", "OrangeHitter", sm.getKeyManager());
        spriteTemplates.add(orangeHitter);

        Sprite yellowHitter = new NoteHitter(675, 900, 0, 0,  "YELLOW", "DIE", "YellowHitter", sm.getKeyManager());
        spriteTemplates.add(yellowHitter);

        Sprite whiteHitter = new NoteHitter(725, 900, 0, 0,  "WHITE", "DIE", "WhiteHitter", sm.getKeyManager());
        spriteTemplates.add(whiteHitter);

        Sprite purpleHitter = new NoteHitter(425, 900, 0, 0,  "PURPLE", "DIE", "PurpleHitter", sm.getKeyManager());
        spriteTemplates.add(purpleHitter);

        Sprite blueHitter = new NoteHitter(375, 900, 0, 0,  "BLUE", "DIE", "BlueHitter", sm.getKeyManager());
        spriteTemplates.add(blueHitter);

        Sprite lblueHitter = new NoteHitter(325, 900, 0, 0,  "LBLUE", "DIE", "LBlueHitter", sm.getKeyManager());
        spriteTemplates.add(lblueHitter);

        Sprite greenHitter = new NoteHitter(275, 900, 0, 0,  "GREEN", "DIE", "GreenHitter", sm.getKeyManager());
        spriteTemplates.add(greenHitter);



    }

    public void LoadSongs() {

        NoteFactory nf = new NoteFactory(sm);

        Song merrygoroundoflife = new MerryGoRoundOfLife("C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/howls.wav", "Merry Go Round of Life",nf);
        songM.AddSong(merrygoroundoflife);

        Song hotelroomservice = new HotelRoomService("C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/hotelroomservice.wav", "Hotel Room Service",nf);
        songM.AddSong(hotelroomservice);

        Song beefoven = new Beefoven("C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/Beefoven.wav", "Beefoven",nf);
        songM.AddSong(beefoven);

        Song furelise = new FurElise("C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/FurElise.wav", "FurElise",nf);
        songM.AddSong(furelise);



    }

    public ArrayList<Sprite> getSpriteTemplates() {
        return spriteTemplates;
    }

    public void setCurState(String n) throws FileNotFoundException, InterruptedException {
        gsm.setCurState(n);
    }

    public SceneManager GetSceneManager() {
        return sm;
    }
    public GameStateManager getGameStateManager() { return gsm; }
    public SongManager getSongManager() { return songM; }

}
