package Interface;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class RequestsText extends JTextArea implements ComponentManager{
    private MediatorManager mediator;

    @Override
    public void setMediator(MediatorManager mediator) {
        this.mediator = mediator;
    }
    protected void processComponentKeyEvent(KeyEvent keyEvent) {

    }

    @Override
    public String getName() {
        return "RequestsText";
    }


}
