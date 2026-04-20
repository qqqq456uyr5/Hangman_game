package Forms;

import Drawings.BackgroundGameForm;
import Drawings.DrawAlphabet;
import Drawings.DrawBulbForButton;
import Drawings.DrawCategory;
import Drawings.DrawLetters;
import Drawings.DrawLinesForLetters;
import Drawings.DrawLogoSettings;
import Drawings.DrawRedLines;
import GamePlay.BoolToFinish;
import GamePlay.FindLettersInWord;
import GamePlay.ReadFromDictionary;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Game {

    ReadFromDictionary readFromDictionary = new ReadFromDictionary();
    FindLettersInWord findLettersInWord = new FindLettersInWord(readFromDictionary.getWorldLetter());
    BoolToFinish boolToFinish = new BoolToFinish(readFromDictionary.getWorldLetter());
    

    private final int width;
    private final int height;
    private int startX = 60;  
    private int cellWidth = 40;        
    private int cellHeight = 30;  
    private int size = 16;
    private int attempt = 0;
    private int attemptСlue = 0;

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
        layeredPane.add(backgroundPanel, Integer.valueOf(0));

        //Чёрточки
        DrawLinesForLetters drawLinesForLetters = new DrawLinesForLetters(width, height, readFromDictionary.getWorldLetter());
        drawLinesForLetters.setBounds(0, 0, width, height);
        drawLinesForLetters.setOpaque(false);
        layeredPane.add(drawLinesForLetters, Integer.valueOf(1));

        //Название категории
        DrawCategory drawCategory = new DrawCategory(width, height, readFromDictionary.getCategory());
        drawCategory.setBounds(0, 0, width, height);
        drawCategory.setOpaque(false);
        layeredPane.add(drawCategory, Integer.valueOf(2));

        //Алфавит
        DrawAlphabet drawAlphabet = new DrawAlphabet(width, height, startX, cellWidth, cellHeight, size);
        drawAlphabet.setBounds(0, 0, width, height);
        drawAlphabet.setOpaque(false);
        layeredPane.add(drawAlphabet, Integer.valueOf(3));

        // Кнопка настроек
        DrawLogoSettings settingsButton = new DrawLogoSettings(width, height);
        settingsButton.addActionListener(e -> {
            Settings settings = new Settings(width / 2, height / 2, game);
        });
        layeredPane.add(settingsButton, Integer.valueOf(4));

        //кнопка лампочка
        DrawBulbForButton bulbButton = new DrawBulbForButton(width, height);
        bulbButton.addActionListener(e -> {
            if(attemptСlue >= 2){
                Clue clue = new Clue(width, height);
                game.requestFocus();
                game.setFocusable(true);
                return;
            }
            char[] wordLetters = readFromDictionary.getWorldLetter();
            List<Character> notOpenedLetters = new ArrayList<>();
    
    
            for (int i = 0; i < wordLetters.length; i++) {
                char letter = wordLetters[i];
                if (!boolToFinish.boolArray[i]) {
                    if (!notOpenedLetters.contains(letter)) {
                        notOpenedLetters.add(letter);
                    }
                }
            }
    
    // Если есть неоткрытые буквы - открываем случайную
        if (!notOpenedLetters.isEmpty()) {
            Random random = new Random();
            char randomLetter = notOpenedLetters.get(random.nextInt(notOpenedLetters.size()));
        
        
            List<Integer> positions = findLettersInWord.findLetter(randomLetter);
            Point pos = drawAlphabet.findLetter(randomLetter);
            DrawRedLines drawRedLines = new DrawRedLines(pos.x, pos.y, width, height, startX, cellWidth, cellHeight, size);
            drawRedLines.setBounds(0, 0, width, height);
            drawRedLines.setOpaque(false);
            layeredPane.add(drawRedLines, Integer.valueOf(4));
            layeredPane.repaint();
        

            DrawLetters drawLetters = new DrawLetters(width, height, wordLetters, randomLetter, positions);
            drawLetters.setBounds(0, 0, width, height);
            drawLetters.setOpaque(false);
            layeredPane.add(drawLetters, Integer.valueOf(5));

            boolToFinish.addToBoolIsFinish(positions);

            if (boolToFinish.isFinish()) {
                FinishVictory finishVictory = new FinishVictory(width, height);
                game.dispose();
            }
        
            layeredPane.repaint();
            }
            attemptСlue++;
            game.requestFocus();
            game.setFocusable(true);
        });
        layeredPane.add(bulbButton, Integer.valueOf(4));


        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(attempt >= 5){
                    FinishLose finishLose = new FinishLose(width, height);
                    game.dispose();
                }
                char keyChar = e.getKeyChar();
                char russianLetter = Character.toUpperCase(keyChar);
            
                if ((russianLetter >= 'А' && russianLetter <= 'Я') || russianLetter == 'Ё') {
                    Point pos = drawAlphabet.findLetter(russianLetter);
                    if (pos != null) {

                        List<Integer> positions = findLettersInWord.findLetter(russianLetter);

                        DrawLetters drawLetters = new DrawLetters(width, height, readFromDictionary.getWorldLetter(), russianLetter, positions);
                        if(positions.isEmpty()) {
                            attempt++;
                        }
                        
                        boolToFinish.addToBoolIsFinish(positions);
                        
                        DrawRedLines drawRedLines = new DrawRedLines(pos.x, pos.y, width, height, startX, cellWidth, cellHeight, size);
                       
                        drawLetters.setBounds(0, 0, width, height);
                        drawLetters.setOpaque(false);
                        layeredPane.add(drawLetters, Integer.valueOf(5));

                        drawRedLines.setBounds(0, 0, width, height);
                        drawRedLines.setOpaque(false);
                        layeredPane.add(drawRedLines, Integer.valueOf(4));
                        layeredPane.repaint();

                        if(boolToFinish.isFinish()){
                            FinishVictory finishVictory = new FinishVictory(width, height);
                            game.dispose();
                        }
                    }
                }
            }
        });

        game.setFocusable(true);
        game.requestFocus();
        game.setVisible(true);
    }
}