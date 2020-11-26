package ge.prismrhythm.states;

import ge.core.managers.SceneManager;
import ge.core.State;

import java.awt.*;
import java.io.FileNotFoundException;

public class End extends State {

    public End(SceneManager sm) {
        super(sm);

        this.name = "end";

    }
    @Override
    public void Init() {


    }

    @Override
    public void Update() throws FileNotFoundException, InterruptedException {

        if(sm.getKeyManager().t()) {
            sm.getGameStateManager().setCurState("Menu");
        }

    }

    @Override
    public void DrawSprites(Graphics g) {

        DrawText(g);

    }

    @Override
    public void DrawText(Graphics g) {

        Font bigFont = new Font("Verdana", Font.BOLD, 45);
        Font medFont = new Font("Verdana", Font.PLAIN, 30);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(bigFont);
        g.setColor(Color.WHITE);
        g.drawString("SONG COMPLETE", 315, 100);

        g.setFont(medFont);
        g.drawString("Use 'ENTER' to return to menu!", 270, 300);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

        g.setFont(medFont);

    }
}
