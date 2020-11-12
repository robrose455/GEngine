package ge;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Snake extends Game {

    int player_speed = 10;
    int player_x = 10;
    int player_y = 10;
    int player2_x = 500;
    int player2_y = 500;

    int points = 1000;

    String controllerType;
    String cranImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\cranberry.png";
    String appleImagePath = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\apple.png";

    SpriteArrowController s = new SpriteArrowController();
    SpriteWASDController w = new SpriteWASDController();

    ArrayList<Sprite> spriteTemplates = new ArrayList<Sprite>();
    ArrayList<Sprite> activeSprites = new ArrayList<Sprite>();

    Scene sc;
    SceneManager sm;
    SpriteManager sprM;
    GameStateManager gsm;

    public Snake(Scene sc) {
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
        CreateSprite("Cranberry");
        CreateSprite("Redberry");

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
        Sprite cranberry = new Sprite(player_x, player_y, player_speed, w, cranImagePath, "WRAP", "Cranberry",sc);
        spriteTemplates.add(cranberry);

        Sprite redberry = new Sprite(player2_x, player2_y, player_speed, s, cranImagePath, "WRAP", "Redberry",sc);
        spriteTemplates.add(redberry);

        Sprite yellowberry = new Sprite(player2_x - 50, player2_y, player_speed, s, cranImagePath, "WRAP", "Yellowberry",sc);
        spriteTemplates.add(yellowberry);

    }

    public void CreateSprite(String name) {

        for (int i = 0; i < spriteTemplates.size(); i++) {
             String n = (spriteTemplates.get(i).getName());
             if (n.equals(name)) {
                 activeSprites.add(spriteTemplates.get(i));
             }
        }


    }
    @Override
    public ArrayList<Sprite> GetSprites() {
        return activeSprites;
    }


}
