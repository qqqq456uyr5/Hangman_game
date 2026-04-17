package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class DrawRedLines extends JPanel {

    private int row; 


    private int col;



    private int startX = 60;  
    private int startY = 385;  
    private int cellWidth = 40;        
    private int cellHeight = 30;   


    public DrawRedLines(int row, int col) {
        this.row = row;
        this.col = col;

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        int x = startX + col * cellWidth;
        int y = startY + row * cellHeight;

        g2d.drawLine(x, y, x + 16, y + 16);
        g2d.drawLine(x, y + 16, x + 16, y);
    }
}