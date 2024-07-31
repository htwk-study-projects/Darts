package main;

import controller.DartsController;

public class Main {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);
		model.DartboardMathModel test = dartsGame.getData().getBoard();
		//test.printFieldValueRelations();
		Integer sector = test.determineSector(90);
		Integer multiplier = test.determineMultiplier(104.0);
		Integer points = test.determinePoints(sector, multiplier);
		System.out.println(points);
	}

}
