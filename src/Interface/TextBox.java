package Interface;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TextBox extends JTextArea implements Component{
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    protected void processComponentKeyEvent(KeyEvent keyEvent) {

    }

    @Override
    public String getName() {
        return "TextBox";
    }
}
