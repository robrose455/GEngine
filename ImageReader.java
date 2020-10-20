package ge;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageReader {

    String filePath;

    public static BufferedImage image;

    public ImageReader() {

    }

    public BufferedImage readImage(String filePath) {

        try{
            //System.out.println("Reading Image");
            image = ImageIO.read(new File(filePath));
            //System.out.println("Image Read");
        } catch (IOException e) {
            //System.out.println("Image Could Not be Read");
        }

        return image;
    }




}
