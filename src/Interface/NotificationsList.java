package Interface;

import Company.Notification;
import People.User;

import javax.swing.*;

public class NotificationsList extends JList implements Component {
    MediatorProfile mediator;
    private final DefaultListModel LIST_MODEL;

    public NotificationsList(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);

    }



    public Notification getCurrentElement() {
        return (Notification) getSelectedValue();
    }

    @Override
    public void setMediator(MediatorProfile mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "NotificationsList";
    }


}
