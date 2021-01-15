package Interface;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TextBox extends JTextArea implements Component{
    private MediatorProfile mediator;

    @Override
    public void setMediator(MediatorProfile mediator) {
        this.mediator = mediator;
    }
    protected void processComponentKeyEvent(KeyEvent keyEvent) {

    }

    @Override
    public String getName() {
        return "TextBox";
    }


}
