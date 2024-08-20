package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;

public class ColorAndTextCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 0) {
            label.setText(""); // Kein Text, nur das Farbkästchen
            label.setIcon(new ColorIcon((Color) value));
        } else {
            label.setIcon(null);
        }
        return label;
    }
}