package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DartBoardGraphic extends JPanel {

    float strokeWidth = 3;
    int[] diameters = {750, 740, 640, 600, 390, 350, 50, 20};
    double AngleLines = 2 * Math.PI / 20;
    String[] numbers = {"20", "1", "18", "4", "13", "6", "10", "15", "2", "17", "3", "19", "7", "16", "8", "11", "14", "9", "12", "5"};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ruft die Basisklassenmethode auf, um den Hintergrund zu zeichnen

        Graphics2D g2d = (Graphics2D) g;

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int CenterX = panelWidth / 2;
        int CenterY = panelHeight / 2;
        double board_size_panel = 3.0/4.0; // Entscheidet wie groß das Board auf dem Panel angezeigt werden soll, wenn 1 dann ist es auf Standart für 1200 x 800.
        int boardDiameter =(int) (Math.min(panelWidth, panelHeight) * (board_size_panel)); // Board-Durchmesser relativ zur Panelgröße // bestimmt boarddurchmesser, anhand ob x oder y-wert kleiner ist, da sonst das board mit Rand überlappen würde 

        // Skaliere die Durchmesser relativ zum Board-Durchmesser
        int[] scaledDiameters = new int[diameters.length]; // legt neuen Array ScaledDiameter an, der genau so groß ist wie Durchmesser für 1200 x 800.
        for (int i = 0; i < diameters.length; i++) {		//Itiert solange durch, bis alle Durchmesser für die angepasste Fenstergröße berechnet worden
            scaledDiameters[i] = (int) (diameters[i] * (boardDiameter / 750.0));
        }

        // Schriftgröße dynamisch anpassen
        int fontSize = Math.max(10, boardDiameter / 20); // Beispiel: Schriftgröße proportional zum Board-Durchmesser
        Font boldFont = new Font("Impact", Font.BOLD, fontSize);
        g2d.setFont(boldFont);

        // Fläche Färbung
        g2d.setColor(new Color(77, 77, 77)); // Grauer Ring
        g2d.fillOval(CenterX - scaledDiameters[0] / 2, CenterY - scaledDiameters[0] / 2, scaledDiameters[0], scaledDiameters[0]);

        g2d.setColor(Color.BLACK); // Schwarzer Ring
        g2d.fillOval(CenterX - scaledDiameters[1] / 2, CenterY - scaledDiameters[1] / 2, scaledDiameters[1], scaledDiameters[1]);

        g2d.setColor(new Color(230, 230, 230)); // Weiße Fläche
        g2d.fillOval(CenterX - scaledDiameters[3] / 2, CenterY - scaledDiameters[3] / 2, scaledDiameters[3], scaledDiameters[3]);

        g2d.setColor(new Color(235, 231, 162)); // Gelb
        for (int j = 0; j < 20; j++) {
            double angle = (1.5 + j) * AngleLines;
            g2d.setColor(j % 2 == 0 ? new Color(39, 200, 89) : new Color(228, 30, 37));
            g2d.fillArc(CenterX - scaledDiameters[2] / 2, CenterY - scaledDiameters[2] / 2, scaledDiameters[2], scaledDiameters[2], (int) Math.toDegrees(angle), (int) Math.toDegrees(AngleLines));
            g2d.setColor(j % 2 == 0 ? Color.BLACK : Color.WHITE);
            g2d.fillArc(CenterX - scaledDiameters[3] / 2, CenterY - scaledDiameters[3] / 2, scaledDiameters[3], scaledDiameters[3], (int) Math.toDegrees(angle), (int) Math.toDegrees(AngleLines));
            g2d.setColor(j % 2 == 0 ? new Color(39, 200, 89) : new Color(228, 30, 37));
            g2d.fillArc(CenterX - scaledDiameters[4] / 2, CenterY - scaledDiameters[4] / 2, scaledDiameters[4], scaledDiameters[4], (int) Math.toDegrees(angle), (int) Math.toDegrees(AngleLines));
            g2d.setColor(j % 2 == 0 ? Color.BLACK : Color.WHITE);
            g2d.fillArc(CenterX - scaledDiameters[5] / 2, CenterY - scaledDiameters[5] / 2, scaledDiameters[5], scaledDiameters[5], (int) Math.toDegrees(angle), (int) Math.toDegrees(AngleLines));
        }

        // Zeichnen der Konzentrierten Kreise
        g2d.setColor(new Color(39, 200, 89)); // 25 Punkte
        g2d.fillOval(CenterX - scaledDiameters[6] / 2, CenterY - scaledDiameters[6] / 2, scaledDiameters[6], scaledDiameters[6]);

        g2d.setColor(new Color(229, 29, 36)); // 50 Punkte
        g2d.fillOval(CenterX - scaledDiameters[7] / 2, CenterY - scaledDiameters[7] / 2, scaledDiameters[7], scaledDiameters[7]);

        g2d.setColor(Color.WHITE);

        // Zeichnen der Ringe
        g2d.setStroke(new BasicStroke(strokeWidth));
        for (int diameter : scaledDiameters) {
            g2d.drawOval(CenterX - diameter / 2, CenterY - diameter / 2, diameter, diameter);
        }

        // Zeichnen der Linien und Nummern
        for (int i = 0; i < 20; i++) {
            double angle = (1.5 + i) * AngleLines;
            int x_inner_circle = CenterX + (int) (Math.cos(angle) * scaledDiameters[6] / 2); // Grenze vom Bullseye
            int y_inner_circle = CenterY + (int) (Math.sin(angle) * scaledDiameters[6] / 2); // Grenze vom Bullseye
            int x_line = CenterX + (int) (Math.cos(angle) * scaledDiameters[2] / 2);
            int y_line = CenterY + (int) (Math.sin(angle) * scaledDiameters[2] / 2);

            g2d.setColor(Color.WHITE);
            g2d.drawLine(x_inner_circle, y_inner_circle, x_line, y_line);

            double angle_number = i * AngleLines - Math.PI / 2; // Winkel der Zahlen
            int x_number = CenterX + (int) (Math.cos(angle_number) * scaledDiameters[5]);
            int y_number = CenterY + (int) (Math.sin(angle_number) * scaledDiameters[5]);

            // Zentrieren
            int textWidth = g2d.getFontMetrics().stringWidth(numbers[i]);
            int textHeight = g2d.getFontMetrics().getHeight();

            // Zeichne die Nummern
            g2d.setColor(Color.WHITE);
            g2d.drawString(numbers[i], x_number - textWidth / 2, y_number + textHeight / 4);
        }
    }
}