package controller;

public class SetupController{
	
	private view.SetupScreen screenToControl;
	private model.DartsGameData data;
	
	public SetupController(view.SetupScreen setup, model.DartsGameData data) {
		this.screenToControl = setup;
		this.data = data;
	}
	
	private void readGamePoints() {
		System.out.println(screenToControl.getPlayersGroup().getSelection().toString());
	}
	
	
}
