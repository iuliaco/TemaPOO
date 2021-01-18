package Interface;

import Company.Job;
import People.User;

import javax.swing.*;
import java.awt.Component;

public class JobListRenderer   extends JLabel implements ListCellRenderer {

    public JobListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Job obj = ((Job)value);


        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText("Job: " + obj.getJob());
        return this;
    }
}

