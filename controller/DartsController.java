package controller;



public class DartsController {
	
	private view.DartsGUI userView;
	private model.DartsGameData data;
	
	private StartController startController;
	private SetupController setupController;
	private GameController gameController;
	
	public DartsController() {
		userView = new view.DartsGUI(data);
		this.startController = new StartController();
	}
	
	public SetupController goIntoSetup() {
		this.setupController = new SetupController();
		
	}
	
	
	
	
	
	
	
	
	
	

	public view.DartsGUI getUserView() {
		return userView;
	}

	public model.DartsGameData getData() {
		return data;
	}

	public SetupController getSetupController() {
		return setupController;
	}

	public void setSetupController(SetupController setupController) {
		this.setupController = setupController;
	}

	public GameController getGameController() {
		return gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	

	
}
