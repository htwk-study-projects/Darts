package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuBar extends JPanel{
	
	public MenuBar(JButton[] buttons, int rows, int columns) {
		
		this.setLayout(new GridLayout(rows, columns, 10, 10));
		//this.setBorder(new LineBorder(Color.black));
		for(JButton b : buttons) {
			this.add(b);
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
