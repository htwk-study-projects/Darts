package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.ColorIcon;

public class PlayerSetupController {
	
	private view.PlayerSetupScreenInterface screenToControl;
    private view.GameScreenInterface screenToAdjustDisplay;
	private model.DartsGameData data;	
	private CardLayout cardLayout;
	
	private String[] playerNames;
	private Color[] playerColors;
	private String gameName;
	
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
	    updateNextScreen();

	    boolean textFieldsAreValid = textFieldFullfillmentCondition();
	    boolean colorsAreValid = colorPlayerFullfilmentCondition();

	    if (textFieldsAreValid && colorsAreValid ) cardLayout.show(screenToControl.getRootPane().getContentPane(), "game");
	    if (!textFieldsAreValid) popUpNotificationTextField();
	    if (!colorsAreValid) popUpNotificationColorPlayer();
	}

	private void updateNextScreen() {
		screenToAdjustDisplay.getGameScreenSideBar().setGameNameLabel(gameName + " " + data.getGameMode());
	    screenToAdjustDisplay.getGameScreenSideBar().setPlayerTableData(data.preparePlayerDataForTable());
	    screenToAdjustDisplay.getGameScreenSideBar().getPlayerPanel().setLabelTexts("", null, 0, new int[3]);
	    screenToAdjustDisplay.getGameScreenSideBar().getPlayerPanel().resetThrowLabels();
	    screenToAdjustDisplay.getBoard().clearDartHit();

	}
	
	
	private void writePlayerSetup() {
		this.data.setGameName(gameName);
		this.data.setPlayers(playerNames, playerColors, data.getGameMode().getGamePoints());
	}
	
	private void readPlayerSetup() {
		readGameName();
		readPlayerNames();
		readPlayerColors();
	}
	
	private void readGameName() {
		gameName = screenToControl.getPlayerNameInput().getGameNameField().getText();
	}
	
	private void readPlayerNames() {
		JTextField[] nameInputs =  screenToControl.getPlayerNameInput().getNameInputs();	
		this.playerNames = new String[this.data.getPlayerCount()];
		for(int i=0; i< playerNames.length; i++) {
			playerNames[i] = nameInputs[i].getText();
		}
	}
	
	private boolean textFieldFullfillmentCondition() {
		for(int i=0; i< playerNames.length; i++) {			
			if(playerNames[i].isEmpty()) return false;
		}
		if(gameName.isEmpty()) return false;	
		return true;	
	}
		
	private void popUpNotificationTextField() {
		JOptionPane.showMessageDialog(null, "Bitte fuell alle Textfelder aus!", "WICHTIGER HINWEIS!", JOptionPane.ERROR_MESSAGE);
	}
	
	private void readPlayerColors() {
		JComboBox<view.ColorIcon>[] colorInputs =  screenToControl.getPlayerNameInput().getColorInputs();
		this.playerColors = new Color[this.data.getPlayerCount()];
		for(int i=0; i< playerNames.length; i++) {
			view.ColorIcon selectedColorIcon = (ColorIcon) colorInputs[i].getSelectedItem();
			playerColors[i] = selectedColorIcon.getColor();
		}
	}
	
	private boolean colorPlayerFullfilmentCondition() {
	    Set<Color> uniqueColors = new HashSet<>();
	    for (int i = 0; i < playerColors.length; i++) {
	            if (!uniqueColors.add(playerColors[i])) return false ;
	    }
	    return true;
	}
	
	private void popUpNotificationColorPlayer() {
		JOptionPane.showMessageDialog(null, "Bitte waehl unterschiedliche Farben aus!", "WICHTIGER HINWEIS!", JOptionPane.ERROR_MESSAGE);
	}
	
	
}
