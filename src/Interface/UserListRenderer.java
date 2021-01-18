package Interface;

import Company.Job;
import Company.*;
import People.*;

import javax.swing.*;
import java.awt.Component;

public class UserListRenderer  extends JLabel implements ListCellRenderer {

    public UserListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        User obj = ((User)value);


        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText("Utilizator: " + obj.resume.getInfo().getFirstName() + " " + obj.resume.getInfo().getLastName());
        return this;
    }
}

