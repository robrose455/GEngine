package ge;
import java.awt.*;
import java.util.ArrayList;



public class SpriteManager {

    SceneManager sm;
    Game g;
    ArrayList<Sprite> spriteList;
    ArrayList<PlayerSprite> playerSpriteList;

    public SpriteManager(SceneManager sm,Game g) {

        this.sm = sm;
        this.g = g;
        spriteList = g.GetSprites();
        parsePlayerSprites();

    }


    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    public void removeSprite(Sprite s, String name) {

        for(int i = 0; i < spriteList.size(); i++) {
            if(spriteList.get(i).getName().equals(name)) {
                    spriteList.remove(i);
            }
        }
    }

    public void drawSprites(Graphics g) {

        for (int i = 0; i < spriteList.size(); i++) {
            spriteList.get(i).DrawSprite(g);
        }
    }

    public ArrayList<Sprite> getActiveSprites() {
        return spriteList;
    }
    public ArrayList<PlayerSprite> getPlayerSprites() {return playerSpriteList;}

     public void parsePlayerSprites() {

        for (int i = 0; i < spriteList.size(); i++) {
            if(spriteList.get(i).TypeOfObject().equals("PlayerSprite")) {

                playerSpriteList.add((PlayerSprite) spriteList.get(i));
            }
        }
    }

}
