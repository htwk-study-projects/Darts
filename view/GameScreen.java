package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private GridBagConstraints screenDivisionConstraints = new GridBagConstraints();
	private DartBoardGraphic board;
	private JPanel sideBar;
	
	public GameScreen() {
		
		 this.setLayout(new GridBagLayout());
			
		 board = new DartBoardGraphic();
	     this.setScreenDivisionConstrains(0, 0, 2, 2, 3, 3, GridBagConstraints.BOTH); // Position und Größe des Dartboards
	     this.add(board, screenDivisionConstraints); // Dartboard hinzufügen
	        
	     sideBar = new JPanel();
	     this.setScreenDivisionConstrains(2, 0, 1, 1, 1, 1, GridBagConstraints.BOTH); // Position und Größe des Buttons
	     this.add(sideBar, screenDivisionConstraints); // Button hinzufügen

	        
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
