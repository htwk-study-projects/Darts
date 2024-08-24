package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import view.ColorIcon;

public class PlayerSetupController {
	
	private view.PlayerSetupScreenInterface screenToControl;
    private view.GameScreenInterface screenToAdjustDisplay;
	private model.DartsGameData data;	
	private CardLayout cardLayout;
	
	private String[] playerNames;
	private Color[] playerColors;
	
	public PlayerSetupController(view.PlayerSetupScreenInterface playerSetup, view.GameScreenInterface adjustDisplay, model.DartsGameData data, CardLayout cardLayout) {
		this.screenToControl = playerSetup;
		this.screenToAdjustDisplay = adjustDisplay;
		this.data = data;
		this.cardLayout = cardLayout;
		
		screenToControl.getPlayButton().addActionListener(e -> initPlayerSetup());
	}
	
	
	private void initPlayerSetup() {
		readPlayerSetup();
		writePlayerSetup();
		cardLayout.show(screenToControl.getRootPane().getContentPane(), "game");
		System.out.println(Arrays.toString(data.getPlayers()));
	}
	
	private void writePlayerSetup() {
		this.data.setPlayers(playerNames, playerColors, data.getGameMode().getGamePoints());
	}
	
	private void readPlayerSetup() {
		readPlayerNames();
		readPlayerColors();
	}
	
	private void readPlayerNames() {
		JTextField[] nameInputs =  screenToControl.getPlayerNameInput().getNameInputs();	
		this.playerNames = new String[this.data.getPlayerCount()];
		for(int i=0; i< playerNames.length; i++) {
			playerNames[i] = nameInputs[i].getText();
		}
	}
	
	private void readPlayerColors() {
		JComboBox<view.ColorIcon>[] colorInputs =  screenToControl.getPlayerNameInput().getColorInputs();
		this.playerColors = new Color[this.data.getPlayerCount()];
		for(int i=0; i< playerNames.length; i++) {
			view.ColorIcon selectedColorIcon = (ColorIcon) colorInputs[i].getSelectedItem();
			playerColors[i] = selectedColorIcon.getColor();
		}
	}
}
