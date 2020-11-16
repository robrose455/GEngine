package ge;

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
    String cran = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\assets\\Cranberry.png";
    String note = "C:\\Users\\Robert\\Projects\\Java\\JavaGameEngine\\src\\assets\\icon.png";

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

        DefineSprites();
        this.sm = sm;
        this.sprM = sm.getSpriteManager();
        this.gsm = sm.getGameStateManager();

        gsm.LoadStates();

    }

    public void Update() {

        //Checks For Movement
        //System.out.println("Update In DoubleNote");
        //System.out.println("Current Number of Sprites in DoubleNote In Update: " + activeSprites.size());
        gsm.curState.Update();

        //Declare Winner when condition met
        if(!gsm.isWinner()) {

            points--;

        }
    }

    @Override
    public void DefineSprites() {

        //Place to define template for all sprites in game
        Sprite redPlayer = new PlayerSprite(player_x, player_y, player_dx, player_dy, w, cran, "WRAP", "RedPlayer",sc);
        spriteTemplates.add(redPlayer);

        Sprite bluePlayer = new PlayerSprite(player2_x, player2_y, 0, 0, s, cran, "WRAP", "BluePlayer",sc);
        spriteTemplates.add(bluePlayer);

        Sprite redTarget = new Sprite(200 - 50, player2_y,0, 0, note, "WRAP", "RedTarget",sc);
        spriteTemplates.add(redTarget);

        Sprite blueTarget = new Sprite(700, player2_y,0, 0, note, "WRAP", "BlueTarget",sc);
        spriteTemplates.add(blueTarget);

        //System.out.println("In DefineSprites(): We made # of sprites: " + spriteTemplates.size());


    }

    public void CreateSprite(String name) {

       // System.out.println("Adding Sprite to list in doubleNote");
        for (int i = 0; i < spriteTemplates.size(); i++) {
            String n = (spriteTemplates.get(i).getName());
            if (n.equals(name)) {
                System.out.println("Hit This");
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
                //System.out.println("Hit This");
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
}