package com.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductionImageView implements ICanShowImages {

    public void ShowImage(){
        try {
            // Acquire cancer image from the internet
            URL url = new URL("http://i0.kym-cdn.com/entries/icons/original/000/026/008/Screen_Shot_2018-04-25_at_12.24.22_PM.png");
            BufferedImage image = ImageIO.read(url);

            // Resize image
            BufferedImage resizedImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics2D.drawImage(image, 0, 0, 300, 300, null);
            graphics2D.dispose();

            // Display image
            ImageIcon icon = new ImageIcon(resizedImage);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(315,305);
            JLabel label = new JLabel();
            label.setIcon(icon);
            frame.add(label);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
