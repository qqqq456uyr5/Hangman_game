package Forms;

import javax.swing.JFrame;

public class Settings {
    /** Ширина окна в пикселях */
    private final int width; 

    /** Высота окна в пикселях */
    private final int height;

    public Settings(int width, int height){
        this.width = width;

        this.height = height;

        JFrame settings = new JFrame("Handman");
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setSize(width, height);
        settings.setLocationRelativeTo(null);

        settings.setVisible(true);
    }
}
