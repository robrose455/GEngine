package ge.doublenote.game;

import ge.core.Game;
import ge.core.sprite.Sprite;
import ge.core.managers.GameStateManager;
import ge.core.managers.SceneManager;
import ge.doublenote.logic.NoteFactory;
import ge.doublenote.managers.SongManager;
import ge.doublenote.songs.*;
import ge.doublenote.sprites.NoteHitter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DoubleNote extends Game {

    ArrayList<Sprite> spriteTemplates = new ArrayList<>();

    SceneManager sm;
    GameStateManager gsm;
    SongManager songM = new SongManager();

    public DoubleNote() {
        super();

        System.out.println("--Creating Game--");

    }

    @Override
    public void Init(SceneManager sm) throws IOException, InterruptedException {


        this.sm = sm;

        LoadSongs();
        DefineSprites();

        this.gsm = sm.getGameStateManager();
        gsm.LoadStates();

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

    public void LoadSongs() throws IOException {

        NoteFactory nf = new NoteFactory(sm);

        Song merrygoroundoflife = new MerryGoRoundOfLife(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/howls.wav", "Merry Go Round of Life",nf);
        songM.AddSong(merrygoroundoflife);

        Song hotelroomservice = new HotelRoomService(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/hotelroomservice.wav", "Hotel Room Service",nf);
        songM.AddSong(hotelroomservice);

        Song beefoven = new Beefoven(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/Beefoven.wav", "Beefoven",nf);
        songM.AddSong(beefoven);

        Song furelise = new FurElise(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/FurElise.wav", "Fur Elise",nf);
        songM.AddSong(furelise);

        Song coconutmall = new CoconutMall(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/coconutmall.wav", "Coconut Mall",nf);
        songM.AddSong(coconutmall);

        Song toadfactory = new ToadFactory(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/toadfactory.wav", "Toads Factory",nf);
        songM.AddSong(toadfactory);

        Song hotmk = new Hotmk(sm,"C:/Users/Robert/Projects/Java/JavaGameEngine/src/assets/songs/hotmk.wav", "Hall of the Mountain King",nf);
        songM.AddSong(hotmk);

    }

    public ArrayList<Sprite> getSpriteTemplates() {
        return spriteTemplates;
    }

    public SceneManager GetSceneManager() {
        return sm;
    }
    public GameStateManager getGameStateManager() { return gsm; }
    public SongManager getSongManager() { return songM; }

}
