package Drawings;

import java.awt.*;
import javax.swing.JPanel;

public class DrawAlphabet extends JPanel {
    DrawRedLines drawRedLines;

    private int width;
    private int height;
    private int startX = 60;  
    private int startY;  
    private int cellWidth = 40;        
    private int cellHeight = 30;   
    private int size = 16;


    // Двухмерный массив русских букв (2 ряда)
    private final char[][] russianAlphabet = {
        {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П'},
        {'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '\0'}
    };

    public DrawAlphabet(int width, int height) {
        this.width = width;
        this.height = height;
        startY = height - 100;  

        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setFont(new Font("Arial", Font.BOLD, size));
        g2d.setColor(Color.BLACK);
             
        for (int row = 0; row < russianAlphabet.length; row++) {
            for (int col = 0; col < russianAlphabet[row].length; col++) {
                char letter = russianAlphabet[row][col];
                if (letter != '\0') {
                    int x = startX + col * cellWidth;
                    int y = startY + row * cellHeight;
                    g2d.drawString(String.valueOf(letter), x, y);
                }
            }
        }
    }

    public Point findLetter(char letter){
         for (int row = 0; row < russianAlphabet.length; row++) {
            for (int col = 0; col < russianAlphabet[row].length; col++) {
                if(russianAlphabet[row][col] == letter){
                    return new Point(row, col);
                }
            }
        }
        return new Point(-1, -1);
    }

}
