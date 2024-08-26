package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameScreenCurrentPlayerPanel extends JPanel {

	private JLabel playerNameLabel;
	private ColorIcon playerIcon = new ColorIcon(Color.black);
	
	private JLabel throw1Label;
	private JLabel throw2Label;
    private JLabel throw3Label;
	
    public GameScreenCurrentPlayerPanel() {
        
        setLayout(new GridLayout(5, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Farbkästchen und Spielername kombinieren
        playerNameLabel = new JLabel("Spieler 1", playerIcon, SwingConstants.CENTER);
        playerNameLabel.setIconTextGap(10);

        add(playerNameLabel);

        throw1Label = new JLabel("dummy", SwingConstants.CENTER);
        throw2Label = new JLabel("dummy", SwingConstants.CENTER);
        throw3Label = new JLabel("dummy", SwingConstants.CENTER);

        JComponent[] labels= {playerNameLabel,throw1Label,throw2Label,throw3Label};
        DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, labels);
        add(throw1Label);
        add(throw2Label);
        add(throw3Label);
    }
    
    public void setLabelTexts(String name, Color color, String firstThrow, String secondThrow, String thirdThrow) {
    	this.playerNameLabel.setText(name);
    	this.playerIcon.setColor(color);
    	this.throw1Label.setText(firstThrow);
    	this.throw2Label.setText(secondThrow);
    	this.throw3Label.setText(thirdThrow);
    	
    	this.repaint();
    }

}