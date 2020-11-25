package ge.prismrhythm.states;

import ge.core.managers.SceneManager;
import ge.core.State;
import ge.core.managers.ImageReader;
import ge.prismrhythm.sprites.MenuPointer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Menu extends State {

    MenuPointer mp;
    int songCounter;

    public Menu(SceneManager sm) {
        super(sm);

        this.name = "Menu";

        mp = new MenuPointer(0,0,0,0,"Pointer","DIE","Menu Pointer", sm.getKeyManager(), 2);

        System.out.println("--Creating State: Menu--");


    }

    @Override
    public void Init() {

        songCounter = 0;
        sm.getKeyManager().ResetMovement();

    }

    @Override
    public void Update() throws FileNotFoundException, InterruptedException {

        if(sm.getKeyManager().movingUp() && (songCounter > 0)) {
            songCounter--;
        }

        if(sm.getKeyManager().movingDown() && (songCounter < (sm.getGameStateManager().getSongManager().getSongTitles().size()-1))) {
            songCounter++;
        }

        if(sm.getKeyManager().enter()) {
            sm.getGameStateManager().RemoveTrack();
            sm.getGameStateManager().SetTrack(sm.getGameStateManager().getSongManager().getSongTitles().get(songCounter));
            sm.getGameStateManager().setCurState("Track");
            mp.Reset();
        }

        mp.Update();

    }

    @Override
    public void DrawSprites(Graphics g) {


        DrawText(g);
        mp.DrawSprite(g);

    }

    public void DrawBackground(Graphics g) {

        ImageReader im = new ImageReader();
        String imagePath = "resources/images/background.jpg";
        BufferedImage bgimage;
        bgimage = im.readImage(imagePath);
        g.drawImage(bgimage, 0, 0, null);

    }

    public void DrawText(Graphics g) {

        Font bigFont = new Font("Century Gothic", Font.BOLD, 80);
        Font medFont = new Font("Courier", Font.PLAIN, 30);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(medFont);

        DrawBackground(g);

        //Song Menu
        g.setColor(Color.BLACK);
        ArrayList<String> songTitles = sm.getGameStateManager().getSongManager().getSongTitles();
        int y = 450;
        for(int i = 0; i < songTitles.size(); i++ ) {
            g.drawString(songTitles.get(i), 300, y);
            y += 50;
        }

    }

    public void DrawLogo(Graphics g) {

        Font bigFont = new Font("Century Gothic", Font.BOLD, 80);

        g.setFont(bigFont);
        g.setColor(Color.RED);
        g.drawString("P",250,100);
        g.setColor(Color.ORANGE);
        g.drawString("R",280,100);
        g.setColor(Color.YELLOW);
        g.drawString("I",320,100);
        g.setColor(Color.GREEN);
        g.drawString("S",335,100);
        g.setColor(Color.BLUE);
        g.drawString("M",365,100);

        g.setColor(Color.RED);
        g.drawString("R",450,100);
        g.setColor(Color.ORANGE);
        g.drawString("H",480,100);
        g.setColor(Color.YELLOW);
        g.drawString("Y",520,100);
        g.setColor(Color.GREEN);
        g.drawString("T",560,100);
        g.setColor(Color.BLUE);
        g.drawString("H",585,100);
        g.setColor(Color.PINK);
        g.drawString("M",630,100);

    }
}
