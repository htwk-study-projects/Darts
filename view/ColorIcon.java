package view;

import javax.swing.*;
import java.awt.*;

public class ColorIcon implements Icon {
    
	private final Color color;
    private final static int SIZE = 15;

    public ColorIcon(Color value) {
        this.color = value;
    }

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
}