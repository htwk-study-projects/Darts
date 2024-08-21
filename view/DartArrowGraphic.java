package view;

import javax.swing.*;
import java.awt.*;

public class DartArrowGraphic extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Anti-Aliasing einschalten für glattere Linien
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dartpfeil zeichnen

        // 1. Spitze (Dreieck)
        int[] xPoints = {150, 160, 140}; // x-Koordinaten des Dreiecks
        int[] yPoints = {20, 40, 40}; // y-Koordinaten des Dreiecks
        g2d.setColor(Color.GRAY);
        g2d.fillPolygon(xPoints, yPoints, 3);

        // 2. Schaft (Linie)
        g2d.setColor(Color.BLACK);
        g2d.fillRect(145, 40, 10, 100); // Schaft, positioniert unter der Spitze

        // 3. Flights (Dreiecke)
        int[] flight1X = {140, 150, 130};
        int[] flight1Y = {140, 160, 160};

        int[] flight2X = {160, 170, 150};
        int[] flight2Y = {140, 160, 160};

        g2d.setColor(Color.RED);
        g2d.fillPolygon(flight1X, flight1Y, 3);
        g2d.fillPolygon(flight2X, flight2Y, 3);

        // 4. Details im Flight
        g2d.setColor(Color.BLACK);
        g2d.drawLine(145, 140, 145, 160);
        g2d.drawLine(155, 140, 155, 160);
    }

}
