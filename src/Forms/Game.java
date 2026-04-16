package Forms;

import javax.swing.JFrame;

public class Game {

    /** Ширина окна в пикселях */
    private final int width; 

    /** Высота окна в пикселях */
    private final int height;

    public Game(int width, int height){
        this.width = width;

        this.height = height;

        JFrame game = new JFrame("Handman");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(width, height);
        game.setLocationRelativeTo(null);


        game.setVisible(true);
    }
    
}
