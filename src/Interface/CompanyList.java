package Interface;

import Company.Company;
import People.User;

import javax.swing.*;

public class CompanyList extends JList implements ComponentAdmin {
    MediatorAdmin mediator;
    private final DefaultListModel LIST_MODEL;

    public CompanyList(DefaultListModel listModel) {
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
        return "CompanyList";
    }


}
