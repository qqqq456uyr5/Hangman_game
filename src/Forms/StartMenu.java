package Forms;

import Drawings.StartLogo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;  // ← Правильный импорт!
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StartMenu {

    /** Ширина окна в пикселях */
    private final int width = 800; 

    /** Высота окна в пикселях */
    private final int height = 500;

    public StartMenu(){
        //текст лого
        JFrame startmenu = new JFrame("Handman");
        startmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startmenu.setSize(width, height);
        startmenu.setLocationRelativeTo(null);

        
        //формочка отрисовки
        StartLogo logoPanel = new StartLogo(width, height);
        startmenu.add(logoPanel); 

        // Кнопка начала игры
        JButton playButton = new JButton("ИГРАТЬ");
        playButton.setBorder(null);
        playButton.setFont(new Font("Arial", Font.BOLD, 26));
        playButton.setForeground(Color.BLACK);
        playButton.setBackground(Color.gray);
        playButton.setFocusPainted(false);
        playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playButton.setOpaque(false);
        playButton.setPreferredSize(new Dimension(200, 60));
        

        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playButton.setOpaque(true);
                playButton.setBackground(Color.BLACK);
                playButton.setForeground(Color.WHITE);  
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playButton.setOpaque(false);
                playButton.setForeground(Color.BLACK);  
            }
        });

        playButton.addActionListener(e ->{
            Game game = new Game(width, height);
            startmenu.dispose();
        });

        //кнопка выхода
        JButton exitButton = new JButton("ВЫЙТИ");
        exitButton.setBorder(null);
        exitButton.setFont(new Font("Arial", Font.BOLD, 26));
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.gray);
        exitButton.setFocusPainted(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setOpaque(false);
        exitButton.setPreferredSize(new Dimension(200, 60));
        

        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButton.setOpaque(true);
                exitButton.setBackground(Color.BLACK);
                exitButton.setForeground(Color.WHITE);  
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton.setOpaque(false);
                exitButton.setForeground(Color.BLACK);  
            }
        });
        exitButton.addActionListener(e ->{
            startmenu.dispose();
        });



        
        


        startmenu.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

                logoPanel.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {}

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
        });


        // Панель для кнопок внизу
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        bottomPanel.add(playButton);
        bottomPanel.add(exitButton);

        startmenu.add(bottomPanel, BorderLayout.SOUTH);



        
        startmenu.setVisible(true);
    }
}
