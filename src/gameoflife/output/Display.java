package gameoflife.output;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas {

    private static Canvas canvas;

    public Display(int width, int height, String title) {
        checkDimensions(width, height);
        createComponents(width, height, title);
    }

    private void checkDimensions(int width, int height) {
        if (width <=0 || height <= 0) {
            throw new IllegalArgumentException("Display dimensions cannot be negative.");
        }
    }

    private void createComponents(int width, int height, String title) {
        createCanvas(width, height);
        createJFrame(title);
    }

    private void createCanvas(int width, int height) {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
    }

    private void createJFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Canvas getCanvas() {
        return canvas;
    }

}