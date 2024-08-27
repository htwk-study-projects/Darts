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
	private boolean textFieldFullfilmentCondition = false;
	private boolean colorPlayerFullfilmentCondition = false;
	
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
	    screenToAdjustDisplay.getGameScreenSideBar().setPlayerTableData(data.preparePlayerDataForTabel());

	    // Setze die Label-Texte für das erste Spieler
	    screenToAdjustDisplay.getGameScreenSideBar().getPlayerPanel().setLabelTexts(
	        playerNames[0], 
	        playerColors[0], 
	        data.getPlayers()[0].getPlayerDarts()[0].getPoints().toString(),
	        data.getPlayers()[0].getPlayerDarts()[0].getPoints().toString(),
	        data.getPlayers()[0].getPlayerDarts()[0].getPoints().toString()
	    );

	    if (textFieldFullfilmentCondition && colorPlayerFullfilmentCondition) {
	        cardLayout.show(screenToControl.getRootPane().getContentPane(), "game");
	    } else {
	        if (!textFieldFullfilmentCondition && !colorPlayerFullfilmentCondition) {
	            popUpNotificationColorPlayer();
	            popUpNotificationTextField();
	        } else if (!textFieldFullfilmentCondition) {
	            popUpNotificationTextField();
	        } else if (!colorPlayerFullfilmentCondition) {
	            popUpNotificationColorPlayer();
	        }
	    }
	}

	
	private void writePlayerSetup() {
		this.data.setGameName(gameName);
		this.data.setPlayers(playerNames, playerColors, data.getGameMode().getGamePoints());
	}
	
	private void readPlayerSetup() {
		readGameName();
		readPlayerNames();
		readPlayerColors();
		textFieldFullfillmentCondition();
		colorPlayerFullfilmentCondition();
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
	
	private void textFieldFullfillmentCondition() {
		
		JTextField[] nameInputs =  screenToControl.getPlayerNameInput().getNameInputs();
		gameName = screenToControl.getPlayerNameInput().getGameNameField().getText();
		
		this.playerNames = new String[this.data.getPlayerCount()];
		
		boolean allFieldFilled = true;
		
		for(int i=0; i< playerNames.length; i++) {
			playerNames[i] = nameInputs[i].getText();
			
			if(playerNames[i].isEmpty()) {
				allFieldFilled = false;
				break;
			}
		}
		if(gameName.isEmpty()) {
			allFieldFilled = false;
		}
		
		setTextFieldFullfillmentCondition(allFieldFilled);
	
	}
	
	private void setTextFieldFullfillmentCondition(boolean textField) {
		 this.textFieldFullfilmentCondition = textField;
	}
	
	
	private void popUpNotificationTextField() {
		JOptionPane.showMessageDialog(null, "Bitte füll alle TextFelder aus!", "WICHTIGER HINWEIS!", JOptionPane.ERROR_MESSAGE);
	}
	
	private void readPlayerColors() {
		JComboBox<view.ColorIcon>[] colorInputs =  screenToControl.getPlayerNameInput().getColorInputs();
		this.playerColors = new Color[this.data.getPlayerCount()];
		for(int i=0; i< playerNames.length; i++) {
			view.ColorIcon selectedColorIcon = (ColorIcon) colorInputs[i].getSelectedItem();
			playerColors[i] = selectedColorIcon.getColor();
		}
	}
	
	private void colorPlayerFullfilmentCondition() {
	    JComboBox<view.ColorIcon>[] colorInputs = screenToControl.getPlayerNameInput().getColorInputs();
	    this.playerColors = new Color[this.data.getPlayerCount()];

	    // Set zum Speichern der einzigartigen Farben
	    Set<Color> uniqueColors = new HashSet<>();

	    boolean differentColor = true;

	    for (int i = 0; i < playerNames.length; i++) {
	        view.ColorIcon selectedColorIcon = (view.ColorIcon) colorInputs[i].getSelectedItem();
	        if (selectedColorIcon != null) {
	            Color color = selectedColorIcon.getColor();
	            playerColors[i] = color;

	            if (!uniqueColors.add(color)) {
	                differentColor = false;
	             
	                break; 
	            }
	        } else {
	            differentColor = false;
	            break; 
	        }
	    }

	    setColorPlayerFullfillmentCondition(differentColor);
	}
	
	private void setColorPlayerFullfillmentCondition(boolean color) {
		this.colorPlayerFullfilmentCondition = color;
	}
	
	private void popUpNotificationColorPlayer() {
		JOptionPane.showMessageDialog(null, "Bitte wähl unterschiedliche Farben aus!", "WICHTIGER HINWEIS!", JOptionPane.ERROR_MESSAGE);
	}
	
	
}
