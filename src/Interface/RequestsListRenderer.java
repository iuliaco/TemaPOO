package Interface;

import Company.Job;
import Company.Request;
import People.Consumer;

import javax.swing.*;
import java.awt.Component;

public class RequestsListRenderer extends JLabel implements ListCellRenderer {

    public RequestsListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Request<Job, Consumer> obj = ((Request<Job, Consumer>)value);


        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setText("Job: " + obj.getKey().getJob() + " Recruiter: " + obj.getValue2().resume.getInfo().getFirstName() + " " + obj.getValue2().resume.getInfo().getLastName() + " Utilizator: " + obj.getValue1().resume.getInfo().getFirstName() + " " + obj.getValue1().resume.getInfo().getLastName());
        return this;
    }
}
