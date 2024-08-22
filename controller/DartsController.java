package controller;



public class DartsController {
	
	private view.DartsGUI userView;
	private model.DartsGameData data;
	
	
	
	public DartsController() {
		//data = new model.DartsGameData();
		userView = new view.DartsGUI(data);
		
	}

	public view.DartsGUI getUserView() {
		return userView;
	}

	public model.DartsGameData getData() {
		return data;
	}
	
	

}
