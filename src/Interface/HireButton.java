package Interface;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class HireButton extends JButton implements ComponentManager{
    private MediatorManager mediator;
    public HireButton() {
        super("Hire");
    }
    @Override
    public void setMediator(MediatorManager mediator) {
        this.mediator = mediator;
    }
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.hireUser();
    }

    @Override
    public String getName() {
        return "HireButton";
    }
}
