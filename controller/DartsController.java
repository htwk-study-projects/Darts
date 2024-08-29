package controller;

import java.awt.CardLayout;

public class DartsController {
	
	private view.DartsGUI userView;
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
		this.debugController = new DebugController(userView.getDebugScreen(),data);
		
		userView.getHomeScreen().getPlayButton().addActionListener(e -> initDataAndController());
		userView.getHomeScreen().getDebugButton().addActionListener(e -> resetForDebug());
	}

	public view.DartsGUI getUserView() {
		return userView;
	}
	
	public model.DartsGameData getData(){
		return data;
	}
	
	private void initDataAndController() {
		this.data.resetData();
		this.setupController = new SetupController(userView.getSetupScreen(), userView.getPlayerSetupScreen(), data, cardLayout);
		this.playerSetupController = new PlayerSetupController(userView.getPlayerSetupScreen(), userView.getGameScreen(), data, cardLayout);
		this.gameController = new GameController(userView.getGameScreen(), data, cardLayout);
		cardLayout.show(userView.getContentPane(), "setup");
	}
	
	private void resetForDebug() {
		this.data.resetData();
		cardLayout.show(userView.getContentPane(), "debug");
	}
	
}
