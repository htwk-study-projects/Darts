package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private GridBagConstraints screenDivisionConstraints = new GridBagConstraints();
	private DartBoardGraphic board;
	private GameScreenSideBar sideBar;
	
	public GameScreen() {
		
		 this.setLayout(new GridBagLayout());
			
		 board = new DartBoardGraphic();
	     this.setScreenDivisionConstrains(0, 0, 2, 2, 200, 200, GridBagConstraints.BOTH);
	     this.add(board, screenDivisionConstraints);
	        
	     sideBar = new GameScreenSideBar();
	     this.setScreenDivisionConstrains(2, 0, 1, 1, 1, 1, GridBagConstraints.BOTH);
	     this.add(sideBar, screenDivisionConstraints);

	        
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
