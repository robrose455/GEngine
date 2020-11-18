package ge.doublenote;

import ge.core.Game;
import ge.core.sprite.Sprite;
import ge.core.GameStateManager;
import ge.core.SceneManager;
import ge.core.SpriteManager;
import ge.doublenote.sprite.Note;
import ge.doublenote.sprite.NoteHitter;

import java.util.ArrayList;

public class DoubleNote extends Game {

    ArrayList<Sprite> spriteTemplates = new ArrayList<>();

    SceneManager sm;
    SpriteManager sprM;
    GameStateManager gsm;

    public DoubleNote() {
        super();

        System.out.println("--Creating Game--");

    }

    @Override
    public void Init(SceneManager sm) {


        this.sm = sm;
        DefineSprites();
        this.sprM = sm.getSpriteManager();
        this.gsm = sm.getGameStateManager();

        gsm.LoadStates();

    }

    public void Update() {

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



        Sprite redTarget = new Note(575, 10,0, 2, "RED", "DIE", "RedNote", sm.getKeyManager());
        spriteTemplates.add(redTarget);

        Sprite blueTarget = new Note(425, 10,0, 2, "BLUE", "DIE", "BlueNote", sm.getKeyManager());
        spriteTemplates.add(blueTarget);

    }

    public ArrayList<Sprite> getSpriteTemplates() {
        return spriteTemplates;
    }

    public void setCurState(String n) {
        gsm.setCurState(n);
    }

    public SceneManager GetSceneManager() {
        return sm;
    }
    public GameStateManager getGameStateManager() { return gsm; }

}
