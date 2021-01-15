package Interface;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class SearchBar extends JTextField implements Component{
    private MediatorProfile mediator;

    @Override
    public void setMediator(MediatorProfile mediator) {
        this.mediator = mediator;
    }
    protected void processComponentKeyEvent(KeyEvent keyEvent) {

    }

    @Override
    public String getName() {
        return "SearchBar";
    }
}
