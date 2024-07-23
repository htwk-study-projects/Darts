package controller;



public class DartsController {
	
	private view.DartsGUI userView;
	private model.DartsData data;
	
	
	
	public DartsController() {
		data = new model.DartsData();
		userView = new view.DartsGUI(data);
		
	}

	public view.DartsGUI getUserView() {
		return userView;
	}

}
