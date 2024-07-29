package model;

public class Player {
	
    private String name;
    private Colors color;
    
    private int wuerfeZahl;
    private int punktzahl;

    public Player(String name, Colors color) {
        this.name = name;
        this.color = color;
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

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public int getWuerfeZahl() {
        return wuerfeZahl;
    }
    
    public int getPunktzahl() {
        return punktzahl;
    }

 
}
