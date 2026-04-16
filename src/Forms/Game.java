package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Drawings.BackgroundGameForm;
import Drawings.DrawClouds;
import Drawings.StartLogo;

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


        JButton settingsButton = new JButton();

        URL imageUrl = getClass().getResource("/Resources/Settings.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
        settingsButton.setIcon(new ImageIcon(scaledImage));

        settingsButton.setBorder(null);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFocusPainted(false);
        settingsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            settingsButton.setBackground(new Color(0, 0, 0, 80));
            settingsButton.setOpaque(true);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            settingsButton.setOpaque(false);
            settingsButton.setBackground(null);  // Сбрасываем фон
        }
        });

        settingsButton.addActionListener(e -> {
            settingsButton.setBackground(null);
            Settings settings = new Settings(width / 2, height / 2, game);
        });
            
        // Панель для кнопки
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(settingsButton, BorderLayout.EAST);

        game.add(topPanel, BorderLayout.NORTH);

        BackgroundGameForm backgroundPanel = new BackgroundGameForm();
        game.add(backgroundPanel); 


        game.setVisible(true);
    }
    
}
