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
	private Bar titleBar;

	private Line startBreakLine;
	protected JButton startButton;
	protected JButton backButton;
	
	private Line pointsLine;
	private JLabel pointsLabel;
	private ButtonGroup pointsGroup;
	private JRadioButton points301; 
	private JRadioButton points501; 
	
	private Line playerNumberLine;
	private JLabel playerNumberLabel;
	private ButtonGroup playersGroup;
	private JRadioButton players2; 
	private JRadioButton players3;
	private JRadioButton players4;
	
	private Line modInLine;
	private JLabel modInLabel;
	private ButtonGroup modeInGroup;
	private JRadioButton straightIn; 
	private JRadioButton doubleIn;
	private JRadioButton tripleIn;
	
	private Line modOutLine;
	private JLabel modOutLabel;
	private ButtonGroup modeOutGroup;
	private JRadioButton straightOut; 
	private JRadioButton doubleOut;
	private JRadioButton tripleOut;
	
	private Bar setupMenuBar;
	
	public SetupScreen() {
		
		this.setLayout(new GridLayout(3,3));	
		DartsGUI.gridLayoutFill(this, 3,3);
				
		Color background = Color.LIGHT_GRAY;

		title = new JLabel("Game Setup");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);		
		JComponent[] titleBarElements = {title,new TransparentPanel()};
<<<<<<< HEAD
		Bar titleBar = new Bar(titleBarElements);
		titleBar.setBackground(background);
=======
		titleBar = new Bar(titleBarElements);
		titleBar.setBackground(lightGray);
	
		pointsLabel = new JLabel("Punkte:");	
		points301 = new JRadioButton("301 Punkte");
		points301.setSelected(true);
		points301.setActionCommand("301");
		points501 = new JRadioButton("501 Punkte");	
		points501.setActionCommand("501");
		pointsGroup = new ButtonGroup();
		pointsGroup.add(points301);
		pointsGroup.add(points501);		
		JComponent[] modeSetup = {pointsLabel, points301, points501};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modeSetup);
		pointsLine = new Line(modeSetup);
>>>>>>> b864dc76a03ae38108480b0e2aef88c5bc8da835

		modInLabel = new JLabel("In");	
		straightIn = new JRadioButton("Straight");
		straightIn.setSelected(true);
		straightIn.setActionCommand("straight");
		doubleIn = new JRadioButton("Double");
		doubleIn.setActionCommand("double");
		tripleIn = new JRadioButton("Triple");
		tripleIn.setActionCommand("triple");
		modeInGroup = new ButtonGroup();
		modeInGroup.add(straightIn);
		modeInGroup.add(doubleIn);
		modeInGroup.add(tripleIn);	
		JComponent[] modInSetup = {modInLabel, straightIn, doubleIn, tripleIn};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modInSetup);
		modInLine = new Line(modInSetup);
		
		modOutLabel = new JLabel("Out:");	
		straightOut = new JRadioButton("Straight");
		straightOut.setSelected(true);
		straightOut.setActionCommand("straight");
		doubleOut = new JRadioButton("Double");
		doubleOut.setActionCommand("double");
		tripleOut = new JRadioButton("Triple");
		tripleOut.setActionCommand("triple");
		modeOutGroup = new ButtonGroup();
		modeOutGroup.add(straightOut);
		modeOutGroup.add(doubleOut);
		modeOutGroup.add(tripleOut);	
		JComponent[] modOutSetup = {modOutLabel, straightOut, doubleOut, tripleOut};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modOutSetup);
		modOutLine = new Line(modOutSetup);
		
		playerNumberLabel = new JLabel("Spieler:");	
		players2 = new JRadioButton("2 Spieler");
		players2.setSelected(true);
		players2.setActionCommand("2");
		players3 = new JRadioButton("3 Spieler");
		players3.setActionCommand("3");
		players4 = new JRadioButton("4 Spieler");
		players4.setActionCommand("4");
		playersGroup = new ButtonGroup();
		playersGroup.add(players2);
		playersGroup.add(players3);
		playersGroup.add(players4);	
		JComponent[] playerNumberSetup = {playerNumberLabel, players2, players3, players4};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, playerNumberSetup);
		playerNumberLine = new Line(playerNumberSetup);
	
		startButton = new JButton("Weiter");		
		backButton = new JButton("Zurück");
		JButton[] setupButtons = {backButton, startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		startBreakLine = new Line(setupButtons);
<<<<<<< HEAD
		startBreakLine.setBackground(background);
=======
		startBreakLine.setBackground(lightGray);
		JComponent[] startBreakBarElements = {new TransparentPanel(),new TransparentPanel(),new TransparentPanel(),startBreakLine};
		Bar startBreakBar = new Bar(startBreakBarElements);
		startBreakBar.setBackground(lightGray);
>>>>>>> b864dc76a03ae38108480b0e2aef88c5bc8da835
	
		JComponent[] setupMenu = {pointsLine, playerNumberLine, modInLine, modOutLine};
		for (JComponent component : setupMenu) {
			component.setOpaque(false);	
		}
<<<<<<< HEAD
		
		
		
		JComponent[] startBreakBarElements = {new TransparentPanel(),new TransparentPanel(),new TransparentPanel(),startBreakLine};
		Bar startBreakBar = new Bar(startBreakBarElements);
		startBreakBar.setBackground(background);
		
		
		this.remove(1);
		this.add(titleBar,1);
		setupMenuBar = new Bar(setupMenu);
		setupMenuBar.barPlacement(this, 4);
		this.remove(7);
		this.add(startBreakBar,7);
		
		setupMenuBar.setBackground(background);
=======
		setupMenuBar = new Bar(setupMenu);
		setupMenuBar.setBackground(lightGray);
		
		titleBar.barPlacement(this, 1);
		setupMenuBar.barPlacement(this, 4);
		startBreakBar.barPlacement(this, 7);
>>>>>>> b864dc76a03ae38108480b0e2aef88c5bc8da835
	}
	
	public ButtonGroup getPlayersGroup() {
		return playersGroup;
	}
	
	public ButtonGroup getPointsGroup() {
		return pointsGroup;
	}
	
	public ButtonGroup getModeInGroup() {
		return modeInGroup;
	}
	
	public ButtonGroup getModeOutGroup() {
		return modeOutGroup;
	}
	
	public JButton getStartButton() {
		return startButton;
	}
	
	
}