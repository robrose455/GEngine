package ge.core.managers;

import javax.sound.sampled.*;
import java.io.*;

public class AudioManager {

    Clip clip;
    public AudioManager() {

    }

    public void PlaySong() {
        clip.start();
    }

    public void LoadSong(String filePath) throws FileNotFoundException {


        try {

            System.out.println("Reading Audio: " + filePath);
            InputStream in = this.getClass().getResourceAsStream(filePath);
            InputStream bufIn = new BufferedInputStream(in);
            System.out.println("HIT HERE");
            clip = AudioSystem.getClip();
            System.out.println("HIT HERE2");
            clip.open(AudioSystem.getAudioInputStream(bufIn));
            System.out.println("AUDIO READ");

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0f);


        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {

            System.out.println(e.getMessage());
        }
    }

    public void StopSong() {
        clip.stop();
    }

}
