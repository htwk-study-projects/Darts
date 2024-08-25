package view;

import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class GameScreenSideBar extends JPanel {

	private Line buttonLine;
    protected JButton saveButton;
    protected JButton backButton;
    
    private Object[][] playerTableData;
    private GameScreenPlayerPanel playerPanel;
    

    public GameScreenSideBar() {

        this.setLayout(new BorderLayout());

        // Tabelle erstellen mit Spalten: Farbe (als Kästchen), Spieler, Punktzahl (ohne Kopfzeilen)
        playerTableData = new Object[][]{
            {Color.RED, "501", "Spieler 1"},
            {Color.BLUE, "501", "Spieler 2"},
            {Color.GREEN, "501", "Spieler 3"},
            {Color.YELLOW, "501", "Spieler 4"},
        };

        // Custom TableModel, um die Bearbeitung zu verhindern
        DefaultTableModel tableModel = new DefaultTableModel(playerTableData, new Object[]{"", "", ""}) {
            public boolean isCellEditable(int row, int column) {
                return false; // Alle Zellen sind nicht editierbar
            }
        };

        JTable table = new JTable(tableModel) {
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 0) { // Erste Spalte (Spieler mit Kästchen) bekommt speziellen Renderer
                    return new IconRendererForTable();
                }
                return super.getCellRenderer(row, column);
            }
        };
        setTabelSettings(table);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false); // Tabelle selbst bleibt transparent
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
       
        JPanel scrollPaneContainer = new JPanel(new BorderLayout());
        scrollPaneContainer.setOpaque(false);
  

        // Leeres Panel links, um Platz zu schaffen
        JPanel leftSpace = new JPanel();
        leftSpace.setOpaque(false); // Hintergrund transparent
        leftSpace.setPreferredSize(new java.awt.Dimension(70, 0)); // Anpassen für den gewünschten Abstand

        scrollPaneContainer.add(leftSpace, BorderLayout.WEST); // Platzhalter links
        scrollPaneContainer.add(scrollPane, BorderLayout.CENTER); // scrollPane in die Mitte

        saveButton = new JButton("Speichern");
        backButton = new JButton("Zurück");
    	JButton[] setupButtons = {saveButton, backButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
        JButton[] buttons = {saveButton, backButton};
        buttonLine = new Line(buttons);
        buttonLine.setBackground(DartsGUI.BACKGROUND_COLOR); // Hintergrund von buttonLine auf Grau setzen

        playerPanel = new GameScreenPlayerPanel();
        playerPanel.setBackground(DartsGUI.BACKGROUND_COLOR); // Hintergrund von playerPanel auf Grau setzen

        JPanel empty = new JPanel();
        empty.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        JComponent[] test = {empty, scrollPaneContainer, playerPanel, buttonLine};
        Bar Table = new Bar(test);
        Table.setBackground(DartsGUI.BACKGROUND_COLOR); // Hintergrund von Table auf Grau setzen
        
        this.add(Table, BorderLayout.CENTER);
    }
    
    private void setTabelSettings(JTable table) {
        table.setOpaque(false);
        table.setBackground(new Color(0, 0, 0, 0)); // Vollständig transparent
        table.setShowGrid(false);
        table.setTableHeader(null);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.removeColumn(table.getColumnModel().getColumn(2));
        table.setFont(DartsGUI.FONT_NORMAL);
        table.setRowHeight(40);
    }
}