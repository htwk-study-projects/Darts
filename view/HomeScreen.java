package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HomeScreen extends JPanel {

<<<<<<< HEAD
	private JLabel title;
	
	private DartBoardGraphic backgroundBoard;
	private Bar homeMenu;
	protected JButton playButton;
	protected JButton loadButton;
	protected JButton exitButton;
	
	public HomeScreen() {
		
		 backgroundBoard = new DartBoardGraphic(0.85);
		 this.add(backgroundBoard);
		
		this.setLayout(new GridLayout(3,3));
		DartsGUI.gridLayoutFill(this, 3, 3);
		
		title = new JLabel("Darts");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.remove(1);
		this.add(title, 1);
		
		playButton = new JButton("Spielen");
		loadButton = new JButton("Spiel laden");
		exitButton = new JButton("Beenden");
		
		JButton[] homeButtons = {playButton, loadButton, exitButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, homeButtons);
		
		homeMenu = new Bar(homeButtons);
		homeMenu.barPlacement(this, 4);
		
=======
    private GridBagConstraints screenDivisionConstraints = new GridBagConstraints();
>>>>>>> b7596267b92666da721127c275c059602f7be22a

    private JLabel title;
    private DartBoardGraphic backgroundBoard;
    private Bar homeMenu;
    
    
    protected JButton playButton;
    protected JButton loadButton;
    protected JButton exitButton;

    public HomeScreen() {
    	
        this.setLayout(new BorderLayout());
        
        JPanel gridBagPanel = new JPanel();
        gridBagPanel.setLayout(new GridBagLayout());

        backgroundBoard = new DartBoardGraphic(0.6);
        this.setScreenDivisionConstrains(0, 0, 3, 3, 3, 3, GridBagConstraints.BOTH);
        gridBagPanel.add(backgroundBoard, screenDivisionConstraints);

        title = new JLabel("Darts");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(DartsGUI.FONT_TITLE);
        title.setBorder(new EmptyBorder(20,0,0,0));
        this.add(title, BorderLayout.NORTH);        
        
        playButton = new JButton("Spielen");
        loadButton = new JButton("Spiel laden");
        exitButton = new JButton("Beenden");

        JComponent[] homeMenuElements = {playButton, loadButton, exitButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, homeMenuElements);
        homeMenu = new Bar(homeMenuElements);
        homeMenu.setOpaque(false);
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3,3));
        DartsGUI.gridLayoutFill(gridPanel, 3, 3);
        homeMenu.barPlacement(gridPanel, 4);
        gridPanel.setOpaque(false);
        this.setScreenDivisionConstrains(0, 0, 3, 3, 3, 3, GridBagConstraints.BOTH);
        gridBagPanel.add(gridPanel, screenDivisionConstraints);

        gridBagPanel.setComponentZOrder(backgroundBoard, 1);
        gridBagPanel.setComponentZOrder(gridPanel, 0);
        
        this.add(gridBagPanel, BorderLayout.CENTER);
    }

    private void setScreenDivisionConstrains(int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY, int fill) {
        screenDivisionConstraints.gridx = gridX;
        screenDivisionConstraints.gridy = gridY;
        screenDivisionConstraints.gridwidth = gridWidth;
        screenDivisionConstraints.gridheight = gridHeight;
        screenDivisionConstraints.weightx = weightX;
        screenDivisionConstraints.weighty = weightY;
        screenDivisionConstraints.fill = fill;
    }
}
