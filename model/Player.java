package model;

import java.awt.Color;
import java.util.Arrays;

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
    
	public void updatePlayerPoints() {
    	//muss in Abhängigkeit der stati die punkte entweder abziehen oder gleichlassen
		//setzen der stati erfolgt im Controller durch aufrufen von gameMode-Methodem und settern
		//ist ein status einmal true bleibt er true
    	
    }

    
    @Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", playerDarts=" + Arrays.toString(playerDarts)
				+ ", throwCount=" + throwCount + ", playerPoints=" + playerPoints + ", statusPlayIn=" + statusPlayIn
				+ ", statusPlayOut=" + statusPlayOut + ", statusFinish=" + statusFinish + "]\n";
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
   
    public void setStatusPlayIn(boolean statusPlayIn) {
		this.statusPlayIn = statusPlayIn;
	}

	public void setStatusPlayOut(boolean statusPlayOut) {
		this.statusPlayOut = statusPlayOut;
	}

	public void setStatusFinish(boolean statusFinish) {
		this.statusFinish = statusFinish;
	}

}
