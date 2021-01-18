package Interface;

import Company.Company;
import Company.Department;

import javax.swing.*;
import java.awt.Component;

public class CompanyListRenderer extends JLabel implements ListCellRenderer {

    public CompanyListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Company obj = ((Company)value);


        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText("Companie: " + obj.getName());
        return this;
    }
}

