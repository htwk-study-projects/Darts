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
	
	private static final String NOT_THROWN_TEXT = "Nicht geworfen";
	private JLabel throw1Label;
	private JLabel throw2Label;
    private JLabel throw3Label;
	
    public GameScreenCurrentPlayerPanel() {
        
        setLayout(new GridLayout(5, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Icon and Name
        playerNameLabel = new JLabel("", playerIcon, SwingConstants.CENTER);
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
    
    public void resetThrowLabels() {
        throw1Label.setText(NOT_THROWN_TEXT);
        throw2Label.setText(NOT_THROWN_TEXT);
        throw3Label.setText(NOT_THROWN_TEXT);
    }
    
    
    public void setLabelTexts(String name, Color color, int throwCount, int[] throwPoints) {
        this.playerNameLabel.setText(name);
        this.playerIcon.setColor(color);
        JLabel[] throwLabels = {throw1Label, throw2Label, throw3Label};

        for (int i = 0; i < throwLabels.length; i++) {
            if (i < throwCount + 1) throwLabels[i].setText(String.valueOf(throwPoints[i]));
            else throwLabels[i].setText(NOT_THROWN_TEXT);
        }
        this.revalidate();
        this.repaint();
    } 

}