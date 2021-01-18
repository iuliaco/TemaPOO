package Interface;

import People.Employee;
import People.User;

import javax.swing.*;
import java.awt.Component;

public class EmployeeListRenderer   extends JLabel implements ListCellRenderer {

    public EmployeeListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Employee obj = ((Employee)value);


        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText("Angajat: " + obj.resume.getInfo().getFirstName() + " " + obj.resume.getInfo().getLastName());
        return this;
    }
}

