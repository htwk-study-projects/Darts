package model;

import java.awt.Color;

public class DartsGameData {
	
	private static int gameIDCounter = 0;
	
	private int gameID;
	private final String gameName;
	private final Player[] players;
	private final GameMode gameMode;
	
	public DartsGameData(String gameName, String[] playerNames, Color[] playerColors, int gamePoints, String inMode, String outMode){
		//gameIDCounter muss vorher auf die höchste gameID der gespeicherten spiele gesetzt werden
		setGameIDCounter(10);
		this.gameID = gameIDCounter;
		this.gameName = gameName;
		this.players = Player.createPlayer(playerNames, playerColors, gamePoints);
		this.gameMode = new GameMode(gamePoints, inMode, outMode);
	}
	
	public static void setGameIDCounter(int gameIDCounter) {
		DartsGameData.gameIDCounter = gameIDCounter;
	}
	

}
