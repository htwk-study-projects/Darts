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
    private boolean statusFinish;
    private boolean statusCanFinish;

    private Player(String name, Color color, int selectedPoints) {
        this.name = name;
        this.color = color;
        this.playerDarts = DartArrow.createDart(3).clone();
        this.throwCount = 0;
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
 	
	public void updatePlayerPoints() {
		//System.out.println(this.playerDarts[this.throwCount]);
		if(statusPlayIn && statusCanFinish) {
			this.playerPoints -= this.playerDarts[this.throwCount -1].getPoints();
		}
		if(statusPlayOut && this.playerPoints == 0) {
			statusFinish = true;
		}
    }
	
	public boolean playerThrowCurrentDart(double [] ThrowParameter) {
		if(!(throwCount < 3)) {
			return false;
		}
		playerDarts[this.throwCount].setThrowParameter(ThrowParameter);
		playerDarts[this.throwCount].throwDart();
		this.throwCount++;
		return true;
	}
	
	public MathVector getCurrentImpactPoint() {
		MathVector impactPoint = this.playerDarts[this.throwCount -1].getDartThrow().getImpactVector();
		if(impactPoint != null) {
			return impactPoint;
		}
		return new MathVector(new double[] {1000, 1000, 1000});
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", color=" + color + ", playerDarts=" + Arrays.toString(playerDarts)
				+ ", throwCount=" + throwCount + ", playerPoints=" + playerPoints + ", statusPlayIn=" + statusPlayIn
				+ ", statusPlayOut=" + statusPlayOut + ", StatusCanFinish="+ statusCanFinish +", statusFinish=" + statusFinish + "]\n";
	}
	
	public int getCurrentThrowMultiplier() {
		Integer multiplier = this.playerDarts[this.throwCount -1].getMultiplier();
		if(multiplier != null) {
			return multiplier;
		}
		return 404;
	}
	
	public int getCurrentThrowPoints() {
		Integer points = this.playerDarts[this.throwCount -1].getPoints();
		if(points != null) {
			return points;
		}
		return 0;
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
    
    public void setThrowCount(int newCount) {
    	this.throwCount = newCount;
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
    	return statusCanFinish;
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
