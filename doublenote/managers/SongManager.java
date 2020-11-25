package ge.doublenote.managers;

import ge.doublenote.songs.Song;

import java.util.ArrayList;

public class SongManager {

    ArrayList<String> songTitles = new ArrayList<>();

    public SongManager() { }

    public ArrayList<String> getSongTitles() {
        return songTitles;
    }

    public void AddTitle(String s) {
        songTitles.add(s);
    }

}
