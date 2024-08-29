package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DebugScreenSideBar extends JPanel {

	private Bar playerModeBar;
	private Line gameSetupLine;
	private Line playerPointsLine;
	private JLabel setupLabel;
	private JLabel gameSetupLabel;
	private JLabel playerSetupLabel;
	private JLabel displayPointsLabel;
    private JRadioButton StraightRadioButton;
    private JRadioButton DoubleRadioButton;
    private JRadioButton TripleRadioButton;
    private JTextField playerPointsTextField;
    private Line createPlayerButtonLine;
    private Line displayPointsLine;
    private JButton createPlayerButton;
    private ButtonGroup mode;
    
    private Bar distanceAngleBar;
    private Line distanceLine;
    private Line angleLine;
    private JLabel distaneAngleTitle;
    private JLabel distanceLabel;
    private JLabel angleLabel;
    private JTextField distanceTextField;
    private JTextField angleTextField;
    private Line distancebuttonLine;
    private JButton placeDistanceAngleButton;
    
    private Bar vectorBar;
    private Line vectorXLine;
    private Line vectorYLine;
    private Line vectorZLine;
    private JLabel vectorTitle;
    private JLabel vectorXLabel;
    private JLabel vectorYLabel;
    private JLabel vectorZLabel;
    private JTextField vectorXTextField;
    private JTextField vectorYTextField;
    private JTextField vectorZTextField;
    private Line vectorButtonLine;
    private JButton placeVectorButton;
    
    private Line breakLine;
    private Bar breakBar;
    protected JButton backButton;
    
    private Bar mainBar;

    public DebugScreenSideBar() {
    	this.setLayout(new BorderLayout());
       
    	setupLabel = new JLabel("Game Setup und Player Setup", SwingConstants.CENTER);
        
        gameSetupLabel = new JLabel("Game Setup:");
        
      
        this.StraightRadioButton = createRadioButton("Straight", "straight", true);
        this.DoubleRadioButton = createRadioButton("Double", "double", false);
        this.TripleRadioButton = createRadioButton("Triple", "triple", false);
        
        mode = new ButtonGroup();
        
        mode.add(StraightRadioButton);
        mode.add(DoubleRadioButton);
        mode.add(TripleRadioButton);
        
        gameSetupLine = new Line(new JComponent[]{gameSetupLabel, StraightRadioButton,DoubleRadioButton,TripleRadioButton});
        gameSetupLine.setOpaque(false);
        
        playerSetupLabel = new JLabel("Punkte: ");
        playerPointsTextField = new JTextField(10);
        playerPointsLine = new Line(new JComponent[]{playerSetupLabel,playerPointsTextField,});
        playerPointsLine.setOpaque(false);
        
        createPlayerButton = new JButton("Spieler erstellen");
        createPlayerButtonLine = new Line(new JComponent[]{new TransparentPanel(), createPlayerButton, new TransparentPanel()});
        createPlayerButtonLine.setOpaque(false);
        
        displayPointsLabel = new JLabel("");
        displayPointsLine = new Line(new JComponent[]{displayPointsLabel});
        displayPointsLine.setOpaque(false);
        
        playerModeBar = new Bar(new JComponent[]{setupLabel, gameSetupLine, playerPointsLine,createPlayerButtonLine,displayPointsLine});  
        playerModeBar.setOpaque(false);

        
        distaneAngleTitle = new JLabel("Mit Distance und Winkel", SwingConstants.CENTER);
        
        distanceLabel = new JLabel("Distanz:");
        distanceTextField = new JTextField(10);
        distanceLine = new Line(new JComponent[] {distanceLabel,distanceTextField});
        distanceLine.setOpaque(false);
        
        angleLabel = new JLabel("Winkel:");
        angleTextField = new JTextField(10);
        angleLine = new Line(new JComponent[] {angleLabel, angleTextField});
        angleLine.setOpaque(false);
        
        placeDistanceAngleButton = new JButton("Pfeil platzieren");
        distancebuttonLine = new Line(new JComponent[]{new TransparentPanel(), placeDistanceAngleButton, new TransparentPanel()});
        distancebuttonLine.setOpaque(false);
        
        distanceAngleBar = new Bar(new JComponent[] {distaneAngleTitle, distanceLine, angleLine, distancebuttonLine});
        distanceAngleBar.setOpaque(false);

        
        vectorTitle = new JLabel("Mit Wurfvektor", SwingConstants.CENTER);
        
        vectorXLabel = new JLabel("X:");
        vectorXTextField = new JTextField(10);      
        vectorXLine = new Line(new JComponent[] {vectorXLabel, vectorXTextField});
        vectorXLine.setOpaque(false);
        
        vectorYLabel = new JLabel("Y:");
        vectorYTextField = new JTextField(10);
        vectorYLine = new Line(new JComponent[] {vectorYLabel, vectorYTextField});
        vectorYLine.setOpaque(false);
        
        vectorZLabel = new JLabel("Z:");
        vectorZTextField = new JTextField(10);      
        vectorZLine = new Line(new JComponent[] {vectorZLabel, vectorZTextField});
        vectorZLine.setOpaque(false);
        
        placeVectorButton = new JButton("Pfeil platzieren");
        vectorButtonLine = new Line(new JComponent[]{new TransparentPanel(), placeVectorButton, new TransparentPanel()});
        vectorButtonLine.setOpaque(false);
        
        vectorBar = new Bar(new JComponent[]{vectorTitle, vectorXLine, vectorYLine, vectorZLine, vectorButtonLine});
        vectorBar.setOpaque(false);
        
        backButton = new JButton("zum Homescreen");
        breakLine = new Line(new JComponent[] { new TransparentPanel(), backButton, new TransparentPanel() });
        breakLine.setBackground(DartsGUI.BACKGROUND_COLOR);
        breakBar = new Bar(new JComponent [] {new TransparentPanel(),backButton});
        breakBar.setOpaque(false);

        JComponent[] sideBarElements = {setupLabel,playerModeBar, distanceAngleBar, vectorBar, breakBar};
        mainBar = new Bar(sideBarElements);
        mainBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        JComponent[] labels = {setupLabel, gameSetupLabel,displayPointsLabel, playerSetupLabel, distaneAngleTitle, distanceLabel, angleLabel, vectorTitle, vectorXLabel, vectorYLabel, vectorZLabel};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, labels);
        JComponent[] radioButtons = {StraightRadioButton,DoubleRadioButton,TripleRadioButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, radioButtons);
        JButton[] buttons = {createPlayerButton, placeDistanceAngleButton, placeVectorButton, backButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, buttons);
        
        this.add(mainBar);
    }

	public JTextField getDistanceTextField() {
		return distanceTextField;
	}

	public void setDistanceTextField(JTextField distanceTextField) {
		this.distanceTextField = distanceTextField;
	}

	public JTextField getAngleTextField() {
		return angleTextField;
	}

	public JButton getPlaceDistanceAngleButton() {
		return placeDistanceAngleButton;
	}

	public JTextField getVectorXTextField() {
		return vectorXTextField;
	}

	public JTextField getVectorYTextField() {
		return vectorYTextField;
	}

	public JTextField getVectorZTextField() {
		return vectorZTextField;
	}

	public JButton getPlaceVectorButton() {
		return placeVectorButton;
	}

	public JButton getBackButton() {
		return backButton;
	}
	
	public JButton getCreatePlayerButton() {
		return createPlayerButton;
	}
	
	public JTextField getPlayerPointsTextField () {
		return playerPointsTextField;
		
	}
	
	public ButtonGroup getModeRadioButton() {
		return mode;
	}
	
	public JLabel getDisplayPointsLabel() {
		return displayPointsLabel;
	}
	
	private JRadioButton createRadioButton(String text, String actionCommand, boolean isSelected) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setActionCommand(actionCommand);
        radioButton.setSelected(isSelected);
        return radioButton;
    }
    

    
}