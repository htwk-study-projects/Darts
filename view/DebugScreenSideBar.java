package view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    protected JButton backButton;

    public DebugScreenSideBar() {
        this.setLayout(new GridBagLayout());
        this.setBackground(DartsGUI.BACKGROUND_COLOR); // Verwenden des Hintergrunds aus DartsGUI

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Abstände zwischen den Komponenten
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels erstellen
        JLabel sectorLabel = new JLabel("Sektor:");
        JLabel multiplierLabel = new JLabel("Multiplikator:");
        JLabel distanceLabel = new JLabel("Distanz:");
        JLabel angleLabel = new JLabel("Winkel:");
        JLabel vectorXLabel = new JLabel("Wurfvektor X:");
        JLabel vectorYLabel = new JLabel("Wurfvektor Y:");

        // Fonts anpassen
        JComponent[] labels = {sectorLabel, multiplierLabel, distanceLabel, angleLabel, vectorXLabel, vectorYLabel};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, labels);

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
        

        JButton[] buttons = {placeSectorMultiplierButton, placeDistanceAngleButton, placeVectorButton, backButton};
        for (JButton button : buttons) {
            button.setFont(DartsGUI.FONT_BIG);
        }
        // Komponenten mit GridBagConstraints hinzufügen

        // Erste Zeile: Sektor und Multiplikator
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;  // Label rechtsbündig
        this.add(sectorLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;  // Textfeld linksbündig
        this.add(sectorTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;  // Label rechtsbündig
        this.add(multiplierLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;  // Textfeld linksbündig
        this.add(multiplierTextField, gbc);

        // Button für Sektor & Multiplikator
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;  // Button über beide Spalten
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(placeSectorMultiplierButton, gbc);

        // TransparentPanels als Trennfläche
        gbc.gridy++;
        gbc.gridwidth = 2;
        this.add(new TransparentPanel(), gbc);

        gbc.gridy++;
        this.add(new TransparentPanel(), gbc);

        gbc.gridy++;
        this.add(new TransparentPanel(), gbc);

        // Distanz und Winkel in der nächsten Zeile
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;  // Label rechtsbündig
        this.add(distanceLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;  // Textfeld linksbündig
        this.add(distanceTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;  // Label rechtsbündig
        this.add(angleLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;  // Textfeld linksbündig
        this.add(angleTextField, gbc);

        // Button für Distanz & Winkel
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;  // Button über beide Spalten
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(placeDistanceAngleButton, gbc);

        // Weitere TransparentPanels als Trennfläche
        gbc.gridy++;
        gbc.gridwidth = 2;
        this.add(new TransparentPanel(), gbc);

        gbc.gridy++;
        this.add(new TransparentPanel(), gbc);

        gbc.gridy++;
        this.add(new TransparentPanel(), gbc);

        // Wurfvektor X und Y in der nächsten Zeile
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;  // Label rechtsbündig
        this.add(vectorXLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;  // Textfeld linksbündig
        this.add(vectorXTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;  // Label rechtsbündig
        this.add(vectorYLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;  // Textfeld linksbündig
        this.add(vectorYTextField, gbc);

        // Button für Wurfvektor X & Y
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;  // Button über beide Spalten
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(placeVectorButton, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        this.add(new TransparentPanel(), gbc);

        gbc.gridy++;
        this.add(new TransparentPanel(), gbc);

        gbc.gridy++;
        this.add(new TransparentPanel(), gbc);

        // "Zurück" Button
        gbc.gridy++;
        gbc.gridwidth = 2;  // Button über beide Spalten
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(backButton, gbc);

        // Button Actions hinzufügen
        placeSectorMultiplierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeDartBasedOnSectorAndMultiplier();
            }
        });

        placeDistanceAngleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeDartBasedOnDistanceAndAngle();
            }
        });

        placeVectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeDartBasedOnVector();
            }
        });
    }

    // Methode zur Platzierung des Darts basierend auf Sektor und Multiplikator
    private void placeDartBasedOnSectorAndMultiplier() {
        String sector = sectorTextField.getText();
        String multiplier = multiplierTextField.getText();

        if (sector.isEmpty() || multiplier.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Sektor und Multiplikator ausfüllen.", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String resultMessage = String.format("Pfeil platziert: Sektor %s, Multiplikator %s", sector, multiplier);
        JOptionPane.showMessageDialog(this, resultMessage, "Dart Platzieren", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(resultMessage);
    }

    // Methode zur Platzierung des Darts basierend auf Distanz und Winkel
    private void placeDartBasedOnDistanceAndAngle() {
        String distance = distanceTextField.getText();
        String angle = angleTextField.getText();

        if (distance.isEmpty() || angle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Distanz und Winkel ausfüllen.", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String resultMessage = String.format("Pfeil platziert: Distanz %s, Winkel %s", distance, angle);
        JOptionPane.showMessageDialog(this, resultMessage, "Dart Platzieren", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(resultMessage);
    }

    // Methode zur Platzierung des Darts basierend auf Wurfvektor X und Y
    private void placeDartBasedOnVector() {
        String vectorX = vectorXTextField.getText();
        String vectorY = vectorYTextField.getText();

        if (vectorX.isEmpty() || vectorY.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte Wurfvektor X und Y ausfüllen.", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String resultMessage = String.format("Pfeil platziert: Wurfvektor X %s, Y %s", vectorX, vectorY);
        JOptionPane.showMessageDialog(this, resultMessage, "Dart Platzieren", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(resultMessage);
        


    }
    
    

}