package Interface;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class SalaryText extends JTextField implements ComponentAdmin{
    private MediatorAdmin mediator;

    @Override
    public void setMediator(MediatorAdmin mediator) {
        this.mediator = mediator;
    }
    protected void processComponentKeyEvent(KeyEvent keyEvent) {

    }

    @Override
    public String getName() {
        return "SalaryText";
    }
}