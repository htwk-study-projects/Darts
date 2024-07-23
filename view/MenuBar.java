package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuBar extends JPanel{
	
	public MenuBar(JComponent[] elements, int rows, int columns) {	
		this.setLayout(new GridLayout(rows, columns, 10, 10));
		for(JComponent element : elements) {
			this.add(element);
		}
	}
	
	public void menuPlacement(JPanel parent, int position, int gridRows, int gridColumns) {
		int areas = gridRows * gridColumns;
		for (int i = 0; i < areas; i++) {
            if (i == position) {
                parent.add(this);
            } else {
                parent.add(new TransparentPanel());
            }
        }
	}
}
