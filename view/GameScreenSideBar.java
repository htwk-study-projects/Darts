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

	protected JButton saveButton;
	protected JButton backButton;
	
    public GameScreenSideBar() {
    	
    	
        this.setLayout(new BorderLayout());

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
                    return new IconRenderer();
                }
                return super.getCellRenderer(row, column);
            }
        };

        table.setFont(DartsGUI.FONT_NORMAL);
        table.setRowHeight(40);

        JScrollPane scrollPane = new JScrollPane(table);

        saveButton = new JButton("Speichern");
        backButton = new JButton("Zurück");
        JButton[] buttons = {saveButton, backButton};
        JPanel buttonLine = new Line(buttons);
        
        JComponent[] test = {new JPanel(),scrollPane, new JPanel(),buttonLine};
        Bar Table = new Bar(test);
        this.add(Table,BorderLayout.CENTER);
    }

}