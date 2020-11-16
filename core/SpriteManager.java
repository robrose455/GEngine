package ge.core;

import ge.core.sprite.Sprite;
import ge.game.Game;

import java.util.ArrayList;



public class SpriteManager {

    Game g;

    ArrayList<Sprite> spriteList;
    ArrayList<Sprite> playerSpriteList;

    public SpriteManager(Game g) {

        System.out.println("--Creating Sprite Manager--");
        this.g = g;
        spriteList = g.GetSprites();
        playerSpriteList = g.GetPlayerSprites();

    }


    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    public void removeSprite(String name) {

        for(int i = 0; i < spriteList.size(); i++) {
            if(spriteList.get(i).getName().equals(name)) {
                    spriteList.remove(i);
            }
        }

        for(int i = 0; i < playerSpriteList.size(); i++) {
            if(playerSpriteList.get(i).getName().equals(name)) {
                playerSpriteList.remove(i);
            }
        }
        System.out.println("Size of SpritesList: " + spriteList.size());
    }

    public ArrayList<Sprite> getActiveSprites() {
        spriteList = g.GetSprites();
        return spriteList;
    }

    public ArrayList<Sprite> getActivePlayerSprites() {return playerSpriteList;}

    public Game getGame() { return g; }


}
