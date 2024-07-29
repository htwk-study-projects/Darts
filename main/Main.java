package main;

import java.util.Map;

import controller.DartsController;

public class Main {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);
		model.DartboardMathModel test = dartsGame.getData().getBoard();
		
		Integer points = test.determinePoints(20, 3);
		System.out.println(points);
	}

}
