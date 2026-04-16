package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class StartLogo extends JPanel {

    DrawClouds draw = new DrawClouds();
    
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

        

        draw.drawClouds(50, 10, g2d);
        draw.drawClouds(500, 100, g2d);
        draw.drawClouds(-50, 80, g2d);
        drawGallows(-20, 250, g2d);
    }

  
    public void drawGallows(int x, int y, Graphics2D g2d){
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.BLACK);

        // Основание
        g2d.drawLine(x + 50, y + 150, x + 150, y + 150);

        // Вертикальная стойка
        g2d.drawLine(x + 100, y + 150, x + 100, y);

        // Верхняя перекладина
        g2d.drawLine(x + 100, y, x + 180, y);

        // Наклонная подпорка
        g2d.drawLine(x + 70, y + 150, x + 100, y + 100);

        // Веревка
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x + 178, y, x + 178, y + 25);
        g2d.drawOval(x + 168, y + 25, 20, 20);
    }
}
