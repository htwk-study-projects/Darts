package main;

import java.awt.Color;

import controller.DartsController;

public class DARTS {

	public static void main(String[] args) {
		
		DartsController dartsGame = new DartsController();
		dartsGame.getUserView().setVisible(true);	
		
        model.GameMode GameMode = new model.GameMode(41,"straight","straight");
		model.Player [] Test = model.Player.createPlayer(new String[]{"Test"}, new Color[] {Color.BLUE}, GameMode.getGamePoints());
		Test[0].playerThrowCurrentDart(new double []{23.7,0,60});
		System.out.println(Test[0].getPlayerDarts()[0]);
		Test[0].setStatusPlayIn(GameMode.isGameInModeConditionFulfilled(Test[0].getCurrentThrowMultiplier()));
		Test[0].setStatusPlayOut(GameMode.isGameOutModeConditionFulfilled(Test[0].getCurrentThrowMultiplier()));
		Test[0].setStatusCanFinish(GameMode.arePointValidForOutMode(Test[0].getPlayerPoints(), Test[0].getPlayerDarts()[0].getPoints()));
		Test[0].updatePlayerPoints();
		System.out.print(Test[0]);
	}

}
