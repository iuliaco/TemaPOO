public class Recruiter extends Employee{
    private int rating;
    public Recruiter(Resume resume) {
        super(resume);
        rating = 5;
    }
    public int evaluate(Job job, User user) {

    }
}
