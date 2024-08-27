package model;

import java.awt.Color;

public class DartsGameData {
    
    private static int gameIDCounter = 0;
    
    private int gameID;
    private String gameName;
    private int playerCount;
    private Player[] players;
    private GameMode gameMode;
    private int currentPlayerIndex = 0; // Index des aktuellen Spielers
    private int turnCount = 0; // Zähler für die Züge eines Spielers

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
        this.players = Player.createPlayer(playerNames, playerColors, gamePoints);
        this.playerCount = players.length; // Spieleranzahl setzen
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
    

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
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
    

}

