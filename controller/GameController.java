package controller;

import javax.swing.JPanel;

public class GameController{
	
	private view.GameScreen screenToControl;
	
	private JPanel dartArrowPanel;
	
	//mauszeiger als startpunkt von wo aus der pfeil gemalt wird nehmen
	//dann per mousemotionlistener verschiebbar, ändernung zum ausgangspunkt als y und z koordinaten für den WurfVektor
	// auftreffpunkt werte für grafik skalieren und dort x zeichnen
	
	public GameController(view.GameScreen game ) {
		this.screenToControl = game;
	}

}
