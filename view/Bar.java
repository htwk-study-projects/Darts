package view;

import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * A JPanel subclass that arranges its child components in a column.
 */
public class Bar extends JPanel{
	
	/**
     * Constructs a new Bar panel with the specified components.
     *
     * @param elements An array of JComponent elements to be added to the panel.
     */
	public Bar(JComponent[] elements) {	
		this.setLayout(new GridLayout(elements.length, 1));
		for(JComponent element : elements) {
			this.add(element);
		}
	}
	
	public void setComponents(JComponent[] elements) {
        this.removeAll();
        for (JComponent element : elements) {
            this.add(element);
        }
	}
	
	/**
     * Replaces the component at the specified position in the parent panel, gridlayout obligatory, with this Bar panel.
     *
     * @param parent The parent panel where this Bar panel should be placed.
     *  			 It has to be using a {@link GridLayout}.
     * @param position The position in the parent panel where this Bar panel should be added.
     */
	public void barPlacementInGridLayout(JPanel parent, int position) {
		parent.remove(position);
		parent.add(this, position);   
	}
}
