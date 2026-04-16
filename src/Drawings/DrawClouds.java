package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class DrawClouds extends JPanel {

    public void drawClouds(int cloudX, int cloudY, Graphics2D g2d){
    g2d.setStroke(new BasicStroke(3));
    g2d.drawArc(cloudX + 80, cloudY + 15, 45, 50, 0, 180);
    g2d.drawArc(cloudX + 110, cloudY, 50, 50, 0, 180);
    g2d.drawArc(cloudX + 145, cloudY + 5, 45, 45, 0, 180);
    g2d.drawArc(cloudX + 175, cloudY + 15, 40, 50, 0, 180);
    g2d.drawLine(cloudX + 80, cloudY + 40, cloudX + 215, cloudY + 40);
    g2d.drawArc(cloudX + 95, cloudY + 25, 35, 30, 0, -180);
    g2d.drawArc(cloudX + 140, cloudY + 25, 35, 30, 0, -180);
    }
    
    
}
