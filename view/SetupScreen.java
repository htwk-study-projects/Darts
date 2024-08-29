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

public class SetupScreen extends JPanel implements SetupScreenInterface{
	
	private JLabel title;
	private Bar titleBar;
	
	private Bar startBreakBar;
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

		createTitleBar();
		
		createPointsLine();
		createPlayerNumberLine();
		createModeInLine();
		createModeOutLine();
		createSetupMenuBar();
		
		createStartBreakBar();

		titleBar.barPlacementInGridLayout(this, 1);
		setupMenuBar.barPlacementInGridLayout(this, 4);
		startBreakBar.barPlacementInGridLayout(this, 7);
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
	
	private void createTitleBar() {
		this.title = new JLabel("Game Setup");
		this.title.setFont(DartsGUI.FONT_TITLE);
		this.title.setHorizontalAlignment(SwingConstants.CENTER);		
		JComponent[] titleBarElements = {this.title, new TransparentPanel()};
		this.titleBar = new Bar(titleBarElements);
		this.titleBar.setBackground(DartsGUI.BACKGROUND_COLOR);
	}
	
	private void createPointsLine() {
		this.pointsLabel = new JLabel("Punkte:");	
        this.points301 = createRadioButton("301 Punkte", "301", true);
        this.points501 = createRadioButton("501 Punkte", "501", false);
		this.pointsGroup = new ButtonGroup();
		this.pointsGroup.add(this.points301);
		this.pointsGroup.add(this.points501);		
		JComponent[] pointsLineElements = {this.pointsLabel, this.points301, this.points501};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, pointsLineElements);
		this.pointsLine = new Line(pointsLineElements);
	}
	
	private void createPlayerNumberLine() {
		this.playerNumberLabel = new JLabel("Spieler:");	
        this.players2 = createRadioButton("2 Spieler", "2", true);
        this.players3 = createRadioButton("3 Spieler", "3", false);
        this.players4 = createRadioButton("4 Spieler", "4", false);
		this.playersGroup = new ButtonGroup();
		this.playersGroup.add(this.players2);
		this.playersGroup.add(this.players3);
		this.playersGroup.add(this.players4);	
		JComponent[] playerNumberLineElements = {this.playerNumberLabel, this.players2, this.players3, this.players4};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, playerNumberLineElements);
		this.playerNumberLine = new Line(playerNumberLineElements);
	}
	
	private void createModeInLine() {
		this.modInLabel = new JLabel("In:");	
		this.straightIn = createRadioButton("Straight", "straight", true);
        this.doubleIn = createRadioButton("Double", "double", false);
        this.tripleIn = createRadioButton("Triple", "triple", false);
		this.modeInGroup = new ButtonGroup();
		this.modeInGroup.add(this.straightIn);
		this.modeInGroup.add(this.doubleIn);
		this.modeInGroup.add(this.tripleIn);	
		JComponent[] modInLineElements = {this.modInLabel, this.straightIn, this.doubleIn, this.tripleIn};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modInLineElements);
		this.modInLine = new Line(modInLineElements);
	}
	
	private void createModeOutLine() {
		this.modOutLabel = new JLabel("Out:");	
		this.straightOut = createRadioButton("Straight", "straight", true);
        this.doubleOut = createRadioButton("Double", "double", false);
        this.tripleOut = createRadioButton("Triple", "triple", false);
		this.modeOutGroup = new ButtonGroup();
		this.modeOutGroup.add(this.straightOut);
		this.modeOutGroup.add(this.doubleOut);
		this.modeOutGroup.add(this.tripleOut);	
		JComponent[] modOutLineElements = {this.modOutLabel, this.straightOut, this.doubleOut, this.tripleOut};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, modOutLineElements);
		this.modOutLine = new Line(modOutLineElements);	
	}
	
	private void createSetupMenuBar() {
		JComponent[] setupMenuBarElements = {this.pointsLine, this.playerNumberLine, this.modInLine, this.modOutLine};
		for (JComponent component : setupMenuBarElements) {
			component.setOpaque(false);	
		}
		this.setupMenuBar = new Bar(setupMenuBarElements);
		this.setupMenuBar.setBackground(DartsGUI.BACKGROUND_COLOR);
	}
	
	private void createStartBreakBar() {
		this.startButton = new JButton("Weiter");		
		this.backButton = new JButton("zum Homescreen");
		JButton[] startBreakLineElements = {this.backButton, this.startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, startBreakLineElements);
		this.startBreakLine = new Line(startBreakLineElements);
		this.startBreakLine.setBackground(DartsGUI.BACKGROUND_COLOR);

		JComponent[] startBreakBarElements = {new TransparentPanel(),new TransparentPanel(),new TransparentPanel(), this.startBreakLine};
		this.startBreakBar = new Bar(startBreakBarElements);
		this.startBreakBar.setBackground(DartsGUI.BACKGROUND_COLOR);
	}
	
    private JRadioButton createRadioButton(String text, String actionCommand, boolean isSelected) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setActionCommand(actionCommand);
        radioButton.setSelected(isSelected);
        return radioButton;
    }
	
}