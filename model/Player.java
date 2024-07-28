package model;

public class Player {
    private String name;
    private Farbe color;
    private int wuerfeZahl;
    private Wurf[] wuerfe;
    private int punktzahl;
    // private Dartpfeil dartpfeil;

    public Player(String name, Farbe color, int maxWuerfe) {
        this.name = name;
        this.color = color;
        this.wuerfeZahl = 0;
        this.wuerfe = new Wurf[maxWuerfe];
        this.punktzahl = 0;
        // this.dartpfeil = new Dartpfeil(); // Annahme: Konstruktor der Klasse Dartpfeil
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Farbe getColor() {
        return color;
    }

    public void setColor(Farbe color) {
        this.color = color;
    }

    public int getWuerfeZahl() {
        return wuerfeZahl;
    }

    public Wurf[] getWuerfe() {
        return wuerfe;
    }

    public int getPunktzahl() {
        return punktzahl;
    }

    public void addWurf(Wurf wurf) {
        if (wuerfeZahl < wuerfe.length) {
            wuerfe[wuerfeZahl] = wurf;
            wuerfeZahl++;
            punktzahl += wurf.getPunkte(); // Annahme: Methode getPunkte() in der Klasse Wurf
        }
    }

   
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", wuerfeZahl=" + wuerfeZahl +
                ", punktzahl=" + punktzahl +
                '}';
    }
}
