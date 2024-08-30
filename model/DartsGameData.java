package model;

import java.awt.Color;
import java.util.Arrays;

public class DartsGameData {
    
    private String gameName;
    private int playerCount;
    private Player[] players;
    private GameMode gameMode;
    private int currentPlayerIndex = 0; 
    private int turnCount = 0; 

    @Override
	public String toString() {
		return "DartsGameData [gameName=" + gameName + ", playerCount=" + playerCount + ", players="
				+ Arrays.toString(players) + ", gameMode=" + gameMode + ", currentPlayerIndex=" + currentPlayerIndex
				+ ", turnCount=" + turnCount + "]";
	}

    public void currentPlayerTakeTurn(double[] throwParameters) {
    	this.getCurrentPlayer().playerThrowCurrentDart(throwParameters);
    	this.getCurrentPlayer().setStatusPlayIn(this.gameMode.isGameInModeConditionFulfilled(this.getCurrentPlayer().getCurrentThrowMultiplier()));
        this.getCurrentPlayer().setStatusPlayOut(this.gameMode.isGameOutModeConditionFulfilled(this.getCurrentPlayer().getCurrentThrowMultiplier()));
        this.getCurrentPlayer().setStatusCanFinish(this.gameMode.arePointValidForOutMode(this.getCurrentPlayer().getPlayerPoints(), this.getCurrentPlayer().getCurrentThrowPoints(), this.getCurrentPlayer().getStatusPlayOut()));      
        this.getCurrentPlayer().updatePlayerPoints();
    }

	public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setPlayers(String[] playerNames, Color[] playerColors, int gamePoints) {
        this.players = Player.createPlayer(playerNames, playerColors, gamePoints);
        this.playerCount = players.length; // Spieleranzahl setzen
    }

    public void setGameMode(int gamePoints, String inMode, String outMode) {
        this.gameMode = new GameMode(gamePoints, inMode, outMode);
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
    

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
    
    public int getTurnCount() {
    	return turnCount;
    }

    public void nextTurnPlayer() {
        Player currentPlayer = players[currentPlayerIndex];

        if (currentPlayer.getStatusFinish() || turnCount >= 2) {
            turnCount = 0;
            currentPlayer.setThrowCount(0);
            currentPlayerIndex = (currentPlayerIndex + 1) % playerCount;
        } else {
            turnCount++;
        }
    }
    
    public Object[][] preparePlayerDataForTable(){
        Object[][] playerDataForTable = new Object[this.playerCount][3];
        for(int i = 0; i < playerDataForTable.length; i++) {
            playerDataForTable[i] = new Object[] {players[i].getColor(), players[i].getPlayerPoints(), players[i].getName()};
        }
        return playerDataForTable;
    }
    
    public void resetData() {
    	this.gameName = null;
    	this.playerCount = 0;
    	this.players = null;
    	this.gameMode = null;
    	this.currentPlayerIndex = 0;
    	this.turnCount = 0;
    }

}

