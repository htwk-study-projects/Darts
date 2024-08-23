package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SaveScreen extends JPanel {
	
	private JLabel title;
	protected JButton loadingButton;
	protected JButton backButton;
	private JTable savesTable;
	
	public SaveScreen() {
		
		this.setLayout(new GridLayout(3,3));	
		DartsGUI.gridLayoutFill(this, 3,3);
				
		Color background = Color.LIGHT_GRAY;

		title = new JLabel("Saved Games");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
	
		JComponent[] titleBarElements = {title, new TransparentPanel()};
		Bar titleBar = new Bar(titleBarElements);
		titleBar.setBackground(background);
		
		// Create the table with dummy data
		String[] columnNames = {"Game ID", "Date"};
		Object[][] data = {
		    {"1", "2024-08-20"},
		    {"2", "2024-08-21"},
		    {"3", "2024-08-22"},
		    {"4", "2024-08-23"}
		};
		
		// Create a table model with non-editable cells
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // All cells are non-editable
		    }
		};
		
		savesTable = new JTable(tableModel);
		setTabelSettings(savesTable);  // Apply the custom table settings
		
		JScrollPane scrollPane = new JScrollPane(savesTable);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		// Create buttons
		loadingButton = new JButton("Laden");		
		backButton = new JButton("Zurück");
		JButton[] setupButtons = {backButton, loadingButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		Line startBreakLine = new Line(setupButtons);
		startBreakLine.setBackground(background);
		
		JComponent[] startBreakBarElements = {new TransparentPanel(),new TransparentPanel(),new TransparentPanel(),startBreakLine};
		Bar startBreakBar = new Bar(startBreakBarElements);
		startBreakBar.setBackground(background);
		
		
		
		// Add components to the panel
		this.remove(1);
		this.add(titleBar, 1);
		
		this.remove(4);
		this.add(scrollPane, 4);
				
		this.remove(7);
		this.add(startBreakBar ,7);
	}
	
	Color background = Color.LIGHT_GRAY;
	
	private void setTabelSettings(JTable table) {
	    table.setOpaque(false);
	    table.setBackground(background); 
	    table.setFocusable(false);
	    table.setColumnSelectionAllowed(false); // Disable column selection
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Optional: only one row can be selected at a time
	    table.setFont(DartsGUI.FONT_NORMAL);
	    table.setRowHeight(40);
	    table.setGridColor(background);
	    
	    
        JTableHeader header = table.getTableHeader();
        header.setFont(DartsGUI.FONT_NORMAL);
        header.setResizingAllowed(false); 
        header.setReorderingAllowed(false); 
        header.setOpaque(false); 
        header.setBackground(background); 
      
        
    }
}