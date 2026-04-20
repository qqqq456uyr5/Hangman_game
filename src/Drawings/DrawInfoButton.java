package Drawings;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class DrawInfoButton extends JButton {
    
    private int width;
    private int height;
    
    public DrawInfoButton(int width, int height) {
        this.width = width;
        this.height = height;
        
        setFont(new Font("Segoe UI", Font.PLAIN, 30));
        setBorder(null);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        
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
        int radius = Math.min(getWidth(), getHeight()) / 2 - 8;
        
        Color circleColor = isHovering ? new Color(100, 100, 120) : Color.BLACK;
        Color letterColor = isHovering ? new Color(100, 100, 120) : Color.BLACK;
        
        // Рисуем незалитый круг (только контур) - меньшего размера
        g2d.setColor(circleColor);
        g2d.setStroke(new java.awt.BasicStroke(2f));
        g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        
        // Рисуем букву "i" внутри круга (размер остался 24)
        g2d.setColor(letterColor);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 24));  // Шрифт остался 24
        FontMetrics fm = g2d.getFontMetrics();
        String letter = "i";
        int letterWidth = fm.stringWidth(letter);
        int letterHeight = fm.getAscent();
        g2d.drawString(letter, centerX - letterWidth / 2, centerY + letterHeight / 2 - 3);
    }
}
