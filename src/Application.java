import java.util.ArrayList;
import java.util.List;

public class Application {
    public ArrayList<Company> companies;
    public ArrayList<User> users;

    public Application() {
        companies = new ArrayList<>();
        users = new ArrayList<>();
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }
    public Company getCompany(String name) {
        for (Company company: companies) {
            if(company.getName().equals(name)) {
                return company;
            }
        }
        return null;
    }
    public void add(Company company) {
        companies.add(company);
    }
    public void add(User user) {
        users.add(user);
    }
    public boolean remove(Company company) {
        if(companies.contains(company)) {
            companies.remove(company);
            return true;
        }
        return false;
    }
    public boolean remove(User user) {
        if(users.contains(user)) {
            users.remove(user);
            return true;
        }
        return false;
    }
    public ArrayList<Job> getJobs(List<String> companies){
        ArrayList<Job> jobs = new ArrayList<>();
        for (String companyName: companies) {
            for (Job job: getCompany(companyName).getJobs()) {
                if(job.getOpen()) {
                    jobs.add(job);
                }
            }
        }
        return jobs;
    }
}
