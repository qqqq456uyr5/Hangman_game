package Drawings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javax.swing.JButton;

public class DrawBulbForButton extends JButton {

        
    private int width;
    private int height;
    
    
    public DrawBulbForButton(int width, int height) {
        this.width = width;
        this.height = height;
        setBorder(null);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setBounds(width - 120, 8, 50, 50);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        draw(g2d, getModel().isRollover());
        g2d.dispose();
    }
    
    private void draw(Graphics2D g2d, boolean isHovering) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        
        // Цвета: чёрный, при наведении - серый
        Color bulbColor = isHovering ? new Color(100, 100, 100) : new Color(30, 30, 30);
        Color filamentColor = isHovering ? new Color(150, 150, 150) : new Color(80, 80, 80);
        Color baseColor = isHovering ? new Color(90, 90, 90) : new Color(40, 40, 40);
        
        // Тело лампочки (колба)
        GeneralPath bulb = new GeneralPath();
        
        // Верхняя круглая часть
        bulb.moveTo(centerX - 16, centerY - 8);
        bulb.quadTo(centerX, centerY - 26, centerX + 16, centerY - 8);
        
        // Сужающаяся часть к цоколю
        bulb.lineTo(centerX + 11, centerY + 12);
        bulb.lineTo(centerX + 7, centerY + 17);
        bulb.lineTo(centerX - 7, centerY + 17);
        bulb.lineTo(centerX - 11, centerY + 12);
        bulb.closePath();
        
        // Заливка колбы
        g2d.setColor(bulbColor);
        g2d.fill(bulb);
        
        // Тонкий контур
        g2d.setColor(isHovering ? new Color(130, 130, 130) : new Color(50, 50, 50));
        g2d.draw(bulb);
        
        // Нить накаливания (простая линия)
        g2d.setColor(filamentColor);
        g2d.setStroke(new java.awt.BasicStroke(1.5f));
        g2d.drawLine(centerX, centerY - 4, centerX, centerY + 6);
        
        // Цоколь
        g2d.setColor(baseColor);
        g2d.fillRect(centerX - 9, centerY + 15, 18, 5);
        
        // Контакт на цоколе
        g2d.setColor(isHovering ? new Color(110, 110, 110) : new Color(35, 35, 35));
        g2d.fillRect(centerX - 4, centerY + 20, 8, 3);
        
        // Маленький блик (едва заметный)
        g2d.setColor(new Color(150, 150, 150, 80));
        g2d.fillOval(centerX - 8, centerY - 16, 5, 8);
    }
}
