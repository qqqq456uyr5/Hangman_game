package Forms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Info {
    private int width;
    private int height;

    public Info(int width, int height){
        this.width = width;
        this.height = height;

        JFrame infoFrame = new JFrame("Информация");
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setSize(width / 2 + 200, height / 2);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setLayout(null);
        
        String text = "ПРАВИЛА ИГРЫ \"ВИСЕЛИЦА\"\n\n" +
                        "Как играть:\n" +
                        "- Компьютер загадывает слово из определённой категории\n" +
                        "- Ваша задача - отгадать слово по буквам\n" +
                        "- Нажимайте на буквы алфавита или используйте клавиатуру (русскую раскладку)\n" +
                        "- Если буква есть в слове - она откроется на своих позициях\n" +
                        "- Если буквы нет - начинается рисование виселицы\n\n" +
                        "Количество ошибок:\n" +
                        "- Всего допускается 6 ошибок\n" +
                        "- Каждая ошибка добавляет часть виселицы\n\n" +
                        "Фишки и возможности:\n" +
                        "- Подсказка (лампочка) - 2 подсказки за игру, открывает случайную букву\n" +
                        "- Категория слова - отображается вверху экрана\n" +
                        "- Настройки - шестерёнка для перезапуска игры или выхода в меню\n\n" +
                        "Особенности:\n" +
                        "- Игра использует русский алфавит (включая букву Ё)\n" +
                        "- Уже использованные буквы зачёркиваются красным\n" +
                        "- При победе - салют\n" +
                        "- При поражении - анимация дождя\n\n" +
                        "Удачи в отгадывании! 🎮";
        
        JLabel messageLabel = new JLabel("<html>" + text.replaceAll("\n", "<br>") + "</html>", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setBounds(10, 10, width / 2 - 20, height / 2 - 20);
        
        JScrollPane scrollPane = new JScrollPane(messageLabel);
        scrollPane.setBounds(10, 10, width / 2 - 20 + 200, height / 2 - 30);
        scrollPane.setBorder(null);
        
        infoFrame.add(scrollPane);
        infoFrame.setVisible(true);
    }
}