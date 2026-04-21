package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class StartLogo extends JPanel {

    DrawClouds drawCloud = new DrawClouds();

    DrawGallows drawGallow = new DrawGallows();
    
    /** Ширина окна*/
    private final int width; 

    /** Высота окна*/
    private final int height;


    public StartLogo(int width, int height){

        this.width = width;

        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //надпись
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        FontMetrics fm = g2d.getFontMetrics();

        int centerX = (width - fm.stringWidth("HANDMAN")) / 2;  
        int Y = fm.getHeight(); 

        g2d.drawString("HANDMAN", centerX, Y);

        

        drawCloud.drawClouds(50, 10, g2d);
        drawCloud.drawClouds(500, 100, g2d);
        drawCloud.drawClouds(-50, 80, g2d);
        drawGallow.drawGallows(-20, 250, g2d);


        int sunX = 300;  
        int sunY = 120;          
        int sunSize = 60;       

        g2d.setColor(Color.BLACK);
        g2d.fillOval(sunX, sunY, sunSize, sunSize);


        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        for(int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            int x1 = (int)(sunX + sunSize/2 + Math.cos(angle) * (sunSize/2 + 10));
            int y1 = (int)(sunY + sunSize/2 + Math.sin(angle) * (sunSize/2 + 10));
            int x2 = (int)(sunX + sunSize/2 + Math.cos(angle) * (sunSize/2 + 25));
            int y2 = (int)(sunY + sunSize/2 + Math.sin(angle) * (sunSize/2 + 25));
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

  
}
    
