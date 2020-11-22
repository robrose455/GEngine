package ge.doublenote.managers;

import ge.doublenote.songs.Song;

import java.util.ArrayList;

public class SongManager {

    ArrayList<Song> songList = new ArrayList<>();

    public SongManager() { }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void AddSong(Song s) {
        songList.add(s);
    }

}
