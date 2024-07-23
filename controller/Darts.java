package controller;



public class Darts {
	
	private view.DartsGUI userView;
	private model.DartsData data;
	
	
	
	public Darts() {
		data = new model.DartsData();
		userView = new view.DartsGUI();
		
	}
	
	
	public static void main(String[] args) {
		
		Darts dartsGame = new Darts();
		dartsGame.userView.setVisible(true);
	}

}
