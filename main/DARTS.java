package main;

import controller.DartsController;

public class DARTS {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);	
		model.DartArrow[] newDart =  model.DartArrow.createDart(1);
		newDart[0].setThrowParameter(new double[] {23.7, 5.0, 0.0});
        newDart[0].throwDart();
        System.out.println("Punkte: " + newDart[0].getPoints());
	}

}
