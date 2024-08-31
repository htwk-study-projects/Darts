package controller;

import java.awt.CardLayout;

import view.DartsGUIInterface;

public class DartsController {
	
	private view.DartsGUIInterface userView;
	private model.DartsGameData data;
	
	private CardLayout cardLayout;
	
	private SetupController setupController;
	private PlayerSetupController playerSetupController;
	private GameController gameController;
	private DebugController debugController;
	
	public DartsController() {
		this.userView = new view.DartsGUI();		
		this.cardLayout = userView.getCardLayout();
		this.data = new model.DartsGameData();
		
		this.setupController = new SetupController(userView.getSetupScreen(), userView.getPlayerSetupScreen(), data, cardLayout);
		this.playerSetupController = new PlayerSetupController(userView.getPlayerSetupScreen(), userView.getGameScreen(), data, cardLayout);
		this.gameController = new GameController(userView.getGameScreen(), data, cardLayout);
		this.debugController = new DebugController(userView.getDebugScreen(),data);
		
		userView.getHomeScreen().getPlayButton().addActionListener(e -> resetDataAndNavigateSetupScreen());
		userView.getHomeScreen().getDebugButton().addActionListener(e -> resetForDebug());
	}

	public DartsGUIInterface getUserView() {
		return userView;
	}
	
	private void resetDataAndNavigateSetupScreen() {
		this.data.resetData();
		cardLayout.show(userView.getContentPane(), "setup");
	}
	
	private void resetForDebug() {
		this.data.resetData();
		cardLayout.show(userView.getContentPane(), "debug");
	}
	
}
