package model;

import java.awt.Color;

public class Player {
	
    private String name;
    private Color color;
    private DartArrow[] playerDarts;
    private int throwCount;
    private int playerPoints;

    private Player(String name, Color color, int selectedPoints) {
        this.name = name;
        this.color = color;
        this.playerDarts = DartArrow.createDart(3);
        this.throwCount = 3;
        this.playerPoints = selectedPoints;
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

   // public 
 
}
