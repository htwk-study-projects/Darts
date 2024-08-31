package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

public class DebugController extends MouseAdapter {
	
	private view.DebugScreenInterface screenToControl;
	private view.DartArrowGraphic debugArrow;
	private view.DartBoardGraphic debugBoard;
	
	private view.DebugScreenSideBar debugScreenSideBar;
	private model.DartsGameData data;	
	
	private int pointsInput;
	private ButtonModel selectedButton;
	private String selectButtonString;
	
	private double distanceInput;
	private int angleInput;
	
	private double vectorXInput;
	private double vectorYInput;
	private double vectorZInput;
	
	public DebugController(view.DebugScreenInterface debug, model.DartsGameData data) {
		this.screenToControl = debug;
		this.data = data;
		this.debugScreenSideBar = debug.getDebugScreenSideBar();
		this.debugArrow = debug.getDartArrowGraphic();
		this.debugBoard = debug.getBoard();
		this.debugArrow.addMouseListener(this);
        this.debugArrow.addMouseMotionListener(this);
		
        screenToControl.getDebugScreenSideBar().getPlaceDistanceAngleButton().addActionListener(e -> writeDistanceAndAngle());
        screenToControl.getDebugScreenSideBar().getPlaceVectorButton().addActionListener(e -> writeVectors());
        screenToControl.getDebugScreenSideBar().getCreatePlayerButton().addActionListener(e -> displayPointsAndWriteSetup());
	}
	
	public void writeVectors() {
		readVectors();
		
		double[] vectorArray = {vectorXInput, vectorYInput, vectorZInput};
		data.currentPlayerTakeTurn(vectorArray);
		
		int points = data.getCurrentPlayer().getCurrentThrowPoints();
		updateDisplayPoints();
		
		popUpNotificationVectors(vectorXInput, vectorYInput, vectorZInput, points);
		if (data.getCurrentPlayer().getStatusFinish()) popUpNotificationFinish();
	}
	
	public void writeDistanceAndAngle() {
		readDistanceAndAngle();
		
		int points = model.DartboardMathModel.determinePoints(angleInput, distanceInput);
		popUpNotificationAngleAndDistance(angleInput, distanceInput, points);
	}
	
	public void writeGameSetupAndPoints() {
		readGameSetupAndPoints();
		data.setGameMode(pointsInput, selectButtonString, selectButtonString);
		model.Player.createPlayer(new String[]{"DebugPlayer"}, new Color[]{Color.GRAY}, pointsInput);
		data.setPlayers(new String[]{"DebugPlayer"}, new Color[]{Color.GRAY}, pointsInput);
		screenToControl.getDartArrowGraphic().setColorFeatherAndHolder(data.getCurrentPlayer().getColor());
		screenToControl.getBoard().setColorHit(data.getCurrentPlayer().getColor());
	}
	
	public void readGameSetupAndPoints() {
		readGameSetup();
		readPoints();
	}
	
	public void readGameSetup() {
		ButtonModel selectedButton = debugScreenSideBar.getModeRadioButton().getSelection();
		selectButtonString = selectedButton.getActionCommand();
	}
	
	public void readPoints() {
		try {
			String pointsString = debugScreenSideBar.getPlayerPointsTextField().getText();
			pointsInput = Integer.parseInt(pointsString);
		} catch (NumberFormatException e) {
		}
	}
	
	public void readDistanceAndAngle() {
		readDistance();
		readAngle();
	}
	
	public void readDistance() {
		try {
			String distanceString = debugScreenSideBar.getDistanceTextField().getText();
			distanceInput = Double.parseDouble(distanceString);
		} catch (NumberFormatException e) {
		}
	}
	
	public void readAngle() {
		try {
			String angleString = debugScreenSideBar.getAngleTextField().getText();
			angleInput = Integer.parseInt(angleString);
		} catch (NumberFormatException e) {
		}
	}
	
