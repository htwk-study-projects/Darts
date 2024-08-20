package view;


import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class IconRenderer extends DefaultTableCellRenderer {

    public JComponent getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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