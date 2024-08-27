package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements GameScreenInterface{
	
	private GridBagConstraints screenDivisionConstraints = new GridBagConstraints();
	
	private JPanel boardAndArrowPanel;
	private DartBoardGraphic board;
	private DartArrowGraphic dartArrow;
	
	private GameScreenSideBar sideBar;

	protected JButton saveButton;
	protected JButton backButton;
	
	public GameScreen() {
		
		 this.setLayout(new GridBagLayout());
		 
		 boardAndArrowPanel = new JPanel();
		 boardAndArrowPanel.setLayout(new GridBagLayout());
		 boardAndArrowPanel.setOpaque(false);
		 
		 board = new DartBoardGraphic(1);
		 this.setScreenDivisionConstrains(0, 0, 3, 3, 4, 4, GridBagConstraints.BOTH);
		 boardAndArrowPanel.add(board, screenDivisionConstraints);
		 
		 //noch experiementell __________________
		 
	     
	     dartArrow = new DartArrowGraphic();
	     dartArrow.setOpaque(false);
	     this.setScreenDivisionConstrains(0, 0, 3, 3, 4, 4, GridBagConstraints.BOTH);
	     boardAndArrowPanel.add(dartArrow, screenDivisionConstraints);
	     
	     boardAndArrowPanel.setComponentZOrder(board, 1);
	     boardAndArrowPanel.setComponentZOrder(dartArrow, 0);
	     
	     //noch experiementell __________________
	     
	     this.setScreenDivisionConstrains(0, 0, 3, 3, 20, 20, GridBagConstraints.BOTH);
	     this.add(boardAndArrowPanel, screenDivisionConstraints);

	     sideBar = new GameScreenSideBar();
	     this.setScreenDivisionConstrains(3, 0, 1, 2, 1, 1, GridBagConstraints.BOTH);
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

	@Override
	public GameScreenSideBar getGameScreenSideBar() {
		return sideBar;
	}

	@Override
	public DartArrowGraphic getDartArrow() {
		return dartArrow;
	}
	
}
