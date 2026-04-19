package Drawings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import javax.swing.JPanel;

public class DrawLetters extends JPanel {

    private int quantity;
    private final int width; 
    private final int height;
    private char[] letters;
    private List<Integer> positions;
    private char letter;

    public DrawLetters(int width, int height, char[] letters, char letter, List<Integer> positions){
        this.quantity = letters.length;
        this.width = width;
        this.height = height;
        this.letters = letters;
        this.positions = positions;
        this.letter = letter;
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.setColor(Color.BLACK);
        
        int lineLength = 40;
        int spacing = 20;
        
        int totalWidth = quantity * lineLength + (quantity - 1) * spacing;
        int startX = (width - totalWidth) / 2;
        int lineY = height / 2 + 100;
        int textY = lineY - 15;
        
        for (int pos : positions) {  
            if (pos >= 0 && pos < quantity) {  
                int x = startX + pos * (lineLength + spacing);
  
                int textX = x + lineLength/2 - 10;
                g2d.drawString(String.valueOf(letter), textX, textY);
            }
        }
    }
}

