package controller;



public class Darts {
	
	private view.DartsGUI userView;
	private model.DartsData data;
	
	
	
	public Darts() {
		data = new model.DartsData();
		userView = new view.DartsGUI(data);
		
	}
	
	
	
	public static void main(String[] args) {
		
		Darts dartsGame = new Darts();
		System.out.println("Das wird ein Darts-Spiel");
		dartsGame.userView.setVisible(true);
	}

}
