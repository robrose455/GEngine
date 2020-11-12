package ge;
import java.awt.*;
import java.util.ArrayList;



public class SpriteManager {

    SceneManager sm;
    Game g;
    ArrayList<Sprite> spriteList = new ArrayList<Sprite>();

    public SpriteManager(SceneManager sm,Game g) {

        this.sm = sm;
        this.g = g;
        spriteList = g.GetSprites();

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

}
