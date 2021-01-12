package Interface;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class SearchBar extends JTextField implements Component{
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    protected void processComponentKeyEvent(KeyEvent keyEvent) {

    }

    @Override
    public String getName() {
        return "SearchBar";
    }
}
