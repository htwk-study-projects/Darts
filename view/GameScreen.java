package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private GridBagConstraints screenDivisionConstraints = new GridBagConstraints();
	
	private DartBoardGraphic board;
	private GameScreenSideBar sideBar;

	protected JButton saveButton;
	protected JButton backButton;
	
	public GameScreen() {
		
		 this.setLayout(new GridBagLayout());
			
		 board = new DartBoardGraphic(1);
	     this.setScreenDivisionConstrains(0, 0, 2, 2, 20, 20, GridBagConstraints.BOTH);
	     this.add(board, screenDivisionConstraints);
	        
	     sideBar = new GameScreenSideBar();
	     this.setScreenDivisionConstrains(2, 0, 1, 1, 1, 1, GridBagConstraints.BOTH);
	     this.add(sideBar, screenDivisionConstraints);

		 this.saveButton = sideBar.saveButton;
		 this.backButton = sideBar.backButton;
		 
	        
	}
	
	private void setScreenDivisionConstrains(int gridX, int gridY, int gridWidth, int gridHeight,int weightX, int weightY, int fill) {
        screenDivisionConstraints.gridx = gridX;
        screenDivisionConstraints.gridy = gridY;
        screenDivisionConstraints.gridwidth = gridWidth;
        screenDivisionConstraints.gridheight = gridHeight;
        screenDivisionConstraints.weightx = weightX;
        screenDivisionConstraints.weighty = weightY;
        screenDivisionConstraints.fill = fill;
	}
	
}
