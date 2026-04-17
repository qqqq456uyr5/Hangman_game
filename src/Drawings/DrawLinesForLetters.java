package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class DrawLinesForLetters extends JPanel {

    /** Ширина окна в пикселях */
    private int quantity;

    /** Ширина окна в пикселях */
    private final int width; 

    /** Высота окна в пикселях */
    private final int height;



    public DrawLinesForLetters(int width, int height, char[] letters){
        this.quantity = letters.length;

        this.width = width;
        
        this.height = height;

        setOpaque(false); 
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2)); 
        
        int lineLength = 40;
        int spacing = 20;
        
        int totalWidth = quantity * lineLength + (quantity - 1) * spacing;
        
        int startX = (width - totalWidth) / 2;
        
        int lineY = height / 2 + 100;
        
        for (int i = 0; i < quantity; i++) {
            int x = startX + i * (lineLength + spacing);
            g2d.drawLine(x, lineY, x + lineLength, lineY);
        }
    }

}


