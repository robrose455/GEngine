package ge;
import java.awt.*;
import java.util.ArrayList;

/*

This class may be not needed for right but I believe adding this will have potential to create scalable sprite management in the future.
Would love to get feedback on if this class would be useful.

Only has basic "Add" and "Remove" Functionalites which is redundant with arrayList functionalites.

 */
public class SpriteManager {

    SceneManager sm;
    ArrayList<Sprite> spriteList = new ArrayList<Sprite>();

    public SpriteManager(SceneManager sm) {
        this.sm = sm;
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
