package Forms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Clue {
    private int width;
    private int height;

    public Clue(int width, int height){
        this.width = width;
        this.height = height;

        JFrame clueFrame = new JFrame("Подсказка");
        clueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clueFrame.setSize(width / 2, height / 2);
        clueFrame.setLocationRelativeTo(null);
        clueFrame.setLayout(null);
        
        // Надпись о превышении количества подсказок
        JLabel messageLabel = new JLabel("Превышено количество подсказок!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        messageLabel.setForeground(Color.RED);
        messageLabel.setBounds(-3, 20, width / 2, height / 4);
        
        JLabel subMessageLabel = new JLabel("Вы использовали все доступные подсказки", SwingConstants.CENTER);
        subMessageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subMessageLabel.setForeground(Color.DARK_GRAY);
        subMessageLabel.setBounds(30, 90, width / 2 - 100, height / 4);
        
        clueFrame.add(messageLabel);
        clueFrame.add(subMessageLabel);
        
        new Thread(() -> {
            try {
                Thread.sleep(1500);
                clueFrame.dispose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        clueFrame.setVisible(true);
    }
}
