package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * ThrowStrengthInputPanel is a custom JPanel that visually represents the charging
 * of throwing strength. The user can press and hold the space bar to increase the strength,
 * which is displayed as a filled rectangle that grows horizontally. The strength charging stops
 * either when the maximum strength is reached or when the space bar is released.
 */
public class ThrowStrengthInputPanel extends JPanel {

    private static final double MAX_STRENGTH = 47.4;
    private static final double INCREASE_RATE = 11.85;
    private double currentStrength = 0;
    private Timer timer;
    private boolean charging = false;
    
    private Color inputColor;

    public ThrowStrengthInputPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);
        
        this.inputColor = Color.BLACK;

        this.timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (charging && currentStrength < MAX_STRENGTH) {
                    currentStrength += INCREASE_RATE;
                    repaint();
                } else if (currentStrength >= MAX_STRENGTH) {
                    timer.stop();
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) startCharging();
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) stopCharging();
            }
        });

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void startCharging() {
        if (!charging) {
            charging = true;
            currentStrength = 0;
            repaint();          
            timer.start();
        }
    }

    private void stopCharging() {
        charging = false;
        timer.stop();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int margin = 10;
        int barHeight = getHeight() - 2 * margin;
        int barWidth = getWidth() - 2 * margin;

        g.setColor(inputColor);
        g.drawRect(margin, margin, barWidth, barHeight);

        int fillWidth = (int) (barWidth * ((double) currentStrength / MAX_STRENGTH));
        g.fillRect(margin + 1, margin + 1, fillWidth, barHeight - 1);

        setFocusable(true);
        requestFocusInWindow();
    }
    
    public void setInputColor(Color playerColor) {
    	this.inputColor = playerColor;
    	repaint();
    }
    
    public void resetCharging() {
    	this.currentStrength = 0;
    	repaint();
    }
    
    public double getCurrentStrength() {
    	return currentStrength;
    }
    
}
