package Drawings;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class DrawLogoSettings extends JButton {
    
    private int width;
    private int height;
    
    public DrawLogoSettings(int width, int height) {
        this.width = width;
        this.height = height;
        
        setFont(new Font("Segoe UI", Font.PLAIN, 30));
        setBorder(null);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBounds(width - 70, 10, 50, 50);
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                repaint();
            }
        });
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
        int outerRadius = Math.min(getWidth(), getHeight()) / 3;
        int innerRadius = outerRadius / 2;
        
        // Цвета: светлый при наведении, иначе тёмный
        Color gearColor = isHovering ? new Color(100, 100, 120) : Color.BLACK;
        Color centerColor = isHovering ? new Color(130, 130, 150) : Color.BLACK;
        
        // Рисуем зубцы шестерёнки (8 зубцов)
        int teethCount = 8;
        double angleStep = 2 * Math.PI / teethCount;
        
        for (int i = 0; i < teethCount; i++) {
            double angle = i * angleStep;
            int toothX1 = centerX + (int)(outerRadius * Math.cos(angle));
            int toothY1 = centerY + (int)(outerRadius * Math.sin(angle));
            int toothX2 = centerX + (int)((outerRadius + 6) * Math.cos(angle));
            int toothY2 = centerY + (int)((outerRadius + 6) * Math.sin(angle));
            int toothX3 = centerX + (int)((outerRadius + 6) * Math.cos(angle + angleStep / 3));
            int toothY3 = centerY + (int)((outerRadius + 6) * Math.sin(angle + angleStep / 3));
            int toothX4 = centerX + (int)(outerRadius * Math.cos(angle + angleStep / 3));
            int toothY4 = centerY + (int)(outerRadius * Math.sin(angle + angleStep / 3));
            
            int[] xPoints = {toothX1, toothX2, toothX3, toothX4};
            int[] yPoints = {toothY1, toothY2, toothY3, toothY4};
            g2d.setColor(gearColor);
            g2d.fillPolygon(xPoints, yPoints, 4);
        }
        
        //внешнее кольцо
        g2d.setColor(gearColor);
        g2d.fillOval(centerX - outerRadius, centerY - outerRadius, outerRadius * 2, outerRadius * 2);
        
        //внутреннее отверстие
        g2d.setColor(getBackground());
        g2d.fillOval(centerX - innerRadius, centerY - innerRadius, innerRadius * 2, innerRadius * 2);

        
    }
}