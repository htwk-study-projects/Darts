package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DebugScreenSideBar extends JPanel {

	private Bar sectorMultiplierBar;
	private Line sectorLine;
	private Line multiplierLine;
	private JLabel sectorMultiplierTitle;
	private JLabel sectorLabel;
	private JLabel multiplierLabel;
    private JTextField sectorTextField;
    private JTextField multiplierTextField;
    private Line sectorMultiplierButtonLine;
    private JButton placeSectorMultiplierButton;
    
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
    
    private Line BreakLine;
    protected JButton backButton;
    
    private Bar mainBar;

    public DebugScreenSideBar() {
    	this.setLayout(new BorderLayout());
       
    	sectorMultiplierTitle = new JLabel("Mir Sektor und Multiplikator", SwingConstants.CENTER);
        
        sectorLabel = new JLabel("Sektor:");
        sectorTextField = new JTextField(10);
        sectorLine = new Line(new JComponent[]{sectorLabel, sectorTextField});
        sectorLine.setOpaque(false);
        
        multiplierLabel = new JLabel("Multip.:");
        multiplierTextField = new JTextField(10);
        multiplierLine = new Line(new JComponent[]{multiplierLabel, multiplierTextField});
        multiplierLine.setOpaque(false);
        
        placeSectorMultiplierButton = new JButton("Pfeil platzieren");
        sectorMultiplierButtonLine = new Line(new JComponent[]{new TransparentPanel(), placeSectorMultiplierButton, new TransparentPanel()});
        sectorMultiplierButtonLine.setOpaque(false);
        
        sectorMultiplierBar = new Bar(new JComponent[]{sectorMultiplierTitle, sectorLine, multiplierLine, sectorMultiplierButtonLine});  
        sectorMultiplierBar.setOpaque(false);

        
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
        
        backButton = new JButton("Zurück");
        BreakLine = new Line(new JComponent[] { new TransparentPanel(), backButton, new TransparentPanel() });
        BreakLine.setBackground(DartsGUI.BACKGROUND_COLOR);

        JComponent[] sideBarElements = {new TransparentPanel(), sectorMultiplierBar, distanceAngleBar, vectorBar,new TransparentPanel(), BreakLine};
        mainBar = new Bar(sideBarElements);
        mainBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        JComponent[] labels = {sectorMultiplierTitle, sectorLabel, multiplierLabel, distaneAngleTitle, distanceLabel, angleLabel, vectorTitle, vectorXLabel, vectorYLabel, vectorZLabel};
        DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, labels);
        JButton[] buttons = {placeSectorMultiplierButton, placeDistanceAngleButton, placeVectorButton, backButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, buttons);
        
        this.add(mainBar);
    }

    
}