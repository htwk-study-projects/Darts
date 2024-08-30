package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GameController extends MouseAdapter{
	
	private view.GameScreenInterface screenToControl;
	private view.DartArrowGraphic dartArrowPanel;
	private view.DartBoardGraphic dartBoardPanel;
	private view.GameScreenCurrentPlayerPanel currentPlayerPanel;
	private view.ThrowStrengthInputPanel throwStrengthPanel;
	private CardLayout cardLayout;
	
	private JButton homeWinnerButton = new JButton("Back zum Startbildschirm");
	private JDialog dialog = new JDialog();
	
	
	private model.DartsGameData data;	
	
	public GameController(view.GameScreenInterface game, model.DartsGameData data, CardLayout cardLayout) {
		this.screenToControl = game;
		this.data = data;
		this.cardLayout = cardLayout;
		this.dartArrowPanel = game.getDartArrow();
		this.dartBoardPanel = game.getBoard();
		this.currentPlayerPanel = game.getGameScreenSideBar().getPlayerPanel();
		this.currentPlayerPanel.resetThrowLabels();
		this.throwStrengthPanel = game.getGameScreenSideBar().getStrengthInput();
		
		this.dartArrowPanel.addMouseListener(this);
        this.dartArrowPanel.addMouseMotionListener(this);
        
        homeWinnerButton.addActionListener(e->popUpNotificationWinnercloseDialog());
		
	}
	
	private void updateCurrentPlayerData() {	
		model.Player currentPlayer = data.getCurrentPlayer();
		Color currentPlayerColor = currentPlayer.getColor();
		int[] currentPlayerThrowPoints = {currentPlayer .getPlayerDarts()[0].getPoints(), currentPlayer .getPlayerDarts()[1].getPoints(), currentPlayer.getPlayerDarts()[2].getPoints()};
		
		currentPlayerPanel.setLabelTexts(currentPlayer.getName(), currentPlayerColor, data.getTurnCount(), currentPlayerThrowPoints);
		throwStrengthPanel.resetCharging();
		throwStrengthPanel.setInputColor(currentPlayerColor);
		screenToControl.getDartArrow().setColorFeatherAndHolder(currentPlayerColor );
		screenToControl.getBoard().setColorHit(currentPlayerColor );
		System.out.print(data.getCurrentPlayer().getStatusFinish());
		popUpNotificationWinner();
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
            resetDisplayedPlayerDataIfNecessary();
            dartArrowPanel.setMouseXY(dartArrowPanel.getWidth() / 2, dartArrowPanel.getHeight() / 2);
        }
        if(dartArrowPanel.isShouldRead()) {
            dartArrowPanel.setShouldDraw(false);
            dartArrowPanel.setShouldPlace(true);
            dartArrowPanel.setShouldRead(false);
            
            double[] readThrowParameters = readAndScaleThrowParameters();
            data.currentPlayerTakeTurn(readThrowParameters);
            this.dartBoardPanel.setDartHitCoordinates(data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[1], data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[2]);
            updateCurrentPlayerData();
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
    
    private double[] readAndScaleThrowParameters() {
    	final double distanceToDartBoard = 237.0;
    	final double radiusMathDartBoard = 170.0;
    	
    	double xComponentForThrow = throwStrengthPanel.getCurrentStrength();
    	if (xComponentForThrow == 0) xComponentForThrow = 1;
    	double scalingFactor = (radiusMathDartBoard * 2.0) / (double)screenToControl.getBoard().getAdjustedBoardDiameters()[2];
    	double yPostponementForThrow = (dartArrowPanel.getXPostponement() * scalingFactor) / (distanceToDartBoard / xComponentForThrow);
    	double zPostponementForThrow = (dartArrowPanel.getYPostponement() * scalingFactor) / (distanceToDartBoard / xComponentForThrow);
    	
    	xComponentForThrow  += addRandomDeviation(xComponentForThrow);
    	yPostponementForThrow += addRandomDeviation(yPostponementForThrow);
    	zPostponementForThrow += addRandomDeviation(zPostponementForThrow);
    	
    	return new double[] {xComponentForThrow, yPostponementForThrow, zPostponementForThrow};
    }
    
    private double addRandomDeviation(double originalValue) {
        double percentage = Math.random() * 0.07;
        double deviation = originalValue * percentage;
        
        double cosineValue = Math.cos(System.currentTimeMillis() / 1000.0);
        boolean shouldAdd = cosineValue >= 0; 

        return shouldAdd ? deviation : -deviation;
    }
    
    private void resetDisplayedPlayerDataIfNecessary() {    	
    	 if (data.getTurnCount() == 0) {
    		 dartBoardPanel.clearDartHit();
             updateCurrentPlayerData();
    		 currentPlayerPanel.resetThrowLabels();
         }
    }
    
    private void popUpNotificationWinnercloseDialog() {
    	
    	dialog.setVisible(false);
    	cardLayout.show(screenToControl.getRootPane().getContentPane(), "home");
    	
    }
    
    private void popUpNotificationWinner() {
    	
    	if(data.getCurrentPlayer().getStatusFinish()) {
    		
    	JComponent[] buttons = {homeWinnerButton};
    	String popUpWinner = "Spieler: " + data.getCurrentPlayer().getName() + " hat Gewonnen!";
    	final JOptionPane optionPane = new JOptionPane(popUpWinner,JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION,null,buttons,null);
    	dialog = optionPane.createDialog("Du hast Gewonnen!");
    	dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    	dialog.setModal(true);
    	dialog.setVisible(true);
    	
    	
    	}
    			
    }

    
}
