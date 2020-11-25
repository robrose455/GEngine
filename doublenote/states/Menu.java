package ge.doublenote.states;

import ge.core.managers.SceneManager;
import ge.core.State;
import ge.doublenote.songs.Song;
import ge.doublenote.sprites.MenuPointer;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Menu extends State {

    MenuPointer mp;
    int songCounter;

    public Menu(SceneManager sm) {
        super(sm);

        this.name = "Menu";

        mp = new MenuPointer(260,260,0,0,"Pointer","DIE","Menu Pointer", sm.getKeyManager(), 7);

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

        mp.DrawSprite(g);
        DrawText(g);

    }
    public void DrawText(Graphics g) {

        Font bigFont = new Font("Century Gothic", Font.BOLD, 80);
        Font medFont = new Font("Courier", Font.PLAIN, 30);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(bigFont);
        g.drawString("Double Note", 250, 100);
        g.setFont(medFont);
        g.drawString("Select a song with arrow keys", 250, 150);
        //Song Menu
        g.setColor(Color.WHITE);
        ArrayList<String> songTitles = sm.getGameStateManager().getSongManager().getSongTitles();
        int y = 300;
        for(int i = 0; i < songTitles.size(); i++ ) {
            g.drawString(songTitles.get(i), 300, y);
            y += 50;
        }

    }
}
