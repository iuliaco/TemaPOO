package Interface;

import Company.Department;
import People.User;

import javax.swing.*;
import java.awt.Component;

public class DepartamentListRenderer extends JLabel implements ListCellRenderer {

    public DepartamentListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Department obj = ((Department)value);


        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText("Departament: " + obj.getName());
        return this;
    }
}

