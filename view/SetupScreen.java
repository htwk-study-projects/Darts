package view;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SetupScreen extends JPanel {
	
	
	private SetupLine startBreakLine;
	protected JButton startButton;
	protected JButton homeButton;
	
	private SetupLine modeLine;
	private JLabel modeLabel;
	private JRadioButton mode301; 
	private JRadioButton mode501; 
	
	private SetupLine playerNumberLine;
	private JLabel playerNumberLabel;
	private JRadioButton players2; 
	private JRadioButton players3;
	private JRadioButton players4; 
	
	private MenuBar setupPanel;
	
	public SetupScreen() {
		
		this.setLayout(new GridLayout(1,3));	
		
		modeLabel = new JLabel("Spielmodus:");	
		mode301 = new JRadioButton("301 Punkte");
		mode301.setSelected(true);
		mode501 = new JRadioButton("501 Punkte");	
		ButtonGroup modeGroup = new ButtonGroup();
		modeGroup.add(mode301);
		modeGroup.add(mode501);		
		JComponent[] modeSetup = {modeLabel, mode301, mode501};
		modeLine = new SetupLine(modeSetup);
		
		playerNumberLabel = new JLabel("Spieleranzahl:");	
		players2 = new JRadioButton("2 Spieler");
		players2.setSelected(true);
		players3 = new JRadioButton("3 Spieler");
		players4 = new JRadioButton("4 Spieler");
		ButtonGroup playersGroup = new ButtonGroup();
		playersGroup.add(players2);
		playersGroup.add(players3);
		playersGroup.add(players4);	
		JComponent[] playerNumberSetup = {playerNumberLabel, players2, players3, players4};
		playerNumberLine = new SetupLine(playerNumberSetup);
		
		startButton = new JButton("Start");		
		homeButton = new JButton("Abbrechen");
		JButton[] setupButtons = {homeButton, startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		startBreakLine = new SetupLine(setupButtons);
		
		JComponent[] setup = {modeLine, playerNumberLine, startBreakLine};
		setupPanel = new MenuBar(setup, 3, 1);
		setupPanel.menuPlacement(this, 1, 1, 3);
	}
}
