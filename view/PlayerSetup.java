package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PlayerSetup extends JPanel {
	
	private static final long serialVersionUID = 1L;

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
	
	public PlayerSetup() {
		
		this.setLayout(new GridLayout(1,3));	
		DartsGUI.gridLayoutFill(this, 1 , 3);

		
		title = new JLabel("Spieler-Setup");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		modeLabel = new JLabel("Punkte:");	
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
		
		startButton = new JButton("Weiter");		
		homeButton = new JButton("Zurück");
		JButton[] setupButtons = {homeButton, startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		startBreakLine = new Line(setupButtons);
		
		JComponent[] setupMenu = {title,modeLine, playerNumberLine, startBreakLine};
		setupMenuBar = new Bar(setupMenu);
		setupMenuBar.barPlacement(this, 1);
	}
}
