package Drawings;

import java.awt.*;
import javax.swing.JPanel;;

public class DrawVictory extends JPanel {
    
    /** Ширина окна*/
    private final int width; 

    /** Высота окна*/
    private final int height;


    public DrawVictory(int width, int height){

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

        int centerX = (width - fm.stringWidth("ПОБЕДА")) / 2;  
        int Y = fm.getHeight(); 

        g2d.drawString("ПОБЕДА", centerX, Y);



        
    }
}
