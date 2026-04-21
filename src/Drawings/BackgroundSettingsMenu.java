package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class BackgroundSettingsMenu extends JPanel {
    DrawClouds drawCloud = new DrawClouds();
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawCloud.drawClouds(-70, 3, g2d);
        drawCloud.drawSmalClouds(215, 145, g2d);

    }
}
