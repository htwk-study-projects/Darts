package controller;



public class DartsController {
	
	private view.DartsGUI userView;
	private model.DartsGameData data;
	
	private SetupController setupController;
	private PlayerSetupController playerSetupController;
	private GameController gameController;
	
	public DartsController() {
		this.userView = new view.DartsGUI();
		this.data = new model.DartsGameData();
		
		this.setupController = new SetupController(userView.getSetupScreen(), data);
		this.playerSetupController = new PlayerSetupController(userView.getSetPlayerScreen());
		this.gameController = new GameController(userView.getGameScreen());
	}

	public view.DartsGUI getUserView() {
		return userView;
	}
}
