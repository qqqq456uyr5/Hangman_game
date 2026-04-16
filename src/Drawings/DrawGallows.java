package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class DrawGallows extends JPanel {

    public void drawGallows(int x, int y, Graphics2D g2d){
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.BLACK);

        g2d.drawLine(x + 50, y + 150, x + 150, y + 150);

        g2d.drawLine(x + 100, y + 150, x + 100, y);

        g2d.drawLine(x + 100, y, x + 180, y);

        g2d.drawLine(x + 70, y + 150, x + 100, y + 100);

        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x + 178, y, x + 178, y + 25);
        g2d.drawOval(x + 168, y + 25, 20, 20);
    }

}

    
    

