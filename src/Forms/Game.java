package Forms;

import Drawings.BackgroundGameForm;
import Drawings.DrawAlphabet;
import Drawings.DrawCategory;
import Drawings.DrawLinesForLetters;
import Drawings.DrawRedLines;
import GamePlay.FindLettersInWord;
import GamePlay.ReadFromDictionary;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Game {

    ReadFromDictionary readFromDictionary = new ReadFromDictionary();
    FindLettersInWord findLettersInWord = new FindLettersInWord(readFromDictionary.getWorldLetter());

    private final int width;
    private final int height;
    private int startX = 60;  
    private int cellWidth = 40;        
    private int cellHeight = 30;  
    private int size = 16;

    public Game(int width, int height){
        this.width = width;
        this.height = height;

        JFrame game = new JFrame("Handman");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(width, height);
        game.setLocationRelativeTo(null);

        // Создаём LayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(width, height));
        game.setContentPane(layeredPane);

        //Фон
        BackgroundGameForm backgroundPanel = new BackgroundGameForm();
        backgroundPanel.setBounds(0, 0, width, height);
        backgroundPanel.setOpaque(true);
        layeredPane.add(backgroundPanel, Integer.valueOf(0));  // слой 0

        //Чёрточки)
        DrawLinesForLetters drawLinesForLetters = new DrawLinesForLetters(width, height, readFromDictionary.getWorldLetter());
        drawLinesForLetters.setBounds(0, 0, width, height);
        drawLinesForLetters.setOpaque(false);
        layeredPane.add(drawLinesForLetters, Integer.valueOf(1));  // слой 1

        //Название категории
        DrawCategory drawCategory = new DrawCategory(width, height, readFromDictionary.getCategory());
        drawCategory.setBounds(0, 0, width, height);
        drawCategory.setOpaque(false);
        layeredPane.add(drawCategory, Integer.valueOf(2));  // слой 2

        //Алфавит
        DrawAlphabet drawAlphabet = new DrawAlphabet(width, height, startX, cellWidth, cellHeight, size);
        drawAlphabet.setBounds(0, 0, width, height);
        drawAlphabet.setOpaque(false);
        layeredPane.add(drawAlphabet, Integer.valueOf(3));  // слой 3

        // Кнопка настроек
        JButton settingsButton = new JButton();
        URL imageUrl = getClass().getResource("/Resources/Settings.png");
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
            settingsButton.setIcon(new ImageIcon(scaledImage));
        }

        settingsButton.setBorder(null);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFocusPainted(false);
        settingsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settingsButton.setBounds(width - 70, 10, 50, 50);

        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButton.setBackground(new Color(0, 0, 0, 80));
                settingsButton.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButton.setOpaque(false);
                settingsButton.setBackground(null);
            }
        });

        settingsButton.addActionListener(e -> {
            settingsButton.setBackground(null);
            Settings settings = new Settings(width / 2, height / 2, game);
        });

        layeredPane.add(settingsButton, Integer.valueOf(4));  // слой 4



        game.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            char keyChar = e.getKeyChar();
            char russianLetter = Character.toUpperCase(keyChar);
        
            if ((russianLetter >= 'А' && russianLetter <= 'Я') || russianLetter == 'Ё') {
                Point pos = drawAlphabet.findLetter(russianLetter);
                if (pos != null) {

                    List<Integer> positions = findLettersInWord.findLetter(russianLetter);
                    for(int index : positions){
                        
                    }
                    DrawRedLines drawRedLines = new DrawRedLines(pos.x, pos.y, width, height, startX, cellWidth, cellHeight, size);
                    drawRedLines.setBounds(0, 0, width, height);
                    drawRedLines.setOpaque(false);
                    layeredPane.add(drawRedLines, Integer.valueOf(4));
                    layeredPane.repaint();
                }
            }
        }
        });

        game.setFocusable(true);
        game.requestFocus();

        game.setVisible(true);
    }
}