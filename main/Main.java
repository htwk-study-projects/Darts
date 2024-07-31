package main;

import controller.DartsController;

public class Main {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);
		model.DartboardMathModel test = dartsGame.getData().getBoard();
		//test.printFieldValueRelations();
		for(int i = 0; i< 10; i++) {
			Integer sector = test.determineSector(45);
			Integer multiplier = test.determineMultiplier(99.0);
			Integer points = test.determinePoints(sector, multiplier);
			System.out.println(points);
		}
		
	}

}
