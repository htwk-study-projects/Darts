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
    private boolean statusCanFinish;

    private Player(String name, Color color, int selectedPoints) {
        this.name = name;
        this.color = color;
        this.playerDarts = DartArrow.createDart(3).clone();
        this.throwCount = 3;
        this.playerPoints = selectedPoints;
        this.statusPlayIn = false;
        this.statusPlayOut = false;
        this.statusCanFinish = false;
        this.statusFinish = false;
        
 
    }
    
    public static Player[] createPlayer(String[] names, Color[] colors, int selectedPoints) {
    	Player[] player = new Player[names.length];
    	for(int i = 0; i < names.length; i++) {
    		player[i] = new Player(names[i], colors[i], selectedPoints);
    	}
    	return player;
    }
    
  //muss in Abhängigkeit der stati die punkte entweder abziehen oder gleichlassen
  //setzen der stati erfolgt im Controller durch aufrufen von gameMode-Methodem und settern
  //ist ein status einmal true bleibt er true	
	public void updatePlayerPoints() {
		System.out.println(this.playerDarts[this.playerDarts.length -1 - this.throwCount]);
		if(statusPlayIn && statusCanFinish) {
			this.playerPoints -= this.playerDarts[this.playerDarts.length -1 - this.throwCount].getPoints();
		}
		if(statusPlayOut) {
			setStatusFinish(true);
		}
    }
	
	public boolean playerThrowCurrentDart(double [] ThrowParameter) {
		if(!(throwCount > 0)) {
			return false;
		}
		playerDarts[playerDarts.length - throwCount].setThrowParameter(ThrowParameter);
		playerDarts[playerDarts.length - throwCount].throwDart();
		this.throwCount--;
		return true;
	}
	

	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", playerDarts=" + Arrays.toString(playerDarts)
				+ ", throwCount=" + throwCount + ", playerPoints=" + playerPoints + ", statusPlayIn=" + statusPlayIn
				+ ", statusPlayOut=" + statusPlayOut + ", StatusCanFinish="+ statusCanFinish +", statusFinish=" + statusFinish + "]\n";
	}
	
	public int getCurrentThrowMultiplier() {
		System.out.println(this.playerDarts[this.playerDarts.length - 1 - this.throwCount]);
		Integer multiplier = this.playerDarts[this.playerDarts.length - 1 - this.throwCount].getMultiplier();
		if(multiplier != null) {
			return multiplier;
		}
		return 404;
	}
    
    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
    
    
    public DartArrow[] getPlayerDarts() {
		return playerDarts;
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
    
    public boolean getStatusCanFinish() {
    	return getStatusCanFinish();
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
	
	public void setStatusCanFinish(boolean statusCanFinish) {
		this.statusCanFinish = statusCanFinish;
	}

	public void setStatusFinish(boolean statusFinish) {
		this.statusFinish = statusFinish;
	}

}
