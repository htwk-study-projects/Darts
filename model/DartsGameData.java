package model;

import java.awt.Color;
import java.util.Arrays;

/**
 * The {@code DartsGameData} class manages the state and flow of a darts game.
 * It handles player data, game mode, and turn management.
 */
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

    /**
     * Handles the current player's turn by processing their dart throw.
     * Updates the player's status based on the game mode conditions and updates their points.
     * 
     * @param throwParameters an array of doubles representing the parameters for the dart throw
     */
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
        this.playerCount = players.length;
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
    
    /**
     * Sets the number of players for the game. This method is used for initializing
     * the player count before creating player objects. Needed for GUI
     * 
     * @param playerCount the number of players to set
     */
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
    

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
    
    public int getTurnCount() {
    	return turnCount;
    }

    /**
     * Advances to the next player's turn. If the current player has finished or 
     * the turn count exceeds 2, it resets the turn count and moves to the next player.
     * 
     */
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
    
    /**
     * Prepares the player data for display in a table format. This method formats player information 
     * into a 2D array.
     * 
     * @return a 2D array of {@code Object} where each row represents a player, including their color, 
     *         points, and name
     */
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

