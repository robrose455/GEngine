package ge;

import ge.core.GameStateManager;
import ge.core.Scene;
import ge.core.SceneManager;

import java.util.ArrayList;

public class DoubleNote extends Game {

    int player_x = 10;
    int player_y = 10;
    int player_dx = 0;
    int player_dy = 0;
    int player2_x = 500;
    int player2_y = 500;

    int points = 1000;

    String controllerType;
    String cranImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\assets\\Cranberry.png";
    String noteImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\assets\\icon.png";

    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

    ArrayList<Sprite> spriteTemplates = new ArrayList<Sprite>();
    ArrayList<Sprite> activeSprites = new ArrayList<Sprite>();
    ArrayList<Sprite> activePlayerSprites = new ArrayList<>();

    Scene sc;
    SceneManager sm;
    SpriteManager sprM;
    GameStateManager gsm;

    public DoubleNote(Scene sc) {
        super(sc);

        this.sc = sc;

    }

    @Override
    public void Init(SceneManager sm) {

        this.sm = sm;
        this.sprM = sm.getSpriteManager();
        this.gsm = sm.getGameStateManager();
        //Define Startup Methods
        DefineSprites();

        CreatePlayerSprite("RedPlayer");
        CreatePlayerSprite("BluePlayer");

        CreateSprite("RedTarget");
        CreateSprite("BlueTarget");

    }

    public void Update() {

        //Checks For Movement
        for (int i = 0; i < sprM.getActiveSprites().size(); i++) {
            sprM.getActiveSprites().get(i).Update();
        }

        //Checks for collision
        if(sprM.getActiveSprites().get(0).collidesWith(sprM.getActiveSprites().get(1))) {
            gsm.Win();
        }

        //Declare Winner when condition met
        if(!gsm.isWinner()) {

            points--;

        }


    }

    @Override
    public void DefineSprites() {

        //Place to define template for all sprites in game
        Sprite redPlayer = new PlayerSprite(player_x, player_y, player_dx, player_dy, w, cranImagePath, "WRAP", "RedPlayer",sc);
        spriteTemplates.add(redPlayer);

        Sprite bluePlayer = new PlayerSprite(player2_x, player2_y, 0, 0, s, cranImagePath, "WRAP", "BluePlayer",sc);
        spriteTemplates.add(bluePlayer);

        Sprite redTarget = new PlayerSprite(200 - 50, player2_y,0, 0,s, cranImagePath, "WRAP", "RedTarget",sc);
        spriteTemplates.add(redTarget);

        Sprite blueTarget = new PlayerSprite(700, player2_y,0, 0,s, cranImagePath, "WRAP", "BlueTarget",sc);
        spriteTemplates.add(blueTarget);

    }

    public void CreateSprite(String name) {

        for (int i = 0; i < spriteTemplates.size(); i++) {
             String n = (spriteTemplates.get(i).getName());
             if (n.equals(name)) {
                 activeSprites.add(spriteTemplates.get(i));
             }
        }


    }

    public void CreatePlayerSprite(String name) {

        for (int i = 0; i < spriteTemplates.size(); i++) {
            String n = (spriteTemplates.get(i).getName());
            if (n.equals(name)) {
                activeSprites.add(spriteTemplates.get(i));
                activePlayerSprites.add(spriteTemplates.get(i));
            }
        }
    }

    @Override
    public ArrayList<Sprite> GetSprites() {
        return activeSprites;
    }

    public ArrayList<Sprite> GetPlayerSprites() {
        return activePlayerSprites;
    }


}
