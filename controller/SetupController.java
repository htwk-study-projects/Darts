package controller;

import java.awt.CardLayout;

import javax.swing.ButtonModel;
import javax.swing.JComponent;

public class SetupController{
	
    private view.SetupScreenInterface screenToControl;
    private view.PlayerSetupScreenInterface screenToAdjustDisplay;
	private model.DartsGameData data;	
	private CardLayout cardLayout;
	
	private int selectedPlayerCount;
	private int selectedGamePoints;
	private String selectedInMode;
	private String selectedOutMode;
	
	private static final String PLAYER_SETUP_PANEL = "player";
	
	
	public SetupController(view.SetupScreenInterface setup, view.PlayerSetupScreenInterface adjustDisplay , model.DartsGameData data, CardLayout cardLayout) {
		this.screenToControl = setup;
		this.screenToAdjustDisplay = adjustDisplay;
		this.data = data;
		this.cardLayout = cardLayout;
		
		screenToControl.getStartButton().addActionListener(e -> initGameSetup());
	}
	
	private void initGameSetup() {
		readGameSetup();
		writeGameSetup();
		screenToAdjustDisplay.getPlayerNameInput().setChoosenPlayers(selectedPlayerCount);
		cardLayout.show(screenToControl.getRootPane().getContentPane(), PLAYER_SETUP_PANEL);
		System.out.println(data.getGameMode().toString());
	}
	
	private void writeGameSetup() {
		data.setPlayerCount(selectedPlayerCount);
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
		  selectedGamePoints = Integer.parseInt(selectedButton.getActionCommand());

	}
	
	private void readModeIn() {
		  ButtonModel selectedButton = screenToControl.getModeInGroup().getSelection();
		  selectedInMode = selectedButton.getActionCommand();
	}
	
	private void readModeOut() {
		  ButtonModel selectedButton = screenToControl.getModeOutGroup().getSelection();
		  selectedOutMode = selectedButton.getActionCommand();
	}
	
	private void readPlayerCount() {
		  ButtonModel selectedButton = screenToControl.getPlayersGroup().getSelection();
		  selectedPlayerCount = Integer.parseInt(selectedButton.getActionCommand());
	}
}
