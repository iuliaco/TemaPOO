package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SearchButton extends JButton implements Component{
    private Mediator mediator;
    public SearchButton() {
        super("Search");
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    protected void fireActionPerformed(ActionEvent actionEvent) {
        ;
    }

    @Override
    public String getName() {
        return "SearchButton";
    }
}
