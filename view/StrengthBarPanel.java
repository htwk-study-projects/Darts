package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class StrengthBarPanel extends JPanel {
    private int maxStrength = 100;
    private int increaseRate = 3;
    private int currentStrength = 0;
    private Timer timer;
    private JButton chargeButton;  
    private Line buttonLine;

    public StrengthBarPanel() {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(200, 50)); 

 
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentStrength < maxStrength) {
                    currentStrength += increaseRate;
                    repaint();
                } else {
                    timer.stop();
                }
            }
        });

        chargeButton = new JButton("Aufladen");
        chargeButton.setFont(DartsGUI.FONT_NORMAL);
        chargeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                startCharging();
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopCharging(); 
            }
        });
        
        buttonLine = new Line(new JComponent[] { new TransparentPanel(), chargeButton, new TransparentPanel() });
        buttonLine.setBackground(DartsGUI.BACKGROUND_COLOR);

  
        setLayout(new BorderLayout());
        add(buttonLine, BorderLayout.SOUTH); 
    }

    public void startCharging() {
        currentStrength = 0;
        timer.start();
    }

    public void stopCharging() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int margin = 10;
        int barHeight = getHeight() - chargeButton.getHeight() - 2 * margin - 10; // Platz für Button einberechnen
        int barWidth = getWidth() - 2 * margin; 

        g.setColor(Color.BLACK);
        g.drawRect(margin, margin, barWidth, barHeight);

    
        int fillWidth = (int) (barWidth * ((double) currentStrength / maxStrength));
        g.fillRect(margin + 1, margin + 1, fillWidth - 8, barHeight - 1);
    }


}