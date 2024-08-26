package controller;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class GameController{
	
	private view.GameScreenInterface screenToControl;
	private model.DartsGameData data;	
	private CardLayout cardLayout;
	
	private JPanel dartArrowPanel;
	private view.GameScreenCurrentPlayerPanel currentPlayerPanel;
	//mauszeiger als startpunkt von wo aus der pfeil gemalt wird nehmen
	//dann per mousemotionlistener verschiebbar, ändernung zum ausgangspunkt als y und z koordinaten für den WurfVektor
	// auftreffpunkt werte für grafik skalieren und dort x zeichnen
	
	public GameController(view.GameScreenInterface game, model.DartsGameData data, CardLayout cardLayout) {
		this.screenToControl = game;
		this.data = data;
		this.cardLayout = cardLayout;
		//this.dartArrowPanel = game.getD
		this.currentPlayerPanel = game.getGameScreenSideBar().getPlayerPanel();
		
	}

	
	private void updateCurrentPlayerPanel() {
		//currentPlayerPanel.setLabelTexts(data.getCurrentPlayer().getName());
	}
}
