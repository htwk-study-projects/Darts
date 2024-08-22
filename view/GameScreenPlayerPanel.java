package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameScreenPlayerPanel extends JPanel {

	private JLabel playerNameLabel;
	
	private JLabel throw1Label;
	private JLabel throw2Label;
    private JLabel throw3Label;
	
    public GameScreenPlayerPanel() {
        
        setLayout(new GridLayout(5, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Farbkästchen und Spielername kombinieren
        playerNameLabel = new JLabel("Spieler 1", new ColorIcon(Color.RED), SwingConstants.CENTER);
        playerNameLabel.setFont(DartsGUI.FONT_NORMAL);
        playerNameLabel.setIconTextGap(10); // Abstand zwischen Icon und Text

        add(playerNameLabel);

        throw1Label = new JLabel("Wurf 1: 50", SwingConstants.CENTER);
        throw2Label = new JLabel("Wurf 2: 20", SwingConstants.CENTER);
        throw3Label = new JLabel("Wurf 3: 30", SwingConstants.CENTER);

        JComponent[] labels= {throw1Label,throw2Label,throw3Label};
        DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, labels);
        add(throw1Label);
        add(throw2Label);
        add(throw3Label);
    }
}