import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        List<Request<Job, Consumer>> candidates = new ArrayList<>();
        for (Request req: requests) {
            if(req.getKey() == job) {
                candidates.add(req);
                requests.remove(req);
            }
        }
        Collections.sort(candidates, new Comparator<Request<Job, Consumer>>() {
            @Override
            public int compare(Request<Job, Consumer> o1, Request<Job, Consumer> o2) {
                return o1.getScore() > o2.getScore()? 1 : -1;
            }
        });
        int noPositions = job.getNoPositions();
        Application app = Application.getInstance();
        Company company = app.getCompany(job.getCompany());
        Department jobDept = null;
        for (Department department: company.getDepartments()) {
            if(department.getJobs().contains(job)) {
                jobDept = department;
                break;
            }
        }
        for (Request<Job, Consumer> candidate: candidates) {
            if(app.getUsers().contains(candidate.getValue1())) {
              User user = (User) candidate.getValue1();
              Employee newEmployee = user.convert();
              if(app.remove(user) == false) {
                  System.err.println("Nu am putut gasi utilizatorul pe care vreti sa-l stergeti.");
              }
              newEmployee.setCompany(job.getCompany());
              newEmployee.setSalary(job.getSalary());
              company.add(newEmployee, jobDept);
              noPositions--;
            }
            if(noPositions == 0) {
                break;
            }
        }
        job.setOpen(false);
    }

}
