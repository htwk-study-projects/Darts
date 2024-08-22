package model;

import java.awt.Color;

public class Player {
	
    private String name;
    private Color color;
    private DartArrow[] playerDarts;
    private int throwCount;
    private int playerPoints;
    private boolean statusPlayIn;
    private boolean statusPlayOut;
    private boolean statusFinish; //Gewonnen true or false

    private Player(String name, Color color, int selectedPoints) {
        this.name = name;
        this.color = color;
        this.playerDarts = DartArrow.createDart(3);
        this.throwCount = 3;
        this.playerPoints = selectedPoints;
        this.statusPlayIn = false;
        this.statusPlayOut = false;
        this.statusFinish = false;
 
    }
    
    public static Player[] createPlayer(String[] names, Color[] colors, int selectedPoints) {
    	Player[] player = new Player[names.length];
    	for(int i = 0; i < names.length; i++) {
    		player[i] = new Player(names[i], colors[i], selectedPoints);
    	}
    	return player;
    }
    
    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
    
    public int getThrowCount() {
        return throwCount;
    }
    
    public int getPlayerPoints() {
        return playerPoints;
    }
    
    public boolean getStatusPlayIn() {
    	return statusPlayIn;
    }
    
    public boolean getStatusPlayOut() {
    	return statusPlayOut;
    }
    
    public boolean getStatusFinish() {
    	return statusFinish;
    }
   // public 
 
   /* public int calculationPlayerPoints(GameMode gameMode) {
    	int currentDartThrow = playerDarts.length - throwCount;
    	playerDarts[currentDartThrow]
    }
    */
}
