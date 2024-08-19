package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Line extends JPanel{
	
	public Line(JComponent[] elements) {
		this.setLayout(new FlowLayout());
		for(JComponent element : elements) {
			this.add(element);
		}
	}
}
