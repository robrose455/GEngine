package ge.core.managers;

import javax.sound.sampled.*;
import java.io.*;

public class AudioManager {

    Clip clip;
    public AudioManager() { }

    public Clip LoadSong(String filePath) {

        try {

            System.out.println("Reading Audio: " + filePath);
            InputStream in = this.getClass().getResourceAsStream(filePath);
            InputStream bufIn = new BufferedInputStream(in);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(bufIn));

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10f);

        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {

            System.out.print("ERROR: ");
            System.out.println(e.getMessage());
        }

        return clip;

    }

    public void PlaySong() {
        clip.start();
    }
    public void StopSong() {
        clip.stop();
    }


}
