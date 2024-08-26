package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DebugScreenSideBar extends JPanel {

    private JTextField sectorTextField;
    private JTextField multiplierTextField;
    private JTextField distanceTextField;
    private JTextField angleTextField;
    private JTextField vectorXTextField;
    private JTextField vectorYTextField;
    private JButton placeSectorMultiplierButton;
    private JButton placeDistanceAngleButton;
    private JButton placeVectorButton;
    private Line startBreakLine;
    protected JButton backButton; // Zurück Button

    public DebugScreenSideBar() {
    	this.setLayout(new BorderLayout());

        // Labels erstellen
        JLabel sectorLabel = new JLabel("Sektor:");
        JLabel multiplierLabel = new JLabel("Multiplikator:");
        JLabel distanceLabel = new JLabel("Distanz:");
        JLabel angleLabel = new JLabel("Winkel:");
        JLabel vectorXLabel = new JLabel("Wurfvektor X:");
        JLabel vectorYLabel = new JLabel("Wurfvektor Y:");

        // Fonts anpassen
        JComponent[] labels = {sectorLabel, multiplierLabel, distanceLabel, angleLabel, vectorXLabel, vectorYLabel};
        DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, labels);

        // Eingabefelder erstellen
        sectorTextField = new JTextField(10);
        multiplierTextField = new JTextField(10);
        distanceTextField = new JTextField(10);
        angleTextField = new JTextField(10);
        vectorXTextField = new JTextField(10);
        vectorYTextField = new JTextField(10);

        // Buttons erstellen
        placeSectorMultiplierButton = new JButton("Pfeil platzieren");
        placeDistanceAngleButton = new JButton("Pfeil platzieren");
        placeVectorButton = new JButton("Pfeil platzieren");
        backButton = new JButton("Zurück");
        startBreakLine = new Line(new JComponent[] { new TransparentPanel(), backButton, new TransparentPanel() });
        startBreakLine.setBackground(DartsGUI.BACKGROUND_COLOR);

        // Schriftart der Buttons setzen
        JButton[] buttons = {placeSectorMultiplierButton, placeDistanceAngleButton, placeVectorButton, backButton};
        for (JButton button : buttons) {
            button.setFont(DartsGUI.FONT_NORMAL);
        }

        // Bar für die erste Gruppe (Sektor & Multiplikator)
        Bar sectorMultiplierBar = new Bar(new JComponent[]{
            createLine(sectorLabel, sectorTextField),
            createLine(multiplierLabel, multiplierTextField),
            placeSectorMultiplierButton
        });
        sectorMultiplierBar.setOpaque(false);

        // Bar für die zweite Gruppe (Distanz & Winkel)
        Bar distanceAngleBar = new Bar(new JComponent[]{
            createLine(distanceLabel, distanceTextField),
            createLine(angleLabel, angleTextField),
            placeDistanceAngleButton
        });
        distanceAngleBar.setOpaque(false);

        // Bar für die dritte Gruppe (Wurfvektor X & Y)
        Bar vectorBar = new Bar(new JComponent[]{
            createLine(vectorXLabel, vectorXTextField),
            createLine(vectorYLabel, vectorYTextField),
            placeVectorButton
        });
        vectorBar.setOpaque(false);

        // Hauptbar erstellen, die alle anderen Bars und den Zurück-Button enthält
        Bar mainBar = new Bar(new JComponent[]{
            new TransparentPanel(), // Abstandhalter
            sectorMultiplierBar,
            new TransparentPanel(), // Abstandhalter
            distanceAngleBar,
            new TransparentPanel(), // Abstandhalter
            vectorBar,
            new TransparentPanel(), // Abstandhalter
            startBreakLine
            
        });
        mainBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        this.add(mainBar);
    }

    // Hilfsmethode zum Erstellen einer Line
    private Line createLine(JComponent label, JComponent textField) {
        Line line = new Line(new JComponent[]{label, textField});
        line.setOpaque(false); // Line transparent setzen
        return line;
    }

    
}