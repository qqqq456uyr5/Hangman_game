package Forms;

import Drawings.BackgroundSettingsMenu;
import java.awt.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Settings {

    JFrame game;
    private final int width; 
    private final int height;

    public Settings(int width, int height, JFrame game){
        this.width = width;
        this.height = height;
        this.game = game;

        JFrame settings = new JFrame("Настройки");
        settings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settings.setSize(width, height);
        settings.setLocationRelativeTo(null);
        
        //НАЛОЖЕНИЕ
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(width, height));
        layeredPane.setLayout(null);

        //ФОН
        BackgroundSettingsMenu background = new BackgroundSettingsMenu();
        background.setBounds(0, 0, width, height);
        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);

        //СОЗДАНИЕ КНОПОК
        
        // Кнопка "ПРОДОЛЖИТЬ"
        JButton continueButton = new JButton("ПРОДОЛЖИТЬ");
        continueButton.setBorder(null);
        continueButton.setFont(new Font("Arial", Font.BOLD, 26));
        continueButton.setForeground(Color.BLACK);
        continueButton.setBackground(Color.GRAY);
        continueButton.setFocusPainted(false);
        continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        continueButton.setOpaque(false);
        continueButton.setContentAreaFilled(false);
        continueButton.setPreferredSize(new Dimension(250, 60));
        continueButton.setMaximumSize(new Dimension(250, 60));

        continueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continueButton.setOpaque(true);
                continueButton.setBackground(Color.BLACK);
                continueButton.setForeground(Color.WHITE);  
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continueButton.setOpaque(false);
                continueButton.setForeground(Color.BLACK);
                continueButton.setBackground(null);
            }
        });
        continueButton.addActionListener(e -> {
            settings.dispose();
        });

        // Кнопка "ВЫЙТИ В МЕНЮ"
        JButton menuButton = new JButton("ВЫЙТИ В МЕНЮ");
        menuButton.setBorder(null);
        menuButton.setFont(new Font("Arial", Font.BOLD, 26));
        menuButton.setForeground(Color.BLACK);
        menuButton.setFocusPainted(false);
        menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setPreferredSize(new Dimension(250, 60));
        menuButton.setMaximumSize(new Dimension(250, 60));

        menuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuButton.setOpaque(true);
                menuButton.setBackground(Color.BLACK);
                menuButton.setForeground(Color.WHITE);  
                menuButton.repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuButton.setOpaque(false);
                menuButton.setForeground(Color.BLACK);
                menuButton.setBackground(null);
                menuButton.repaint();
            }
        });
        menuButton.addActionListener(e -> {
            settings.dispose();
            game.dispose();
            new StartMenu();
        });

        // Кнопка "ВЫХОД"
        JButton exitButton = new JButton("ВЫХОД");
        exitButton.setBorder(null);
        exitButton.setFont(new Font("Arial", Font.BOLD, 26));
        exitButton.setForeground(Color.BLACK);
        exitButton.setFocusPainted(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setPreferredSize(new Dimension(250, 60));
        exitButton.setMaximumSize(new Dimension(250, 60));

        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButton.setOpaque(true);
                exitButton.setBackground(Color.BLACK);
                exitButton.setForeground(Color.WHITE);  
                exitButton.repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton.setOpaque(false);
                exitButton.setForeground(Color.BLACK);
                exitButton.setBackground(null);
                exitButton.repaint();
            }
        });
        exitButton.addActionListener(e -> {
            game.dispose();
            settings.dispose();           
        });

        //ПАНЕЛЬ С КНОПКАМИ
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);
        
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(continueButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        buttonPanel.add(menuButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        buttonPanel.add(exitButton);
        buttonPanel.add(Box.createVerticalGlue());
        
        int panelWidth = 300;
        int panelHeight = 300;
        buttonPanel.setBounds((width - panelWidth) / 2, (height - panelHeight) / 2, panelWidth, panelHeight);
        
    
        layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);
        
        settings.add(layeredPane);
        settings.setVisible(true);
    }
}