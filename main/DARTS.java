package main;

import javax.swing.JFrame;

import controller.DartsController;
import view.DartArrowGraphic;

public class DARTS {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);	
<<<<<<< HEAD
		model.Throw dartThrow = new model.Throw(23.7, 10.0, 10.0);
        double distance = dartThrow.computeDistanceToDartBoardCenter();
        System.out.println("Abstand zum Mittelpunkt der Dartscheibe: " + distance + " cm");
        int angle = dartThrow.computeAngleOnDartBoard();
        System.out.println("Winkel: " + angle + "°");
        model.DartboardMathModel board = dartsGame.getData().getBoard();
        int points = board.determinePoints(angle, distance);
        System.out.println("Punkte: " + points);
        
        
=======
		model.Dart[] newDart =  model.Dart.createDart(1);
		newDart[0].setThrowParameter(new double[] {23.7, 5.0, 50.0});
        newDart[0].throwDart();
        System.out.println("Punkte: " + newDart[0].getPoints());
>>>>>>> refs/remotes/origin/prod
	}

}
