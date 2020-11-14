package ge;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageReader {

    boolean imageFailed = false;

    public static BufferedImage image;

    public ImageReader() { }

    public BufferedImage readImage(String filePath) {

        try{
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            imageFailed = true;
        }
        return image;
    }

    public boolean didImageFail() {
        return imageFailed;
    }




}