import java.util.ArrayList;

public class Manager extends Employee {
    ArrayList<Request<Job, Consumer>> requests;

    public Manager(Resume resume) {
        super(resume);
        ArrayList<Request<Job, Consumer>> requests = new ArrayList<>();
    }
    public void addRequest(Request request) {
        requests.add(request);
    }
    public void process(Job job) {

    }

}
