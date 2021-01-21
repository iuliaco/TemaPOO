package Company;

import People.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Company implements Subject{

    private String name;
    private Manager manager;
    private ArrayList<Department> departments;
    private ArrayList<Recruiter> recruiters;
    public ArrayList<Observer> observerList;

    public Company() {
        departments = new ArrayList<>();
        recruiters = new ArrayList<>();
        observerList = new ArrayList<>();
    }
    public Company(String name) {
        this();
        this.name = name;
    }

    public void add(Department department){
        departments.add(department);
    }

    public void add(Recruiter recruiter) {
        recruiters.add(recruiter);
    }

    public void add(Employee employee, Department department) {
        departments.get(departments.indexOf(department)).add(employee);
    }
    public Department findDepartament(String departament) {
        if("IT".equals(departament)) {
            for (Department dept: departments) {
                if(dept instanceof IT){
                    return dept;
                }
            }
        } else if("Management".equals(departament)) {
            for (Department dept: departments) {
                if(dept instanceof Management){
                    return dept;
                }
            }
        } else if("Marketing".equals(departament)) {
            for (Department dept: departments) {
                if(dept instanceof Marketing){
                    return dept;
                }
            }
        } else if("Finance".equals(departament)) {
            for (Department dept: departments) {
                if(dept instanceof Finance){
                    return dept;
                }
            }
        }
        return null;
    }
    public void remove(Employee employee) {
        if(recruiters.contains(employee))
            recruiters.remove(employee);
        for (Department department: departments) {
            if(department.getEmployees().contains(employee))
                department.remove(employee);
        }
    }

    public void remove(Department department) {
        if (departments.contains(department)) {
            int index = departments.indexOf(department);
            for ( Employee employee: departments.get(index).getEmployees()) {
                if(recruiters.contains(employee)) {
                    recruiters.remove(employee);
                }
                departments.get(index).remove(employee);
            }
            departments.remove(index);
        }

    }

    public void remove(Recruiter recruiter) {
        if(recruiters.contains(recruiter)) {
            recruiters.remove(recruiter);
        }
    }

    public void move(Department source, Department destination) {
        destination.setAvailableJobs(source.getAvailableJobs());
        destination.setEmployees(source.getEmployees());
        departments.remove(source);
        departments.add(destination);
    }

    public void move(Employee employee, Department newDepartment) {
        for (Department departament: departments) {
            if(departament.getEmployees().contains(employee)) {
                departament.remove(employee);
                break;
            }
        }
        newDepartment.add(employee);
    }

    public boolean contains(Department department) {
        return departments.contains(department);
    }

    public boolean contains(Employee employee) {
        for (Department departament: departments) {
            if(departments.contains(employee))
                return true;
        }
        return false;
    }

    public boolean contains(Recruiter recruiter) {
        if(recruiters.contains(recruiter))
            return true;
        return false;
    }

    // fac distanta dintre toti recruiterii
    // si userul meu
    public Recruiter getRecruiter(User user) {
        int max = 0;
        Recruiter finalR = null;
        for (Recruiter recruiter: recruiters) {
            int degree = recruiter.getDegreeInFriendship(user);
            System.out.println(degree);
            if(degree > max) {
                max = degree;
                finalR = recruiter;
            } else if(degree == max) {
                if(finalR.getRating() < recruiter.getRating()) {
                    finalR = recruiter;
                }

            }
        }
        return finalR;
    }

    public ArrayList<Job> getJobs() {
        ArrayList<Job> jobs = new ArrayList<>();
        for (Department departament: departments) {
             jobs.addAll(departament.getJobs());
        }
        return jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(ArrayList<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }

    @Override
    public String toString() {
        return "\nCompany{" +
                "name='" + name + '\'' +
                ", manager=" + manager +
                ", departments=" + departments +
                ", \nrecruiters=" + recruiters +
                '}';
    }

    @Override
    public void addObserver(User user) {
        observerList.add(user);
    }

    @Override
    public void removeObserver(User c) {
        observerList.remove(c);
    }

    // iterez prin observeri si dau update
    @Override
    public void notifyAllObservers(Notification notification) {
        for (Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
            Observer o = it.next();
            o.update(notification);
        }
    }
    // trimit notificare la un singur usr
    @Override
    public void notifyObserver(User user, Notification notification) {
        if(observerList.contains(user)) {
            user.update(notification);
        }
    }
}

