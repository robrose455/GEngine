package ge.game;

import ge.core.sprite.PlayerSprite;
import ge.core.sprite.Sprite;
import ge.core.sprite.controller.SpriteArrowController;
import ge.core.sprite.controller.SpriteWASDController;
import ge.core.GameStateManager;
import ge.core.Scene;
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

    int points = 1000;

    String cran = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\assets\\Cranberry.png";
    String note = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\assets\\icon.png";

    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

    ArrayList<Sprite> spriteTemplates = new ArrayList<>();
    ArrayList<Sprite> activeSprites = new ArrayList<>();
    ArrayList<Sprite> activePlayerSprites = new ArrayList<>();

    Scene sc;
    SceneManager sm;
    SpriteManager sprM;
    GameStateManager gsm;

    public DoubleNote(Scene sc) {
        super(sc);

        System.out.println("--Creating Game--");
        this.sc = sc;

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

        gsm.getCurState().Update();

        //Declare Winner when condition met
        if(!gsm.isWinner()) {

            points--;

        }
    }

    @Override
    public void DefineSprites() {

        //Place to define template for all sprites in game
        Sprite redPlayer = new PlayerSprite(player_x, player_y, player_dx, player_dy, w, "Red", "DIE", "RedPlayer",sc);
        spriteTemplates.add(redPlayer);

        Sprite bluePlayer = new PlayerSprite(player2_x, player2_y, 0, 0, s, "Blue", "DIE", "BluePlayer",sc);
        spriteTemplates.add(bluePlayer);

        Sprite redTarget = new Sprite(100, 100,0, 0, "RedT", "DIE", "RedTarget",sc);
        spriteTemplates.add(redTarget);

        Sprite blueTarget = new Sprite(900, 100,0, 0, "BlueT", "DIE", "BlueTarget",sc);
        spriteTemplates.add(blueTarget);

        //System.out.println("In DefineSprites(): We made # of sprites: " + spriteTemplates.size());


    }

    public void CreateSprite(String name) {

       // System.out.println("Adding Sprite to list in doubleNote");
        for (int i = 0; i < spriteTemplates.size(); i++) {
            String n = (spriteTemplates.get(i).getName());
            if (n.equals(name)) {
                activeSprites.add(spriteTemplates.get(i));
            }
        }
        //System.out.println("Current Number of Sprites in DoubleNote In CreateSprite: " + activeSprites.size());
    }

    public void CreatePlayerSprite(String name) {

        //System.out.println("Adding Player Sprite to list in doubleNote");
        for (int i = 0; i < spriteTemplates.size(); i++) {
            String n = (spriteTemplates.get(i).getName());
            if (n.equals(name)) {
                activeSprites.add(spriteTemplates.get(i));
                activePlayerSprites.add(spriteTemplates.get(i));
            }
        }
        //System.out.println("Current Number of Sprites in DoubleNote In CreatePlayerSprite: " + activeSprites.size());
    }

    public ArrayList<Sprite> GetSprites() {
        return activeSprites;
    }

    public ArrayList<Sprite> GetPlayerSprites() {
        return activePlayerSprites;
    }

    public void setCurState(int index) {
        gsm.setCurState(index);
    }

    public SceneManager GetSceneManager() {
        return sm;
    }

    public void DeleteSprite(String n) {
        sprM.removeSprite(n);
    }
}
