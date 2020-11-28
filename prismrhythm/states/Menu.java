package ge.prismrhythm.states;

import ge.core.managers.AudioManager;
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
    AudioManager am;

    public Menu(SceneManager sm) {
        super(sm);

        this.name = "Menu";
        this.am = new AudioManager();
        mp = new MenuPointer(0,0,0,0,"Pointer","DIE","Menu Pointer", sm.getKeyManager(), 2);
        System.out.println("--Creating State: Menu--");
        am.LoadSong("/resources/songs/background.wav");

    }

    @Override
    public void Init() {

        songCounter = 0;
        sm.getKeyManager().ResetMovement();
        am.PlaySong();
        sm.getGameStateManager().LoadClips();

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
            am.StopSong();
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

        Font medFont = new Font("Courier", Font.PLAIN, 30);
        Font sFont = new Font("Courier", Font.PLAIN, 20);
        g.setFont(medFont);

        DrawBackground(g);

        //Song Menu
        g.setColor(Color.BLACK);
        ArrayList<String> songTitles = sm.getGameStateManager().getSongManager().getSongTitles();
        int y = 450;


        for (String songTitle : songTitles) {
            g.drawString(songTitle, 300, y);
            y += 50;
        }

        g.setFont(sFont);
        g.drawString("Use Arrow Keys to Navigate Songs",300,800);
        g.drawString("Select song with 'Enter'",300,840);

    }
}
