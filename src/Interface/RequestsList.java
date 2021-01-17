package Interface;

import Company.Request;

import javax.swing.*;
import java.awt.Component;

public class RequestsList extends JList implements ComponentManager {
    MediatorManager mediator;
    private final DefaultListModel LIST_MODEL;

    public RequestsList(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);

    }

    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            LIST_MODEL.remove(index);
            mediator.setElementsList(LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException ignored) {}

    }

    public Request getCurrentElement() {
        return (Request) getSelectedValue();
    }

    @Override
    public void setMediator(MediatorManager mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "RequestsList";
    }


}
