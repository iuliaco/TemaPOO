package Interface;

import Company.Company;

import javax.swing.*;

public class JobList extends JList implements ComponentAdmin {
    MediatorAdmin mediator;
    private final DefaultListModel LIST_MODEL;

    public JobList(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);

    }



    public Company getCurrentElement() {
        return (Company) getSelectedValue();
    }

    @Override
    public void setMediator(MediatorAdmin mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "JobList";
    }


}
