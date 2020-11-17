package ge.game;

import ge.core.sprite.PlayerSprite;
import ge.core.sprite.Sprite;
import ge.core.sprite.controller.SpriteArrowController;
import ge.core.sprite.controller.SpriteWASDController;
import ge.core.GameStateManager;
import ge.core.SceneManager;
import ge.core.SpriteManager;

import java.util.ArrayList;

public class DoubleNote extends Game {

    int player_x = 10;
    int player_y = 500;
    int player_dx = 0;
    int player_dy = 0;
    int player2_x = 900;
    int player2_y = 500;

    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

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

        DefineSprites();

        this.sm = sm;
        this.sprM = sm.getSpriteManager();
        this.gsm = sm.getGameStateManager();

        gsm.LoadStates();

    }

    public void Update() {

        if(gsm.isWinner()) {
            gsm.setCurState(2);
        }
        gsm.getCurState().Update();

    }

    @Override
    public void DefineSprites() {

        //Place to define template for all sprites in game
        Sprite redPlayer = new PlayerSprite(player_x, player_y, player_dx, player_dy, w, "Red", "DIE", "RedPlayer");
        spriteTemplates.add(redPlayer);

        Sprite bluePlayer = new PlayerSprite(player2_x, player2_y, 0, 0, s, "Blue", "DIE", "BluePlayer");
        spriteTemplates.add(bluePlayer);

        Sprite redTarget = new Sprite(100, 100,0, 0, "RedT", "DIE", "RedTarget");
        spriteTemplates.add(redTarget);

        Sprite blueTarget = new Sprite(900, 100,0, 0, "BlueT", "DIE", "BlueTarget");
        spriteTemplates.add(blueTarget);

    }

    public ArrayList<Sprite> getSpriteTemplates() {
        return spriteTemplates;
    }

    public void setCurState(int index) {
        gsm.setCurState(index);
    }

    public SceneManager GetSceneManager() {
        return sm;
    }
    public GameStateManager getGameStateManager() { return gsm; }

}
