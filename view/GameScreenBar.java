package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class GameScreenBar extends JFrame {

    public GameScreenBar() {
        // Frame-Einstellungen
        setTitle("Dartscheibe");
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Hauptpanel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE); 

        // Seitenleiste
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(300, 0)); // Größere Seitenleiste
        sidebar.setBackground(Color.WHITE); // Hellgrau
        sidebar.setLayout(new BorderLayout());
        
        // Linken Rand vergrößern
        JPanel leftMarginPanel = new JPanel();
        leftMarginPanel.setPreferredSize(new Dimension(20, 0)); // 20 Pixel breiter linker Rand
        leftMarginPanel.setBackground(Color.WHITE); // Hintergrundfarbe auf Weiß setzen
        sidebar.add(leftMarginPanel, BorderLayout.WEST); // Links im BorderLayout hinzufügen
        

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
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // 20 Pixel Abstand oben
        scrollPane.getViewport().setBackground(Color.WHITE); // Hintergrund des ScrollPane auf Weiß setzen
        sidebar.add(scrollPane, BorderLayout.CENTER);
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

        mainPanel.add(sidebar, BorderLayout.EAST);

        // Hinzufügen des Hauptpanels zum Frame
        add(mainPanel);
    }


    // Custom TableCellRenderer für Farbe als kleines Kästchen und Text
    private static class ColorAndTextCellRenderer extends DefaultTableCellRenderer {
     
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 0) {
                label.setText(""); // Kein Text, nur das Farbkästchen
                label.setIcon(new ColorIcon((Color) value));
            } else {
                label.setIcon(null);
            }
            return label;
        }
    }

    // Custom Icon für das farbige Kästchen
    private static class ColorIcon implements Icon {
        private final Color color;
        private static final int SIZE = 15;

        public ColorIcon(Color color) {
            this.color = color;
        }

    
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillRect(x, y, SIZE, SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, SIZE, SIZE);
        }

  
        public int getIconWidth() {
            return SIZE;
        }

    
        public int getIconHeight() {
            return SIZE;
        }
    }
}