	public void readVectors() {
		readVectorX();
		readVectorY();
		readVectorZ();
	}
	
	public void readVectorX() {
		try {
			String vectorXString = debugScreenSideBar.getVectorXTextField().getText();
			vectorXInput = Double.parseDouble(vectorXString);
		} catch (NumberFormatException e) {
			System.out.print("Test");
		}
	}
	
	public void readVectorY() {
		try {
			String vectorYString = debugScreenSideBar.getVectorYTextField().getText();
			vectorYInput = Double.parseDouble(vectorYString);
		} catch (NumberFormatException e) {
		}
	}
	
	public void readVectorZ() {
		try {
			String vectorZString = debugScreenSideBar.getVectorZTextField().getText();
			vectorZInput = Double.parseDouble(vectorZString);
		} catch (NumberFormatException e) {
		}
	}
	
	public void displayPointsAndWriteSetup() {
		writeGameSetupAndPoints();
		displayPoints();
	}
	
	public void displayPoints() {
		String points = debugScreenSideBar.getPlayerPointsTextField().getText();
		screenToControl.getDebugScreenSideBar().getDisplayPointsLabel().setText("Erstellter Spieler mit: " + points + " Punkten");
	}
	
	public void updateDisplayPoints() {
		int points = data.getCurrentPlayer().getPlayerPoints();
		screenToControl.getDebugScreenSideBar().getDisplayPointsLabel().setText("Punkte übrig: " + points);
	}
	
	private void popUpNotificationVectors(double vectorX, double vectorY, double vectorZ, int points) {
		String ergebnis = "Für die Vektoren X: " + vectorX + " Y: " + vectorY + " Z: " + vectorZ + " erhält man: " + points + " Punkte.";
		JOptionPane.showMessageDialog(null, ergebnis, "Berechnungsergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void popUpNotificationAngleAndDistance(int angle, double distance, int points) {
		String ergebnis = "Dein Ergebnis für die Distance: " + distance + " und dem Winkel: " + angle + " beträgt: " + points + " Punkte.";
		JOptionPane.showMessageDialog(null, ergebnis, "Berechnungsergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void popUpNotificationFinish() {
		JOptionPane.showMessageDialog(null, "Du hast gewonnen!", "GEWONNEN!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (debugArrow.isShouldDraw()) {
			debugArrow.setShouldDraw(true);
			debugArrow.setShouldPlace(false);
			debugArrow.setShouldRead(true);
			debugArrow.setMouseXY(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (debugArrow.isShouldPlace()) {
			debugArrow.setShouldDraw(true);
			debugArrow.setShouldPlace(false);
			debugArrow.setMouseXY(debugArrow.getWidth() / 2, debugArrow.getHeight() / 2);
		}
		if (debugArrow.isShouldRead()) {
			debugArrow.setShouldDraw(false);
			debugArrow.setShouldPlace(true);
			debugArrow.setShouldRead(false);
			
			double[] readThrowParameters = readAndScaleThrowParameters();
			data.currentPlayerTakeTurn(readThrowParameters);
			this.debugBoard.setDartHitCoordinates(data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[1], data.getCurrentPlayer().getCurrentImpactPoint().getVectorComponents()[2]);
			updateDisplayPoints();
			data.nextTurnPlayer();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		debugArrow.setShouldPlace(true);
		debugArrow.setShouldDraw(false);
		debugArrow.setShouldRead(false);
	}
	
	private double[] readAndScaleThrowParameters() {
		double scalingFactor = (170.0 * 2.0) / (double) screenToControl.getBoard().getAdjustedBoardDiameters()[2];
		double yPostponementForThrow = (debugArrow.getXPostponement() * scalingFactor) / (237.0 / 23.7);
		double zPostponementForThrow = (debugArrow.getYPostponement() * scalingFactor) / (237.0 / 23.7);
		
		return new double[]{23.7, yPostponementForThrow, zPostponementForThrow};
	}
}
