package Drawings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawLose extends JPanel {
    
    /** Ширина окна*/
    private final int width; 

    /** Высота окна*/
    private final int height;
    
    /** Список капель */
    private ArrayList<Drop> drops;
    
    /** Генератор случайных чисел */
    private Random random;
    
    /** Таймер для анимации */
    private Timer timer;

    public DrawLose(int width, int height){
        this.width = width;
        this.height = height;
        this.drops = new ArrayList<>();
        this.random = new Random();
        
        // Запускаем таймер для анимации капель
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Создаём новые капли с вероятностью 25%
                if (random.nextInt(100) < 25) {
                    createDrop();
                }
                
                // Обновляем все капли
                updateDrops();
                
                // Перерисовываем панель
                repaint();
            }
        });
        timer.start();
    }
    
    /** Создаёт новую каплю */
    private void createDrop() {
        int x = 30 + random.nextInt(width - 60);
        int y = -10;
        int speed = 2 + random.nextInt(6);
        drops.add(new Drop(x, y, speed));
    }
    
    /** Обновляет все капли и удаляет упавшие */
    private void updateDrops() {
        Iterator<Drop> iterator = drops.iterator();
        while (iterator.hasNext()) {
            Drop d = iterator.next();
            d.update();
            if (d.isDead(height)) {
                iterator.remove();
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Белый фон
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        
        // Включаем сглаживание для красивых капель
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Рисуем все капли
        for (Drop d : drops) {
            d.draw(g2d);
        }
        
        // Рисуем надпись "ПОРАЖЕНИЕ" как в DrawVictory
        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        FontMetrics fm = g2d.getFontMetrics();
        String text = "ПОРАЖЕНИЕ";
        int centerX = (width - fm.stringWidth(text)) / 2;
        int textY = fm.getHeight() + 20;
        
       
        
        // Основной текст - чёрный
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, centerX, textY);
        
        // Подпись
        g2d.setFont(new Font("Arial", Font.PLAIN, 16));
        g2d.setColor(Color.BLACK);
        String subtitle = "Попробуйте снова!";
        int subX = (width - g2d.getFontMetrics().stringWidth(subtitle)) / 2;
        g2d.drawString(subtitle, subX, textY + 40);
    }
    
    /** Останавливает анимацию (вызывать при закрытии окна) */
    public void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }
    
    /** Внутренний класс для капли */
    private class Drop {
        private int x, y;
        private int speed;
        private int size;
        
        public Drop(int x, int y, int speed) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.size = 4 + random.nextInt(5); // Размер капли 4-8 пикселей
        }
        
        public void update() {
            y += speed;
        }
        
        public void draw(Graphics2D g2d) {
            // Цвет капли - чёрный, но чуть светлее надписи (70% прозрачности)
            // Надпись чёрная (0,0,0), капли будут тёмно-серые
            g2d.setColor(new Color(60, 60, 60, 180));
            
            // Рисуем каплю в виде круга
            g2d.fillOval(x - size/2, y - size/2, size, size);
            
            // Блик на капле (светлый)
            g2d.setColor(new Color(150, 150, 150, 120));
            g2d.fillOval(x - size/4, y - size/4, size/3, size/3);
        }
        
        public boolean isDead(int height) {
            return y > height + 20;
        }
    }
}