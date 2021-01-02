public class Recruiter extends Employee{
    private double rating;
    public Recruiter(Resume resume) {
        super(resume);
        rating = 5;
    }
    public double evaluate(Job job, User user) {
        double score = rating * user.getTotalScore();
        Request<Job, Consumer> request = new Request<>(job, user, this, score);
        String company = this.getCompany();
        Application application = Application.getInstance();
        application.getCompany(company).getManager().addRequest(request);
        return score;
    }
}
