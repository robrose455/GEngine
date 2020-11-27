package ge.prismrhythm.songs;

import javax.sound.sampled.Clip;

public class LoadedClip {

    Clip clip;

    public LoadedClip(Clip c) {

        this.clip = c;
    }


    public Clip getClip() {

        return clip;
    }

    public void PlaySong() {
        clip.start();
    }
    public void StopSong() {
        clip.stop();
    }

}
