package model;

import javax.swing.*;
import java.awt.*;

public class ColorIcon implements Icon {
    private final Color color;
    private static final int SIZE = 15;

    public ColorIcon(Color color) {
        this.color = color;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, SIZE, SIZE);
    }

    public int getIconWidth() {
        return SIZE;
    }

    public int getIconHeight() {
        return SIZE;
    }
}