package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * A JPanel subclass that arranges its child components in a single horizontal line.
 */
public class Line extends JPanel{
	
	/**
     * Constructs a new Line panel with the specified components.
     *
     * @param elements An array of JComponent elements to be added to the panel.
     */
	public Line(JComponent[] elements) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		for(JComponent element : elements) {
			this.add(element);
		}
	}
}
