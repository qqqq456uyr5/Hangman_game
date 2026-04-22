package Forms;

import Drawings.DrawInfoButton;
import Drawings.StartLogo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class StartMenu {

    private final int width = 800;
    private final int height = 500;

    public StartMenu() {
        JFrame startmenu = new JFrame("Handman");
        startmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startmenu.setSize(width, height);
        startmenu.setLocationRelativeTo(null);

        // Создаём LayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(width, height));
        layeredPane.setLayout(null);
        startmenu.setContentPane(layeredPane);

        // СЛОЙ 0: Фоновый логотип
        StartLogo logoPanel = new StartLogo(width, height);
        logoPanel.setBounds(0, 0, width, height);
        logoPanel.setOpaque(true);
        layeredPane.add(logoPanel, Integer.valueOf(0));

        // СЛОЙ 1: Кнопка информации
        DrawInfoButton infoButton = new DrawInfoButton(width, height);
        infoButton.setBounds(width - 70, 7, 50, 50);
        infoButton.addActionListener(e -> {
            // Действие для кнопки информации
            Info info = new Info(width, height);
        });
        layeredPane.add(infoButton, Integer.valueOf(1));

        // СЛОЙ 2: Панель с кнопками внизу
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        bottomPanel.setBounds(0, height - 100, width, 80);
        
        // Кнопка "ИГРАТЬ"
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

        playButton.addActionListener(e -> {
            Game game = new Game(width, height);
            startmenu.dispose();
        });

        // Кнопка "ВЫЙТИ"
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
        
        exitButton.addActionListener(e -> {
            startmenu.dispose();
        });

        bottomPanel.add(playButton);
        bottomPanel.add(exitButton);
        layeredPane.add(bottomPanel, Integer.valueOf(2));

        startmenu.setVisible(true);
    }
}