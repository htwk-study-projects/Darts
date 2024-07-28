package model;

public class Wurf {
    private int punkte;

    public Wurf(int punkte) {
        this.punkte = punkte;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public String toString() {
        return "Wurf{" +
                "punkte=" + punkte +
                '}';
    }
}