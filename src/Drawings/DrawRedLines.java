package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class DrawRedLines extends JPanel {

    private int row; 

    private int col;

    private int width;
    private int height;


    private int startX;  
    private int startY;  
    private int cellWidth;        
    private int cellHeight;   
    private int size;   


    public DrawRedLines(int row, int col, int width, int height, int startX, int cellWidth,  int cellHeight, int size) {
        this.width = width;
        this.height = height;
        this.row = row;
        this.col = col;
        this.cellHeight = cellHeight;
        this.cellWidth = cellWidth;
        this.startX = startX;
        this.size = size;
        startY = height - 100;  

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        int x = startX + col * cellWidth;
        int y = startY + row * cellHeight;

        g2d.drawLine(x - 5, y + 5, x + size, y - size);
        g2d.drawLine(x - 5, y - size, x + size, y + 5);
    }
}