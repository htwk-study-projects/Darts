package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.ColorAndTextCellRenderer;

import java.awt.*;

public class GameScreenBar extends JFrame {

    public GameScreenBar() {
        // Frame-Einstellungen
        setTitle("Dartscheibe");
        setSize(350, 700); // Angepasste Größe, um nur die Seitenleiste darzustellen
        setLocationRelativeTo(null);

        // Seitenleiste
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(300, getHeight())); // Größere Seitenleiste
        sidebar.setBackground(Color.WHITE); // Hintergrundfarbe auf Weiß setzen
        sidebar.setLayout(new BorderLayout());

        // Tabelle erstellen mit Spalten: Farbe (als Kästchen), Spieler, Punktzahl (ohne Kopfzeilen)
        Object[][] data = {
            {Color.RED, "Spieler 1", "501"},
            {Color.BLUE, "Spieler 2", "501"},
            {Color.GREEN, "Spieler 3", "501"},
            {Color.YELLOW, "Spieler 4", "501"},
        };

        // Custom TableModel, um die Bearbeitung zu verhindern
        DefaultTableModel model = new DefaultTableModel(data, new Object[]{"", "", ""}) {
            public boolean isCellEditable(int row, int column) {
                return false; // Alle Zellen sind nicht editierbar
            }
        };

        JTable table = new JTable(model) {
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 0) { // Erste Spalte (Spieler mit Kästchen) bekommt speziellen Renderer
                    return new ColorAndTextCellRenderer();
                }
                return super.getCellRenderer(row, column);
            }
        };

        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(40);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // 10 Pixel Abstand oben
        scrollPane.getViewport().setBackground(Color.WHITE); // Hintergrund des ScrollPane auf Weiß setzen
        sidebar.add(scrollPane, BorderLayout.CENTER);

        // Panel für die Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(new Color(200,200,200)); // Dunkleres Grau für den Hintergrund der Buttons

        // Größere Hintergrundfläche schaffen
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Mehr Platz um die Buttons herum

        // Rechteckige Buttons erstellen
        int buttonWidth = 300;
        int buttonHeight = 50;

        JButton saveButton = new JButton("Speichern");
        saveButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        saveButton.setMaximumSize(new Dimension(buttonWidth, buttonHeight));
        saveButton.setBackground(Color.WHITE); // Hintergrundfarbe auf Weiß setzen
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createVerticalStrut(15)); // Abstand zwischen den Buttons

        JButton backButton = new JButton("Zurück");
        backButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        backButton.setMaximumSize(new Dimension(buttonWidth, buttonHeight));
        backButton.setBackground(Color.WHITE); // Hintergrundfarbe auf Weiß setzen
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(backButton);

        sidebar.add(buttonPanel, BorderLayout.SOUTH);

        // Hinzufügen der Seitenleiste zum Frame
        add(sidebar);
    }

  
}