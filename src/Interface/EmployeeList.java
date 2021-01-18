package Interface;

import Company.Company;
import People.Employee;

import javax.swing.*;

public class EmployeeList  extends JList implements ComponentAdmin {
    MediatorAdmin mediator;
    private final DefaultListModel LIST_MODEL;

    public EmployeeList(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);

    }



    public Employee getCurrentElement() {
        return (Employee) getSelectedValue();
    }

    @Override
    public void setMediator(MediatorAdmin mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "EmployeeList";
    }


}
