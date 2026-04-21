package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class DrawCategory extends JPanel {

    /** Ширина окна в пикселях */
    private final int width; 

    /** Высота окна в пикселях */
    private final int height;

    /** Категория */
    private String category;

    public DrawCategory(int width, int height, String category) {
        this.width = width;
        this.height = height;
        this.category = category;

        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setFont(new Font("Arial", Font.BOLD, 36));
        g2d.setColor(Color.BLACK);
        
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(category);
        
        int x = (width - textWidth) / 2;
        int y = 50;
        
        // Рисуем текст
        g2d.drawString(category, x, y);
    }
}