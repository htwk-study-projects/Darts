package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SetupLine extends JPanel{
	
	public SetupLine(JComponent[] elements) {
		this.setLayout(new FlowLayout());
		for(JComponent element : elements) {
			this.add(element);
		}
	}
}
