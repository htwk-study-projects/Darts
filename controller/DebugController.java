package controller;

import java.awt.CardLayout;

import javax.swing.JOptionPane;

public class DebugController {
	
	 private view.DebugScreenInterface debugScreenInterface;
	 private view.DebugScreenSideBar debugScreenSideBar;
	 private model.DartsGameData data;	
	 
	 
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
	}
	
	public void writeVectors() {
		readVectors();
		
		model.Throw Test = new model.Throw(vectorXInput, vectorYInput, vectorZInput);
		int angle = Test.computeAngleOnDartBoard();
		double distance = Test.computeDistanceToDartBoardCenter();
		int points = model.DartboardMathModel.determinePoints(angle, distance);
		popUpNotificationVectors(vectorXInput,vectorYInput,vectorZInput,points);
	}
	
	public void writeDistanceAndAngle() {
		readDistanceAndAngle();
		
		int points = model.DartboardMathModel.determinePoints(angleInput,distanceInput);
		popUpNotificationAngleAndDistance(angleInput,distanceInput,points);
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
		vectorXInput = Integer.parseInt(vectorXString);
	}
	
	public void readVectorY() {
		String vectorYString = debugScreenSideBar.getVectorYTextField().getText();
		vectorYInput = Integer.parseInt(vectorYString);
	}
	
	public void readVectorZ() {
		String vectorZString = debugScreenSideBar.getVectorZTextField().getText();
		vectorZInput = Integer.parseInt(vectorZString);
		
	}
	
	private void popUpNotificationVectors(double vectorX,double vectorY, double vectorZ,int points) {
		String ergebnis = "Für die Vektoren X: " + vectorX + " Y: " +vectorY + " Z: "+ vectorZ + " erhält man: " + points + " Punkte.";
		JOptionPane.showMessageDialog(null, ergebnis, "Berechnungsergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void popUpNotificationAngleAndDistance(int angle, double distance, int points) {
		String ergebnis = "Dein Ergebnis für die Distance: "+distance + " und dem Winkel: "+angle+ " beträgt: " + points + " Punkte.";
		JOptionPane.showMessageDialog(null, ergebnis, "Berechnungsergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
}