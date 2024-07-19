package controller;

import model.DartsData;
import view.DartsGUI;

public class Darts {
	
	private DartsGUI view;
	private DartsData data;
	
	
	
	public Darts() {
		data = new DartsData();
		view = new DartsGUI(data);
		
	}
	
	
	
	public static void main(String[] args) {
		
		Darts dartsGame = new Darts();
		System.out.println("Das wird ein Darts-Spiel");
		dartsGame.view.setVisible(true);
	}

}
