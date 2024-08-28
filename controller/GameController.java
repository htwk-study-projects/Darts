package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameController extends MouseAdapter{
	
	private view.GameScreenInterface screenToControl;
	private view.DartArrowGraphic dartArrowPanel;
	private view.DartBoardGraphic dartBoardPanel;
	private view.GameScreenCurrentPlayerPanel currentPlayerPanel;
	private CardLayout cardLayout;
	
	private model.DartsGameData data;	
	
	public GameController(view.GameScreenInterface game, model.DartsGameData data, CardLayout cardLayout) {
		this.screenToControl = game;
		this.data = data;
		this.cardLayout = cardLayout;
		this.dartArrowPanel = game.getDartArrow();
		this.dartBoardPanel = game.getBoard();
		this.currentPlayerPanel = game.getGameScreenSideBar().getPlayerPanel();
		this.currentPlayerPanel.setLabelTexts("", Color.black, "", "", "");
		
		this.dartArrowPanel.addMouseListener(this);
        this.dartArrowPanel.addMouseMotionListener(this);
		
	}

	
	private void updateCurrentPlayerPanel() {
		System.out.println(data + " " +"Updating panel for player: " + data.getCurrentPlayer().getName() + " " + data.getCurrentPlayer().getColor() + " " + data.getCurrentPlayer().getPlayerDarts()[0].getPoints().toString()
				+ " " + data.getCurrentPlayer().getPlayerDarts()[1].getPoints().toString() + " " +
				 data.getCurrentPlayer().getPlayerDarts()[2].getPoints().toString());
		currentPlayerPanel.setLabelTexts(data.getCurrentPlayer().getName(), data.getCurrentPlayer().getColor(), 
										 data.getCurrentPlayer().getPlayerDarts()[0].getPoints().toString(),
										 data.getCurrentPlayer().getPlayerDarts()[1].getPoints().toString(),
										 data.getCurrentPlayer().getPlayerDarts()[2].getPoints().toString());
	}
	
	private void updatePlayerTable() {
		screenToControl.getGameScreenSideBar().setPlayerTableData(data.preparePlayerDataForTable());
	}
	
	@Override
    public void mouseDragged(MouseEvent e) {
        if(dartArrowPanel.isShouldDraw()) {
            dartArrowPanel.setMouseX(e.getX());
            dartArrowPanel.setMouseY(e.getY());
            dartArrowPanel.setShouldDraw(true);
            dartArrowPanel.setShouldPlace(false);
            dartArrowPanel.setShouldRead(true);
            dartArrowPanel.repaint();
        }
    }
	
	//Problem, bei erstellen eines weiteren spiels nach dem ersten funktioniert das playerpanel nicht mehr

    @Override
    public void mouseClicked(MouseEvent e) {
        if(dartArrowPanel.isShouldPlace()){
            dartArrowPanel.setShouldDraw(true);
            dartArrowPanel.setShouldPlace(false);
            updateCurrentPlayerPanel();
            dartArrowPanel.setMouseX(dartArrowPanel.getWidth() / 2);
            dartArrowPanel.setMouseY(dartArrowPanel.getHeight() / 2);
            dartArrowPanel.repaint();
        }
        if(dartArrowPanel.isShouldRead()) {
            dartArrowPanel.setShouldDraw(false);
            dartArrowPanel.setShouldPlace(true);
            dartArrowPanel.setShouldRead(false);
            System.out.println(data);
            System.out.println(dartArrowPanel.getMouseX() + " " + dartArrowPanel.getMouseY());
            data.getCurrentPlayer().playerThrowCurrentDart(new double[] {23.7, dartArrowPanel.getXPostponement(), dartArrowPanel.getYPostponement()});
            data.getCurrentPlayer().setStatusPlayIn(data.getGameMode().isGameInModeConditionFulfilled(data.getCurrentPlayer().getCurrentThrowMultiplier()));
            data.getCurrentPlayer().setStatusPlayOut(data.getGameMode().isGameOutModeConditionFulfilled(data.getCurrentPlayer().getCurrentThrowMultiplier()));
            data.getCurrentPlayer().setStatusCanFinish(data.getGameMode().arePointValidForOutMode(data.getCurrentPlayer().getPlayerPoints(), data.getCurrentPlayer().getCurrentThrowPoints()));      
            data.getCurrentPlayer().updatePlayerPoints();
            System.out.println(data.getCurrentPlayer());
            updateCurrentPlayerPanel();
            updatePlayerTable();
            data.nextTurnPlayer();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        dartArrowPanel.setShouldPlace(true);
        dartArrowPanel.setShouldDraw(false);
        dartArrowPanel.setShouldRead(false);
    }
}
