package Interface;

import javax.swing.*;

public interface MediatorAdmin {
    void registerComponent(ComponentAdmin component);
    void createGUI();
    void showSalaryTotal();
    void displayUser();
    void setElementsUserList(ListModel list);
    void setElementsCompanyList(ListModel list);
    void setElementsDepartamentList(ListModel list);
    void setElementsEmployeeList(ListModel list);
    void setElementsJobList(ListModel list);
}
