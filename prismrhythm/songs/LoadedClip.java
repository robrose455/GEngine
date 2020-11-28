package ge.prismrhythm.songs;

import javax.sound.sampled.Clip;

public class LoadedClip {

    Clip clip;

    public LoadedClip(Clip c) {

        this.clip = c;
    }

    public void PlaySong() {
        clip.start();
    }
    public void StopSong() {
        clip.stop();
    }

}
