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
	
	private Line pointsLine;
	private JLabel pointsLabel;
	private JRadioButton points301; 
	private JRadioButton points501; 
	
	private Line playerNumberLine;
	private JLabel playerNumberLabel;
	private JRadioButton players2; 
	private JRadioButton players3;
	private JRadioButton players4;
	
	private Line modInLine;
	private JLabel modInLabel;
	private JRadioButton straightIn; 
	private JRadioButton doubleIn;
	private JRadioButton tripleIn;
	
	private Line modOutLine;
	private JLabel modOutLabel;
	private JRadioButton straightOut; 
	private JRadioButton doubleOut;
	private JRadioButton tripleOut;
	
	
	
	private Bar setupMenuBar;
	
	public SetupScreen() {
		
		this.setLayout(new GridLayout(1,3));	
		DartsGUI.gridLayoutFill(this, 1 , 3);

		
		title = new JLabel("Game Setup");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComponent[] Buttons = {players2, players3, players4};
		
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
		
		pointsLabel = new JLabel("Punkte:");	
		points301 = new JRadioButton("301 Punkte");
		points301.setSelected(true);
		points501 = new JRadioButton("501 Punkte");	
		ButtonGroup modeGroup = new ButtonGroup();
		modeGroup.add(points301);
		modeGroup.add(points501);		
		JComponent[] modeSetup = {pointsLabel, points301, points501};
		pointsLine = new Line(modeSetup);
		
		modInLabel = new JLabel("Start:");	
		straightIn = new JRadioButton("Straight-In");
		straightIn.setSelected(true);
		doubleIn = new JRadioButton("Double-In");
		tripleIn = new JRadioButton("Triple-In");
		ButtonGroup modInGroup = new ButtonGroup();
		modInGroup.add(straightIn);
		modInGroup.add(doubleIn);
		modInGroup.add(tripleIn);	
		JComponent[] modInSetup = {modInLabel, straightIn, doubleIn, tripleIn};
		modInLine = new Line(modInSetup);
		
		modOutLabel = new JLabel("Finish:");	
		straightOut = new JRadioButton("Straight-Out");
		straightOut.setSelected(true);
		doubleOut = new JRadioButton("Double-Out");
		tripleOut = new JRadioButton("Triple-Out");
		ButtonGroup modOutGroup = new ButtonGroup();
		modOutGroup.add(straightOut);
		modOutGroup.add(doubleOut);
		modOutGroup.add(tripleOut);	
		JComponent[] modOutSetup = {modOutLabel, straightOut, doubleOut, tripleOut};
		modOutLine = new Line(modOutSetup);
		
		startButton = new JButton("Weiter");		
		homeButton = new JButton("Zurück");
		JButton[] setupButtons = {homeButton, startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		startBreakLine = new Line(setupButtons);
		
		JComponent[] setupMenu = {title,pointsLine, playerNumberLine, modInLine, modOutLine,startBreakLine};
		setupMenuBar = new Bar(setupMenu);
		setupMenuBar.barPlacement(this, 1);
		
	}
}
