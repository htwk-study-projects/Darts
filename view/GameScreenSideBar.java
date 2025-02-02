package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
    private ThrowStrengthInputPanel strengthInput;
    
    public GameScreenSideBar() {

        this.setLayout(new BorderLayout());
      
        gameNameLabel = new JLabel("Spielname", SwingConstants.CENTER);
     
        JLabel instructionLabel1 = new JLabel("Tippe auf den Bildschirm damit der Dartpfeil erscheint", SwingConstants.CENTER);
        JLabel instructionLabel2 = new JLabel("Platziere den Dartpfeil mit gedrueckter Maustaste auf die gewuenschte Wurfposition", SwingConstants.CENTER);
        JLabel instructionLabel3 = new JLabel("Stelle mit der Leertaste deine Wurfstärke ein", SwingConstants.CENTER);
        JLabel instructionLabel4 = new JLabel("Tippe ein weiteres Mal zum Werfen des Dartpfeils", SwingConstants.CENTER);
        JComponent[] labels = {gameNameLabel, instructionLabel1,instructionLabel2,instructionLabel3, instructionLabel4, new TransparentPanel()};
        DartsGUI.fontAdjust(DartsGUI.FONT_SMALL, labels);
        gameNameLabel.setFont(DartsGUI.FONT_NORMAL);

        instructionPanel = new Bar(labels);
        instructionPanel.setOpaque(false);

        // Dummy Table
        playerTableData = new Object[][]{
            {Color.RED, "501", "Spieler 1"},
            {Color.BLUE, "501", "Spieler 2"},
            {Color.GREEN, "501", "Spieler 3"},
            {Color.YELLOW, "501", "Spieler 4"},
        };

        tableModel = new DefaultTableModel(playerTableData, new Object[]{"", "", ""}) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel) {
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 0) { 
                    return new IconRendererForTable();
                }
                return super.getCellRenderer(row, column);
            }
        };
        setTabelSettings(table);

        scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false); 
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
       
        scrollPaneContainer = new JPanel(new BorderLayout());
        scrollPaneContainer.setOpaque(false);
  
        leftSpace = new TransparentPanel();
        leftSpace.setPreferredSize(new java.awt.Dimension(80, 0));        
        
        scrollPaneContainer.add(instructionPanel, BorderLayout.WEST); 
        scrollPaneContainer.add(leftSpace, BorderLayout.WEST); 
        scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);
        
        backButton = new JButton("Spiel abbrechen");
    	JButton[] setupButtons = {backButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_NORMAL, setupButtons);
        JButton[] buttons = {backButton};
        buttonLine = new Line(buttons);
        buttonLine.setBackground(DartsGUI.BACKGROUND_COLOR);

        playerPanel = new GameScreenCurrentPlayerPanel();
        strengthInput = new ThrowStrengthInputPanel();
        JComponent[] sbarelements = {strengthInput, new TransparentPanel(), new TransparentPanel(), new TransparentPanel()};
        strengthBarBar = new Bar (sbarelements);
        strengthBarBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        strengthInput.requestFocusInWindow();
        playerPanel.setBackground(DartsGUI.BACKGROUND_COLOR); 
        
        JComponent[] components = {instructionPanel, scrollPaneContainer, playerPanel, strengthBarBar, buttonLine};
        Bar Table = new Bar(components);
        Table.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        this.add(Table, BorderLayout.CENTER);
    }
    
    private void setTabelSettings(JTable table) {
        table.setOpaque(false);
        table.setBackground(new Color(0, 0, 0, 0));
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
    
    public ThrowStrengthInputPanel getStrengthInput() {
    	return strengthInput;
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