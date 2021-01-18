package Interface;

import People.User;

import javax.swing.*;

public class UserList extends JList implements ComponentAdmin {
    MediatorAdmin mediator;
    private final DefaultListModel LIST_MODEL;

    public UserList(DefaultListModel listModel) {
            super(listModel);
            this.LIST_MODEL = listModel;
            setModel(listModel);

            }

    public void deleteElement() {
            int index = this.getSelectedIndex();
            try {
            LIST_MODEL.remove(index);
            mediator.setElementsUserList(LIST_MODEL);
            } catch (ArrayIndexOutOfBoundsException ignored) {}

            }

    public User getCurrentElement() {
            return (User) getSelectedValue();
            }

    @Override
    public void setMediator(MediatorAdmin mediator) {
            this.mediator = mediator;
            }

    @Override
    public String getName() {
            return "UserList";
            }


}
