package ge.core.managers;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageReader {

    boolean imageFailed = false;

    public BufferedImage image;

    public ImageReader() {
    }

    public BufferedImage readImage(String filePath) {

        try{
            String path = "/resources/images/background.jpg";
            InputStream in = this.getClass().getResourceAsStream(path);
            image = ImageIO.read(in);
        } catch (IOException e) {
            imageFailed = true;
        }
        return image;
    }

    public boolean didImageFail() {
        return imageFailed;
    }
}