package ge;
import java.util.ArrayList;

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

    public ArrayList<Sprite> getActiveSprites() {
        return spriteList;
    }
}
