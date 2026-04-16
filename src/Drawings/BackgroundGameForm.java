package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class BackgroundGameForm extends JPanel {
    DrawClouds drawCloud = new DrawClouds();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawCloud.drawClouds(50, 10, g2d);
        drawCloud.drawClouds(500, 100, g2d);

    }
}
