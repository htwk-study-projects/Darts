package view;

import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Bar extends JPanel{
	
	public Bar(JComponent[] elements, int rows, int columns) {	
		this.setLayout(new GridLayout(rows, columns, 8, 8));
		for(JComponent element : elements) {
			this.add(element);
		}
	}
	
	public void barPlacement(JPanel parent, int position) {
		parent.remove(position);
		parent.add(this, position);
        
	}
}
