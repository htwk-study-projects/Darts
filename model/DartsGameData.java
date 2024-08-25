package model;

import java.awt.Color;

public class DartsGameData {
	
	private static int gameIDCounter = 0;
	
	private int gameID;
	private String gameName;
	private int playerCount;
	private Player[] players;
	private GameMode gameMode;
	
	public DartsGameData(){
		setGameIDCounter(10);
		this.gameID = gameIDCounter;
		gameIDCounter++;
	}
	
	public static void setGameIDCounter(int gameIDCounter) {
		DartsGameData.gameIDCounter = gameIDCounter;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setPlayers(String[] playerNames, Color[] playerColors, int gamePoints) {
		this.players = Player.createPlayer(playerNames, playerColors, gamePoints);;
	}

	public void setGameMode(int gamePoints, String inMode, String outMode) {
		this.gameMode = new GameMode(gamePoints, inMode, outMode);
	}

	public int getGameID() {
		return gameID;
	}

	public String getGameName() {
		return gameName;
	}

	public Player[] getPlayers() {
		return players;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
	
	public Object[][] preparePlayerDataForTabel(){
		Object[][] playerDataForTable = new Object[this.playerCount][3] ;
		for(int i = 0; i < playerDataForTable.length; i++) {
			playerDataForTable[i] = new Object[] {players[i].getColor(), players[i].getPlayerPoints(), players[i].getName()};
		}
		return playerDataForTable;
	}
	
	

}
