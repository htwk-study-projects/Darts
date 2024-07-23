package view;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SetupLine extends JPanel{
	
	public SetupLine(JComponent[] elements) {
		this.setLayout(new GridLayout(1, elements.length, 10, 10));
		for(JComponent element : elements) {
			this.add(element);
		}
	}
}
