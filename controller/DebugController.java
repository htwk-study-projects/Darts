package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

public class DebugController {
	
	 private view.DebugScreenInterface debugScreenInterface;
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
		this.debugScreenInterface = debug;
		this.debugScreenSideBar = debugScreenInterface.getDebugScreenSideBar();
		this.data = data;
		
		debugScreenInterface.getDebugScreenSideBar().getPlaceDistanceAngleButton().addActionListener(e->writeDistanceAndAngle());
		debugScreenInterface.getDebugScreenSideBar().getPlaceVectorButton().addActionListener(e->writeVectors());
		debugScreenInterface.getDebugScreenSideBar().getCreatePlayerButton().addActionListener(e->displayPointsAndWriteSetup());

	}
	
	public void writeVectors() {
		readVectors();
		
		double [] vectorArray = {vectorXInput, vectorYInput, vectorZInput};
		data.currentPlayerTakeTurn(vectorArray);
		
		int points = data.getCurrentPlayer().getCurrentThrowPoints();
		updateDisplayPoints();
		
		popUpNotificationVectors(vectorXInput,vectorYInput,vectorZInput,points);
		if(data.getCurrentPlayer().getStatusFinish()) popUpNotificationFinish();
		
	}
	
	public void writeDistanceAndAngle() {
		readDistanceAndAngle();
		
		int points = model.DartboardMathModel.determinePoints(angleInput,distanceInput);
		popUpNotificationAngleAndDistance(angleInput,distanceInput,points);
		
	}
	
	public void writeGameSetupAndPoints() {
		readGameSetupAndPoints();
		data.setGameMode(pointsInput, selectButtonString, selectButtonString);
		model.Player.createPlayer(new String [] {"DebugPlayer"}, new Color [] {Color.red}, pointsInput);
		data.setPlayers(new String [] {"DebugPlayer"}, new Color [] {Color.red}, pointsInput);
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
		String pointsString = debugScreenSideBar.getPlayerPointsTextField().getText();
		pointsInput = Integer.parseInt(pointsString);
	}
	
	
	public void readDistanceAndAngle() {
		readDistance();
		readAngle();
	}
	
	public void readDistance() {
		String distanceString = debugScreenSideBar.getDistanceTextField().getText();
		distanceInput = Double.parseDouble(distanceString);
	}
	
	public void readAngle() {
		String angleString = debugScreenSideBar.getAngleTextField().getText();
		angleInput = Integer.parseInt(angleString);
	}
	
	public void readVectors() {
		readVectorX();
		readVectorY();
		readVectorZ();
	}
	
	public void readVectorX() {
		String vectorXString = debugScreenSideBar.getVectorXTextField().getText();
		vectorXInput = Double.parseDouble(vectorXString);
	}
	
	public void readVectorY() {
		String vectorYString = debugScreenSideBar.getVectorYTextField().getText();
		vectorYInput = Double.parseDouble(vectorYString);
	}
	
	public void readVectorZ() {
		String vectorZString = debugScreenSideBar.getVectorZTextField().getText();
		vectorZInput = Double.parseDouble(vectorZString);
		
	}
	
	public void displayPointsAndWriteSetup() {
		writeGameSetupAndPoints();
		displayPoints();
	}
	
	public void displayPoints() {
    	String points = debugScreenSideBar.getPlayerPointsTextField().getText();
    	debugScreenInterface.getDebugScreenSideBar().getDisplayPointsLabel().setText("Erstellter Spieler mit: " + points + " Punkten");
    }
	
	public void updateDisplayPoints() {
		int points = data.getCurrentPlayer().getPlayerPoints();
		debugScreenInterface.getDebugScreenSideBar().getDisplayPointsLabel().setText("Punkte übrig: " + points);
	}
	
	private void popUpNotificationVectors(double vectorX,double vectorY, double vectorZ,int points) {
		String ergebnis = "Für die Vektoren X: " + vectorX + " Y: " +vectorY + " Z: "+ vectorZ + " erhält man: " + points + " Punkte.";
		JOptionPane.showMessageDialog(null, ergebnis, "Berechnungsergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void popUpNotificationAngleAndDistance(int angle, double distance, int points) {
		String ergebnis = "Dein Ergebnis für die Distance: "+distance + " und dem Winkel: "+angle+ " beträgt: " + points + " Punkte.";
		JOptionPane.showMessageDialog(null, ergebnis, "Berechnungsergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void popUpNotificationFinish() {
		JOptionPane.showMessageDialog(null, "Du hast Geweonnen!", "GEWONNEN!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}