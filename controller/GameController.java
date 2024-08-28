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
            
            double[] readThrowParameters = readAndScaleThrowParameters();
            data.currentPlayerTakeTurn(readThrowParameters);
            System.out.println(data.getCurrentPlayer());
            this.dartBoardPanel.drawDartHit(data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[1], data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[2]);
            updateCurrentPlayerPanel();
            updatePlayerTable();
            data.nextTurnPlayer();
            mouseClickBreak(1000);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        dartArrowPanel.setShouldPlace(true);
        dartArrowPanel.setShouldDraw(false);
        dartArrowPanel.setShouldRead(false);
    }
    
    private double[] readAndScaleThrowParameters() {
    	double scalingFactor = (170.0*2.0) / (double)screenToControl.getBoard().getAdjustedBoardDiameters()[2];
    	double yPostponementForThrow = (dartArrowPanel.getXPostponement() * scalingFactor) / (237.0 / 23.7);
    	double zPostponementForThrow = (dartArrowPanel.getYPostponement() * scalingFactor) / (237.0 / 23.7);
    	
    	return new double[] {23.7, yPostponementForThrow, zPostponementForThrow};
    }
    
    private void mouseClickBreak(int time) {
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }
}
