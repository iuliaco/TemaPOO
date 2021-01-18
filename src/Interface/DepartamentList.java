package Interface;

import Company.*;

import javax.swing.*;

public class DepartamentList  extends JList implements ComponentAdmin {
    MediatorAdmin mediator;
    private final DefaultListModel LIST_MODEL;

    public DepartamentList(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);

    }



    public Department getCurrentElement() {
        return (Department) getSelectedValue();
    }

    @Override
    public void setMediator(MediatorAdmin mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "DepartamentList";
    }


}
