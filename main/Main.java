package main;

import controller.DartsController;

public class Main {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);
		model.DartboardMathModel test = dartsGame.getData().getBoard();
		//test.printFieldValueRelations();
		for(int i = 0; i< 200; i++) {
			Integer points = test.determinePoints(50, 0.0+i);
			System.out.println(i+ "	" +points);
		}
			
	}

}
