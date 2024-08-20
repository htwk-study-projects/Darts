package view;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SetupScreen extends JPanel {
	
	private JLabel title;
	
	private Line startBreakLine;
	protected JButton startButton;
	protected JButton homeButton;
	
	private Line modeLine;
	private JLabel modeLabel;
	private JRadioButton mode301; 
	private JRadioButton mode501; 
	
	private Line playerNumberLine;
	private JLabel playerNumberLabel;
	private JRadioButton players2; 
	private JRadioButton players3;
	private JRadioButton players4; 
	
	private Bar setupMenuBar;
	
	public SetupScreen() {
		
		this.setLayout(new GridLayout(3,3));	
		DartsGUI.gridLayoutFill(this, 3, 3);
		
		title = new JLabel("Spielerstellung");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.remove(1);
		this.add(title, 1);
		
		modeLabel = new JLabel("Spielmodus:");	
		mode301 = new JRadioButton("301 Punkte");
		mode301.setSelected(true);
		mode501 = new JRadioButton("501 Punkte");	
		ButtonGroup modeGroup = new ButtonGroup();
		modeGroup.add(mode301);
		modeGroup.add(mode501);		
		JComponent[] modeSetup = {modeLabel, mode301, mode501};
		modeLine = new Line(modeSetup);
		
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
		playerNumberLine = new Line(playerNumberSetup);
		
		startButton = new JButton("Start");		
		homeButton = new JButton("Abbrechen");
		JButton[] setupButtons = {homeButton, startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		startBreakLine = new Line(setupButtons);
		
		JComponent[] setupMenu = {modeLine, playerNumberLine, startBreakLine};
		setupMenuBar = new Bar(setupMenu);
		setupMenuBar.barPlacement(this, 4);
	}
}
