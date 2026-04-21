package Drawings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawVictory extends JPanel {
    
    /** Ширина окна*/
    private final int width; 

    /** Высота окна*/
    private final int height;
    
    /** Список частиц салюта */
    private ArrayList<Particle> particles;
    
    /** Генератор случайных чисел */
    private Random random;
    
    /** Таймер для анимации */
    private Timer timer;

    public DrawVictory(int width, int height){
        this.width = width;
        this.height = height;
        this.particles = new ArrayList<>();
        this.random = new Random();
        

        timer = new Timer(50, new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (random.nextInt(100) < 30) {
                    createFirework();
                }
                
                
                updateParticles();
                
                
                repaint();
            }
        });
        timer.start();
    }
    
    /** Создает новую вспышку салюта в случайной позиции */
    private void createFirework() {
        int x = 50 + random.nextInt(width - 100);
        int y = 50 + random.nextInt(height - 150);
        int colorIndex = random.nextInt(6);
        Color color = getFireworkColor(colorIndex);
        

        int particleCount = 20 + random.nextInt(21);
        for (int i = 0; i < particleCount; i++) {
            double angle = random.nextDouble() * 2 * Math.PI;
            double speed = 2 + random.nextDouble() * 6;
            double vx = Math.cos(angle) * speed;
            double vy = Math.sin(angle) * speed;
            particles.add(new Particle(x, y, vx, vy, color));
        }
    }
    
    /** Возвращает цвет для салюта */
    private Color getFireworkColor(int index) {
        switch(index) {
            case 0: return Color.RED;
            case 1: return Color.GREEN;
            case 2: return Color.BLUE;
            case 3: return Color.YELLOW;
            case 4: return Color.MAGENTA;
            default: return Color.CYAN;
        }
    }
    
    /** Обновляет положение всех частиц и удаляет угасшие */
    private void updateParticles() {
        Iterator<Particle> iterator = particles.iterator();
        while (iterator.hasNext()) {
            Particle p = iterator.next();
            p.update();
            if (p.isDead(width, height)) {
                iterator.remove();
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for (Particle p : particles) {
            p.draw(g2d);
        }
        
        // Рисуем надпись 
        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        FontMetrics fm = g2d.getFontMetrics();
        String text = "ПОБЕДА";
        int centerX = (width - fm.stringWidth(text)) / 2;
        int textY = fm.getHeight() + 20;
        
        
      
        g2d.setColor(Color.BLACK); 
        g2d.drawString(text, centerX, textY);
        
  
        g2d.setFont(new Font("Arial", Font.PLAIN, 16));
        g2d.setColor(Color.BLACK);
        String subtitle = "Поздравляем с победой!";
        int subX = (width - g2d.getFontMetrics().stringWidth(subtitle)) / 2;
        g2d.drawString(subtitle, subX, textY + 40);
    }
    

    public void stopFireworks() {
        if (timer != null) {
            timer.stop();
        }
    }
    
    /** класс для представления одной частицы салюта */
    private class Particle {
        double x, y;      
        double vx, vy;    
        double gravity;   
        double life;      
        double decay;     
        Color color;      
        int size;         
        
        public Particle(double x, double y, double vx, double vy, Color color) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.gravity = 0.2;
            this.life = 1.0;
            this.decay = 0.02 + random.nextDouble() * 0.03;
            this.color = color;
            this.size = 3 + random.nextInt(4);
        }
        
        public void update() {
            x += vx;
            y += vy;
            vy += gravity;
            life -= decay;
        }
        
        public void draw(Graphics2D g2d) {
            if (life > 0) {
              
                int alpha = (int)(life * 255);
                Color particleColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
                g2d.setColor(particleColor);
                
                int currentSize = (int)(size * life);
                if (currentSize < 1) currentSize = 1;
                g2d.fillOval((int)x - currentSize/2, (int)y - currentSize/2, currentSize, currentSize);
            }
        }
        
        public boolean isDead(int width, int height) {
            return life <= 0 || x < -50 || x > width + 50 || y > height + 100;
        }
    }
}
