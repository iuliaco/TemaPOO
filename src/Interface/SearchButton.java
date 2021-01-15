package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SearchButton extends JButton implements Component{
    private MediatorProfile mediator;
    public SearchButton() {
        super("Search");
    }
    @Override
    public void setMediator(MediatorProfile mediator) {
        this.mediator = mediator;
    }
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.displayUser();
    }

    @Override
    public String getName() {
        return "SearchButton";
    }
}
