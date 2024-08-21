package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PlayerSetup extends JPanel {
    
    private JLabel title;
    protected JButton startButton;
    protected JButton homeButton;

    public PlayerSetup() {
        // Setzen des Layouts des Haupt-Panels auf GridLayout mit 3x3
        this.setLayout(new GridLayout(3, 3)); 
        DartsGUI.gridLayoutFill(this, 3, 3);

        // Erstellen und Konfigurieren des Titel-Labels
        title = new JLabel("Player Setup");
        title.setFont(DartsGUI.FONT_TITLE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Erstellen des Textfeldes und Anpassen der Größe
        JTextField gameNameText = new JTextField("Gib ein Spielenamen ein!");
        gameNameText.setPreferredSize(new Dimension(150, 25)); // Kleinere Größe
        gameNameText.setFont(DartsGUI.FONT_NORMAL); // Verwenden Sie eine passende Schriftart

        // Erstellen der Buttons
        startButton = new JButton("Weiter");
        homeButton = new JButton("Zurück");
        JButton[] setupButtons = {homeButton, startButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
        Line startBreakLine = new Line(setupButtons);

        // Hinzufügen der Komponenten zum Haupt-Panel in GridLayout
        this.add(title); // Platz 0: Titel oben

        // Platz 1 und 2: Leere Plätze zum Ausrichten
        this.add(new JPanel()); 
        this.add(new JPanel()); 

        // Platz 3: Textfeld in der Mitte
        JPanel gameNamePanel = new JPanel();
        gameNamePanel.add(gameNameText);
        this.add(gameNamePanel); 

        // Platz 4 und 5: Leere Plätze zum Ausrichten
        this.add(new JPanel()); 
        this.add(new JPanel()); 

        // Platz 6: Start- und Home-Button in der Mitte der letzten Zeile
        JPanel startBreakPanel = new JPanel();
        startBreakPanel.add(startBreakLine);
        this.add(startBreakPanel); 

        // Platz 7 und 8: Leere Plätze zum Ausrichten
        this.add(new JPanel()); 
        this.add(new JPanel()); 
    }
}
