import java.util.ArrayList;

public class Manager extends Employee {
    ArrayList<Request<Job, Consumer>> requests;

    public Manager(Resume resume) {
        super(resume);
    }

    public void process(Job job) {

    }

}
