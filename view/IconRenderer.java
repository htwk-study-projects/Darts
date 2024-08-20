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
            Color color = (Color) value;
            String playerName = (String) table.getModel().getValueAt(row, 2);
            label.setText(playerName);
            label.setIcon(new ColorIcon(color));
            label.setIconTextGap(10); // Abstand zwischen dem Farbkästchen und dem Text auf 5 Pixel setzen
        } else {
            label.setText(value.toString());
        }
        return label;
    }
}