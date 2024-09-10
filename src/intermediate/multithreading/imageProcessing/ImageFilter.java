package intermediate.multithreading.imageProcessing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFilter {
    public static void main(String...args){
        File file = new File("src/intermediate/multithreading/imageProcessing/photo.png");
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(file);
        }catch(IOException e){
            e.printStackTrace();
        }
        if (image != null) {
            display(image);
            image = toGrayScale2(image);
            display(image);
            display(toGrayScale(image));
        }
    }

    private static BufferedImage toGrayScale2(BufferedImage image) {
        System.out.println(" Converting to GrayScale2.");
        BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        int rgb=0, r=0, g=0, b=0;
        for(int y = 0; y < image.getHeight(); y++ ){
            for(int x = 0; x < image.getWidth(); x++ ){
               rgb = image.getRGB(x, y);
                r = ((rgb >> 16) & 0xFF);
                g = ((rgb >> 8) & 0xFF);
                b = (rgb  & 0xFF);
                rgb = (int)(0.299 * r + 0.587 * g + 0.144 * b);
                rgb = (255 << 24) | (rgb << 16 ) | (rgb << 8 )  | rgb;
                grayImage.setRGB(x, y, rgb);
            }
        }
        return grayImage;
    }

    private static BufferedImage toGrayScale(BufferedImage image) {
        System.out.println(" Converting to GrayScale.");
        BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics graphics = grayImage.getGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        return grayImage;
    }

    private static void display(BufferedImage image) {
        System.out.println(" Displaying image.");
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.setSize(image.getWidth(), image.getHeight());
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
