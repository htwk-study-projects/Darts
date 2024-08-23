package controller;

import java.awt.CardLayout;

import javax.swing.ButtonModel;

public class SetupController{
	
	private view.SetupScreen screenToControl;
	private model.DartsGameData data;	
	private CardLayout cardLayout;
	
	private int selectedPlayerCount;
	private int selectedGamePoints;
	private String selectedInMode;
	private String selectedOutMode;
	
	
	public SetupController(view.SetupScreen setup, model.DartsGameData data, CardLayout cardLayout) {
		this.screenToControl = setup;
		this.data = data;
		this.cardLayout = cardLayout;
		
		screenToControl.getStartButton().addActionListener(e -> initGameSetup());
	}
	
	private void initGameSetup() {
		readGameSetup();
		writeGameSetup();
		cardLayout.show(screenToControl.getRootPane().getContentPane(), "player");
		System.out.println(data.getGameMode().toString());
	}
	
	private void writeGameSetup() {
		data.setGameMode(selectedGamePoints, selectedInMode, selectedOutMode);
	}
	
	private void readGameSetup() {
		readGamePoints();
		readModeIn();
		readModeOut();
		readPlayerCount();
	}
	
	private void readGamePoints() {
		  ButtonModel selectedButton = screenToControl.getPointsGroup().getSelection();
		   if (selectedButton != null) {
			   selectedGamePoints = Integer.parseInt(selectedButton.getActionCommand());
		    }
	}
	
	private void readModeIn() {
		  ButtonModel selectedButton = screenToControl.getModeInGroup().getSelection();
		   if (selectedButton != null) {
			   selectedInMode = selectedButton.getActionCommand();
		    }
	}
	
	private void readModeOut() {
		  ButtonModel selectedButton = screenToControl.getModeOutGroup().getSelection();
		   if (selectedButton != null) {
			   selectedOutMode = selectedButton.getActionCommand();
		    }
	}
	
	private void readPlayerCount() {
		  ButtonModel selectedButton = screenToControl.getPlayersGroup().getSelection();
		   if (selectedButton != null) {
		        selectedPlayerCount = Integer.parseInt(selectedButton.getActionCommand());
		    }
	}
}
