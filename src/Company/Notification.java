package Company;

public class Notification {
    private String title;
    private String company;

    public Notification(String title, String company) {
        this.title = title;
        this.company = company;
    }

    @Override
    public String toString() {
        return title + "la compania " + company + '.';
    }
}
