package Drawings;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawGallowsForGame extends JPanel {

    private int attempt;

    DrawGallows drawGallows = new DrawGallows();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGallows.drawGallowsPiecemeal(260, 80, g2d, attempt);
        
        

    }
    public void newAttempt(int attempt){
        this.attempt = attempt;
    }


}
