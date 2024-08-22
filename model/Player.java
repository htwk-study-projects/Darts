package model;

import java.awt.Color;

public class Player {
	
    private String name;
    private Color color;
    private DartArrow[] playerDarts;
    private int wuerfeZahl;
    private int punktzahl;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.playerDarts = DartArrow.createDart(3);
        this.wuerfeZahl = 3;
    }
    
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", wuerfeZahl=" + wuerfeZahl +
                ", punktzahl=" + punktzahl +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getWuerfeZahl() {
        return wuerfeZahl;
    }
    
    public int getPunktzahl() {
        return punktzahl;
    }

 
}
