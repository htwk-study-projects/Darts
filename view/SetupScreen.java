package view;

import java.awt.Color;
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
	protected JButton backButton;
	
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
		
		this.setLayout(new GridLayout(3,3));	
		DartsGUI.gridLayoutFill(this, 3,3);
				
		Color lightGray = Color.LIGHT_GRAY;

		title = new JLabel("Game Setup");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		
		JComponent[] titleBarElements = {title,new TransparentPanel()};
		Bar titleBar = new Bar(titleBarElements);
		titleBar.setBackground(lightGray);

		
		
		playerNumberLabel = new JLabel("Spieler:");	
		players2 = new JRadioButton("2 Spieler");
		players2.setSelected(true);
		players3 = new JRadioButton("3 Spieler");
		players4 = new JRadioButton("4 Spieler");
		ButtonGroup playersGroup = new ButtonGroup();
		playersGroup.add(players2);
		playersGroup.add(players3);
		playersGroup.add(players4);	
		JComponent[] playerNumberSetup = {playerNumberLabel, players2, players3, players4};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, playerNumberSetup);
		playerNumberLine = new Line(playerNumberSetup);

		
		pointsLabel = new JLabel("Punkte:");	
		points301 = new JRadioButton("301 Punkte");
		points301.setSelected(true);
		points501 = new JRadioButton("501 Punkte");	
		ButtonGroup modeGroup = new ButtonGroup();
		modeGroup.add(points301);
		modeGroup.add(points501);		
		JComponent[] modeSetup = {pointsLabel, points301, points501};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modeSetup);
		pointsLine = new Line(modeSetup);

		
		modInLabel = new JLabel("In");	
		straightIn = new JRadioButton("Straight");
		straightIn.setSelected(true);
		doubleIn = new JRadioButton("Double");
		tripleIn = new JRadioButton("Triple");
		ButtonGroup modInGroup = new ButtonGroup();
		modInGroup.add(straightIn);
		modInGroup.add(doubleIn);
		modInGroup.add(tripleIn);	
		JComponent[] modInSetup = {modInLabel, straightIn, doubleIn, tripleIn};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modInSetup);
		modInLine = new Line(modInSetup);


		
		modOutLabel = new JLabel("Out:");	
		straightOut = new JRadioButton("Straight");
		
		straightOut.setSelected(true);
		doubleOut = new JRadioButton("Double");
		tripleOut = new JRadioButton("Triple");
		ButtonGroup modOutGroup = new ButtonGroup();
		modOutGroup.add(straightOut);
		modOutGroup.add(doubleOut);
		modOutGroup.add(tripleOut);	
		JComponent[] modOutSetup = {modOutLabel, straightOut, doubleOut, tripleOut};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modOutSetup);
		modOutLine = new Line(modOutSetup);
	
		
		startButton = new JButton("Weiter");		
		backButton = new JButton("Zurück");
		JButton[] setupButtons = {backButton, startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		startBreakLine = new Line(setupButtons);
		startBreakLine.setBackground(lightGray);
	
		
		JComponent[] setupMenu = {pointsLine, playerNumberLine, modInLine, modOutLine};
		for (JComponent component : setupMenu) {
			component.setOpaque(false);	
		}
		
		
		
		JComponent[] startBreakBarElements = {new TransparentPanel(),new TransparentPanel(),new TransparentPanel(),startBreakLine};
		Bar startBreakBar = new Bar(startBreakBarElements);
		startBreakBar.setBackground(lightGray);
		
		
		this.remove(1);
		this.add(titleBar,1);
		setupMenuBar = new Bar(setupMenu);
		setupMenuBar.barPlacement(this, 4);
		this.remove(7);
		this.add(startBreakBar,7);
		
		setupMenuBar.setBackground(lightGray);
	}
}