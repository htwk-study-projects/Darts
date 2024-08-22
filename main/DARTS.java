package main;

import javax.swing.JFrame;

import controller.DartsController;

public class DARTS {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);	
        
        
		model.DartArrow[] newDart =  model.DartArrow.createDart(1);
		newDart[0].setThrowParameter(new double[] {23.7, 5.0, 50.0});
        System.out.println("Punkte: " + newDart[0].getPoints());

	}

}
