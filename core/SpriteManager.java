package ge.core;

import ge.core.sprite.Sprite;
import ge.game.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class SpriteManager {

    Game g;

    ArrayList<Sprite> sprites = new ArrayList<>();
    ArrayList<Sprite> playerSprites = new ArrayList<>();
    ArrayList<Sprite> spriteTemplates;

    public SpriteManager(Game g) {

        System.out.println("--Creating Sprite Manager--");
        this.g = g;

        //Loads Sprite Templates
        spriteTemplates = g.getSpriteTemplates();

    }


    public void addSprite(String name) {

        //System.out.println("Adding Sprite to SpriteList: " + name);
        for (int i = 0; i < spriteTemplates.size(); i++) {
            String n = (spriteTemplates.get(i).getName());
            if (n.equals(name)) {
                Sprite s = spriteTemplates.get(i);
                sprites.add(s);
            }
        }
        //System.out.println("SpriteList size: " + sprites.size());
    }

    public void addPlayerSprite(String name) {

        //System.out.println("Adding PlayerSprite to SpriteList: " + name);
        for (int i = 0; i < spriteTemplates.size(); i++) {
            String n = (spriteTemplates.get(i).getName());
            if (n.equals(name)) {
                Sprite s = spriteTemplates.get(i);
                sprites.add(s);
                playerSprites.add(s);
            }
        }
        //System.out.println("Player SpriteList size: " + sprites.size());
    }

    public void removeSprite(String name) {

        //System.out.println("Removing Sprite from SpriteList: " + name);
        for (int i = 0; i < sprites.size(); i++) {
            String n = (sprites.get(i).getName());
            if (n.equals(name)) {
                sprites.remove(sprites.get(i));
            }
        }
        //System.out.println("SpriteList size: " + sprites.size());
    }

    public void removePlayerSprite(String name) {

        for (int i = 0; i < sprites.size(); i++) {
            String n = (sprites.get(i).getName());
            if (n.equals(name)) {
                sprites.remove(sprites.get(i));
                playerSprites.remove(sprites.get(i));
            }
        }
    }

    public void ClearSprites(String n) {


    }

    public void SpriteReport() {


    }

    public Game getGame() { return g; }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
    public ArrayList<Sprite> getPlayerSprites() {
        return playerSprites;
    }


}
