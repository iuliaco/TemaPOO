package People;

import Company.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Manager extends Employee {
    ArrayList<Request<Job, Consumer>> requests;

    public Manager(Resume resume) {
        super(resume);
        requests = new ArrayList<>();
    }
    public void addRequest(Request request) {
        requests.add(request);
    }
    public void process(Job job) {
        // fac o lista separata cu requesturile jobului
        List<Request<Job, Consumer>> candidates = new ArrayList<>();
        for (int i = 0 ; i < requests.size(); i++) {
            Request req = requests.get(i);
            if(req.getKey() == job) {
                candidates.add(req);
                requests.remove(req);
                i--;
            }
        }
        // le sortez dupa scor
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
        // iau pe rand in limita locurilor si angajez
        for (Request<Job, Consumer> candidate: candidates) {
            if(app.getUsers().contains(candidate.getValue1()) && noPositions > 0) {
              User user = (User) candidate.getValue1();
              System.out.println("angajez pe " + user.resume.getInfo().getLastName());
              Employee newEmployee = user.convert();
              if(app.remove(user) == false) {
                  System.err.println("Nu am putut gasi utilizatorul pe care vreti sa-l stergeti.");
              }
              newEmployee.setCompany(job.getCompany());
              newEmployee.setSalary(job.getSalary());
              company.add(newEmployee, jobDept);
              for (Company comp: app.getCompanies()) {
                  comp.removeObserver(user);
              }
              noPositions--;
            }
            // cand termin trimit la restul notificare ca au fost respinsi
            if(noPositions == 0) {
                Notification notif = new Notification("Ai fost respins de la jobul de " + job.getJob(), job.getCompany());
                User user = (User) candidate.getValue1();
                company.notifyObserver(user,notif);
            }
        }
        job.setOpen(false);
        Notification notification = new Notification("S-a inchis jobul de " + job.getJob(), job.getCompany());
        app.getCompany(job.getCompany()).notifyAllObservers(notification);
    }


    public ArrayList<Request<Job, Consumer>> getRequests() {
        return requests;
    }

    @Override
    public String toString() {
        return "Manager" +
                "requests=" + requests +
                "" + resume +
//                ", acquaintances=" + acquaintances +
                " ";
    }
}
