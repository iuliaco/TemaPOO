import javax.swing.*;

public class AdminPage extends JFrame{

    private JPanel AdminPage;
    private JLabel Utilizatori;
    private JLabel Companii;
    private JList<String> ListaUtilizatori;
    private JLabel UTEST;
    private JScrollPane Wow;
    private JTextField textField1;

    public AdminPage(String title) {
        super(title);
        AdminPage = new JPanel();
        Utilizatori = new JLabel("Utilizatori");
        Companii = new JLabel("Companii");
        ListaUtilizatori = new JList<>();
        AdminPage.add(Utilizatori);
        AdminPage.add(Companii);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(AdminPage);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new AdminPage("Admin Page");
        frame.setVisible(true);
    }

}
