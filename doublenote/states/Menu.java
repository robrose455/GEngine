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

        if(sm.getKeyManager().movingDown() && (songCounter < (sm.getGameStateManager().getSongManager().getSongList().size()-1))) {
            songCounter++;
        }

        if(sm.getKeyManager().enter()) {
            sm.getGameStateManager().RemoveTrack();
            sm.getGameStateManager().SetTrack(sm.getGameStateManager().getSongManager().getSongList().get(songCounter).getName());
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

        Font bigFont = new Font("Verdana", Font.BOLD, 45);
        Font medFont = new Font("Verdana", Font.PLAIN, 30);
        Font smallFont = new Font("Verdana",Font.PLAIN, 12);

        g.setFont(medFont);
        g.setColor(Color.WHITE);
        ArrayList<Song> songList = sm.getGameStateManager().getSongManager().getSongList();
        int y = 300;
        for(int i = 0; i < songList.size(); i++ ) {
            g.drawString(songList.get(i).getName(), 300, y);
            y += 50;
        }

    }
}
