package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class GameScreenSideBar extends JPanel {

    public GameScreenSideBar() {
    	
    	
        this.setLayout(new BorderLayout());

        // Tabelle erstellen mit Spalten: Farbe (als Kästchen), Spieler, Punktzahl (ohne Kopfzeilen)
        Object[][] data = {
             {Color.RED, "501", "Spieler 1"},
             {Color.BLUE, "501", "Spieler 2"},
             {Color.GREEN, "501", "Spieler 3"},
             {Color.YELLOW, "501", "Spieler 4"},
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
                    return new IconRenderer();
                }
                return super.getCellRenderer(row, column);
            }
        };
        
        table.removeColumn(table.getColumnModel().getColumn(2));

        table.setFont(DartsGUI.FONT_NORMAL);
        table.setRowHeight(40);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton saveButton = new JButton("Speichern");
        JButton backButton = new JButton("Zurück");
        JButton[] buttons = {saveButton, backButton};
        JPanel buttonLine = new Line(buttons);
        
        JComponent[] test = {new JPanel(),scrollPane, new JPanel(),buttonLine};
        Bar Table = new Bar(test);
        this.add(Table,BorderLayout.CENTER);
    }

}