package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class GameScreenSideBar extends JPanel {

	private Line buttonLine;
	private Bar strengthBarBar;
    protected JButton saveButton;
    protected JButton backButton;
    
    private JLabel gameNameLabel;
    
    private Object[][] playerTableData;
    private DefaultTableModel tableModel ;
    private JTable table;
    private JScrollPane scrollPane;
    private JPanel scrollPaneContainer;
    private TransparentPanel leftSpace;
    private JPanel instructionPanel;
    
    private GameScreenCurrentPlayerPanel playerPanel;
    private StrengthBarPanel strengthBar;
    

    public GameScreenSideBar() {

        this.setLayout(new BorderLayout());

        
        gameNameLabel = new JLabel("Spielname", SwingConstants.CENTER);
        gameNameLabel.setFont(DartsGUI.FONT_NORMAL);
     

        JLabel instructionLabel1 = new JLabel("Tippe auf den Bildschirm damit der Dartpfeil erscheint", SwingConstants.CENTER);
        JLabel instructionLabel2 = new JLabel("Platziere den Dartpfeil auf die gewünschte Wurfposition", SwingConstants.CENTER);
        JLabel instructionLabel3 = new JLabel("Tippe ein weiteres Mal zum Werfen des Dartpfeils", SwingConstants.CENTER);

        // Dummy Table
        playerTableData = new Object[][]{
            {Color.RED, "501", "Spieler 1"},
            {Color.BLUE, "501", "Spieler 2"},
            {Color.GREEN, "501", "Spieler 3"},
            {Color.YELLOW, "501", "Spieler 4"},
        };

        // Custom TableModel, um die Bearbeitung zu verhindern
        tableModel = new DefaultTableModel(playerTableData, new Object[]{"", "", ""}) {
            public boolean isCellEditable(int row, int column) {
                return false; // Alle Zellen sind nicht editierbar
            }
        };

        table = new JTable(tableModel) {
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 0) { // Erste Spalte (Spieler mit Kästchen) bekommt speziellen Renderer
                    return new IconRendererForTable();
                }
                return super.getCellRenderer(row, column);
            }
        };
        setTabelSettings(table);


        scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false); // Tabelle selbst bleibt transparent
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
       
        scrollPaneContainer = new JPanel(new BorderLayout());
        scrollPaneContainer.setOpaque(false);
  

        // Leeres Panel links, um Platz zu schaffen
        leftSpace = new TransparentPanel();
        leftSpace.setPreferredSize(new java.awt.Dimension(80, 0)); // Anpassen für den gewünschten Abstand
        
        instructionPanel = new JPanel(new GridLayout(5,1,1,1));
        instructionPanel.setOpaque(false);
      
        JComponent[] labels= {instructionLabel1,instructionLabel2,instructionLabel3};
        DartsGUI.fontAdjust(DartsGUI.FONT_SMALL, labels);
        instructionPanel.add(gameNameLabel);
        instructionPanel.add(instructionLabel1);
        instructionPanel.add(instructionLabel2);
        instructionPanel.add(instructionLabel3);
      
        
        
        scrollPaneContainer.add(instructionPanel, BorderLayout.WEST); // Instructions on the left
        scrollPaneContainer.add(leftSpace, BorderLayout.WEST); // Platzhalter links
        scrollPaneContainer.add(scrollPane, BorderLayout.CENTER); // scrollPane in die Mitte
        
       

        saveButton = new JButton("Speichern");
        backButton = new JButton("Zurück");
    	JButton[] setupButtons = {saveButton, backButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, setupButtons);
        JButton[] buttons = {saveButton, backButton};
        buttonLine = new Line(buttons);
        buttonLine.setBackground(DartsGUI.BACKGROUND_COLOR); // Hintergrund von buttonLine auf Grau setzen

        playerPanel = new GameScreenCurrentPlayerPanel();
        strengthBar = new StrengthBarPanel();
        JComponent[] sbarelements = {strengthBar, new TransparentPanel()};
        strengthBarBar = new Bar (sbarelements);
        strengthBarBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        playerPanel.setBackground(DartsGUI.BACKGROUND_COLOR); 
        
        JComponent[] components = {instructionPanel, scrollPaneContainer, playerPanel, strengthBarBar, buttonLine};
        Bar Table = new Bar(components);
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
    
    public GameScreenCurrentPlayerPanel getPlayerPanel() {
		return playerPanel;
	}
    
    
    public void setPlayerTableData(Object[][] data) {
    	this.playerTableData = data.clone();
        this.tableModel.setDataVector(playerTableData, new Object[]{"", "", ""});
        setTabelSettings(table);
        this.revalidate();
        this.repaint();
    }
    
    public void setGameNameLabel(String string) {
    	this.gameNameLabel.setText(string);
    	this.revalidate();
        this.repaint();
    }
}