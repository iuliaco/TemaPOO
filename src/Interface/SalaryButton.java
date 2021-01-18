package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SalaryButton extends JButton implements ComponentAdmin {
    private MediatorAdmin mediator;
    public SalaryButton() {
        super("Salary");
    }
    @Override
    public void setMediator(MediatorAdmin mediator) {
        this.mediator = mediator;
    }
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.showSalaryTotal();
    }

    @Override
    public String getName() {
        return "SalaryButton";
    }
}
