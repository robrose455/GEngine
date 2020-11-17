package ge.core;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageReader {

    boolean imageFailed = false;

    public static BufferedImage image;

    public ImageReader() {
        System.out.println("--Creating Image Reader--");
    }

    public BufferedImage readImage(String filePath) {

        try{
            //System.out.println("CURRENT FILEPATH: " filePath);
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