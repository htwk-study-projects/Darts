package controller;

import java.awt.CardLayout;

public class DartsController {
	
	private view.DartsGUI userView;
	private model.DartsGameData data;
	
	private CardLayout cardLayout;
	
	private SetupController setupController;
	private PlayerSetupController playerSetupController;
	private GameController gameController;
	
	public DartsController() {
		this.userView = new view.DartsGUI();
		this.data = new model.DartsGameData();
		this.cardLayout = userView.getCardLayout();
		if (userView.getSetupScreen() == null) {
	        System.out.println("SetupScreen ist null");
	    } else {
	        System.out.println("SetupScreen ist nicht null");
	    }
		this.setupController = new SetupController(userView.getSetupScreen(), data, cardLayout);
		this.playerSetupController = new PlayerSetupController(userView.getSetPlayerScreen());
		this.gameController = new GameController(userView.getGameScreen());
	}

	public view.DartsGUI getUserView() {
		return userView;
	}
}
