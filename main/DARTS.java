package main;

import controller.DartsController;

public class DARTS {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);	
		model.Throw dartThrow = new model.Throw(23.7, 10.0, 10.0);
        double distance = dartThrow.computeDistanceToDartBoardCenter();
        System.out.println("Abstand zum Mittelpunkt der Dartscheibe: " + distance + " cm");
        int angle = dartThrow.computeAngleOnDartBoard();
        System.out.println("Winkel: " + angle + "°");
        model.DartboardMathModel board = dartsGame.getData().getBoard();
        int points = board.determinePoints(angle, distance);
        System.out.println("Punkte: " + points);
	}

}
