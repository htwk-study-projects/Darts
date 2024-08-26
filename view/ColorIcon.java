package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * An Icon that is a colored circle.
 */ 
public class ColorIcon implements Icon {
    
	private Color color;
	private final static int SIZE = 15;

    /**
     * Constructs a ColorIcon with a specified color.
     *
     * @param color The color of the circle
     */
    public ColorIcon(Color value) {
        this.color = value;
    }
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, SIZE, SIZE);
    }

    public int getIconWidth() {
        return SIZE;
    }

    public int getIconHeight() {
        return SIZE;
    }
    
	public Color getColor() {
		return color;
	}
	
    public void setColor(Color color) {
		this.color = color;
	}

}