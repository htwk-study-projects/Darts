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
	private view.ThrowStrengthInputPanel throwStrengthPanel;
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
		this.throwStrengthPanel = game.getGameScreenSideBar().getStrengthInput();
		
		this.dartArrowPanel.addMouseListener(this);
        this.dartArrowPanel.addMouseMotionListener(this);
		
	}
	
	private void updateCurrentPlayerPanel() {		
		currentPlayerPanel.setLabelTexts(data.getCurrentPlayer().getName(), data.getCurrentPlayer().getColor(), 
										 data.getCurrentPlayer().getPlayerDarts()[0].getPoints().toString(),
										 data.getCurrentPlayer().getPlayerDarts()[1].getPoints().toString(),
										 data.getCurrentPlayer().getPlayerDarts()[2].getPoints().toString());
		throwStrengthPanel.resetCharging();
		throwStrengthPanel.setInputColor(data.getCurrentPlayer().getColor());
		screenToControl.getDartArrow().setColorFeatherAndHolder(data.getCurrentPlayer().getColor());
		screenToControl.getBoard().setColorHit(data.getCurrentPlayer().getColor());
	}
	
	private void updatePlayerTable() {
		screenToControl.getGameScreenSideBar().setPlayerTableData(data.preparePlayerDataForTable());
	}
	
	@Override
    public void mouseDragged(MouseEvent e) {
        if(dartArrowPanel.isShouldDraw()) {
            dartArrowPanel.setShouldDraw(true);
            dartArrowPanel.setShouldPlace(false);
            dartArrowPanel.setShouldRead(true);
            dartArrowPanel.setMouseXY(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(dartArrowPanel.isShouldPlace()){
            dartArrowPanel.setShouldDraw(true);
            dartArrowPanel.setShouldPlace(false);
            updateCurrentPlayerPanel();
            dartArrowPanel.setMouseXY(dartArrowPanel.getWidth() / 2, dartArrowPanel.getHeight() / 2);
        }
        if(dartArrowPanel.isShouldRead()) {
            dartArrowPanel.setShouldDraw(false);
            dartArrowPanel.setShouldPlace(true);
            dartArrowPanel.setShouldRead(false);
            
            double[] readThrowParameters = readAndScaleThrowParameters();
            data.currentPlayerTakeTurn(readThrowParameters);
            this.dartBoardPanel.drawDartHit(data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[1], data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[2]);
            System.out.println(data.getCurrentPlayer());
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
    	
    	double xComponentForThrow = throwStrengthPanel.getCurrentStrength();
    	if (xComponentForThrow == 0) xComponentForThrow = 1;
    	double scalingFactor = (170.0*2.0) / (double)screenToControl.getBoard().getAdjustedBoardDiameters()[2];
    	double yPostponementForThrow = (dartArrowPanel.getXPostponement() * scalingFactor) / (237.0 / xComponentForThrow);
    	double zPostponementForThrow = (dartArrowPanel.getYPostponement() * scalingFactor) / (237.0 / xComponentForThrow);
    	
    	xComponentForThrow  += addRandomDeviation(xComponentForThrow);
    	yPostponementForThrow += addRandomDeviation(yPostponementForThrow);
    	zPostponementForThrow += addRandomDeviation(zPostponementForThrow);
    	
    	return new double[] {xComponentForThrow, yPostponementForThrow, zPostponementForThrow};
    }
    
    private double addRandomDeviation(double originalValue) {
        double percentage = Math.random() * 0.05;
        double deviation = originalValue * percentage;
        
        double cosineValue = Math.cos(System.currentTimeMillis() / 1000.0);
        boolean shouldAdd = cosineValue >= 0; 

        return shouldAdd ? deviation : -deviation;
    }
    
    private void mouseClickBreak(int time) {
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }
    
}
