package Forms;

import javax.swing.JFrame;

public class FinishLose {
     private  int width;
    private  int height;

    public FinishLose(int width, int height){
        this.width = width;
        this.height = height;

        JFrame game = new JFrame("Handman");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(width, height);
        game.setLocationRelativeTo(null);

        game.setVisible(true);
    }
}
