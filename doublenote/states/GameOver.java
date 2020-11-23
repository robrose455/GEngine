package ge.doublenote.states;

import ge.core.managers.SceneManager;
import ge.core.State;

import java.awt.*;
import java.io.FileNotFoundException;

public class GameOver extends State {

    public GameOver(SceneManager sm) {
        super(sm);

        this.name = "gameOver";

    }
    @Override
    public void Init() {


    }

    @Override
    public void Update() throws FileNotFoundException, InterruptedException {


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
        g.drawString("GAME OVER", 315, 100);

        g.setFont(medFont);
        g.drawString("GAME OVER", 400, 200);
        g.drawString("CLICK ANYWHERE TO RETRY", 270, 300);

        g.setFont(smallFont);
        g.drawString("Created by Rob Rose", 800, 900);

        g.setFont(medFont);

    }
}
