package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class StrengthBarPanel extends JPanel {
    private int maxStrength = 100;
    private int increaseRate = 3;
    private int currentStrength = 0;
    private Timer timer;
    private boolean charging = false;  // Variable to track if charging should continue

    public StrengthBarPanel() {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(200, 50));

       
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (charging && currentStrength < maxStrength) {
                    currentStrength += increaseRate;
                    repaint();
                } else if (currentStrength >= maxStrength) {
                    timer.stop();  
                }
            }
        });

        
        addKeyListener(new KeyAdapter() {
          
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    startCharging();
                }
            }

        
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    stopCharging();
                }
            }
        });

  
        setFocusable(true);
        requestFocusInWindow();

        setLayout(new BorderLayout());
    }

    public void startCharging() {
        if (!charging) {  
            charging = true;
            currentStrength = 0;
            timer.start();
        }
    }

    public void stopCharging() {
        charging = false;
        timer.stop();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int margin = 10;
        int barHeight = getHeight() - 2 * margin;
        int barWidth = getWidth() - 2 * margin;

        g.setColor(Color.BLACK);
        g.drawRect(margin, margin, barWidth, barHeight);

        int fillWidth = (int) (barWidth * ((double) currentStrength / maxStrength));
        g.fillRect(margin + 1, margin + 1, fillWidth - 8, barHeight - 1);
        
        setFocusable(true);  
        requestFocusInWindow();  
        
    }
    
    
}