package view;

import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Bar extends JPanel{
	
	public Bar(JComponent[] elements) {	
		this.setLayout(new GridLayout(elements.length, 1));
		for(JComponent element : elements) {
			this.add(element);
		}
	}
	
	public void barPlacement(JPanel parent, int position) {
		parent.remove(position);
		parent.add(this, position);
        
	}
}
