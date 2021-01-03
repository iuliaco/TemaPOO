import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Consumer {
    Resume resume;
    ArrayList<Consumer> acquaintances;

    static class Resume {
        private Information info;
        private SortedArrayList<Education> educations;
        private SortedArrayList<Experience> experiences;

        // educatie si experienta profi sortate
        public Resume() {
            educations = new SortedArrayList<Education>();
            experiences = new SortedArrayList<Experience>();
        }
        public Resume(ResumeBuilder builder) {

        }
        public Resume(Information info) {
            this();
            this.info = info;
        }
        public static  class ResumeBuilder{
            private Information info;
            private SortedArrayList<Education> educations;
            private SortedArrayList<Experience> experiences;
            {
                educations = new SortedArrayList<>();
                experiences = new SortedArrayList<>();
            }
            public ResumeBuilder info(String name, String surname, String email, String phone, String birthdate, String sex) {
                this.info = new Information(name, surname, email, phone, birthdate, sex);
                return this;
            }
            public ResumeBuilder language(String name, String level) {
                this.info.addLanguages(name, level);
                return this;
            }
            public ResumeBuilder education(LocalDate startDate, LocalDate endDate, String institutionName, String educationLevel, double meanGPA) {
                try {
                    this.educations.add(new Education(startDate, endDate, institutionName, educationLevel, meanGPA));
                } catch (InvalidDatesException e) {
                    e.printStackTrace();
                }
                return this;
            }
            public ResumeBuilder experience(LocalDate startDate, LocalDate endDate, String position, String company) {
                try {
                    this.experiences.add(new Experience(startDate, endDate, position, company));
                } catch (InvalidDatesException e) {
                    e.printStackTrace();
                }
                return this;
            }
            public Resume build() {
                return new Resume(this);
            }
        }
        public void addEducation(Education education) {
            this.educations.add(education);
        }

        public void addExperience(Experience experience) {
            this.experiences.add(experience);
        }

        public SortedArrayList<Education> getEducations() {
            return educations;
        }

        public SortedArrayList<Experience> getExperiences() {
            return experiences;
        }
    }

    public Consumer() {
        this.acquaintances = new ArrayList<Consumer>();
    }

    public Consumer(Resume resume) {
        this();
        this.resume = resume;
    }

    public void add(Education education) {
        resume.addEducation(education);
    }

    public void add(Experience experience) {
        resume.addExperience(experience);
    }

    public void add(Consumer consumer) {
        acquaintances.add(consumer);
    }

    public int getDegreeInFriendship(Consumer consumer) {
        return 1;
    }

    public void remove(Consumer consumer) {
        acquaintances.remove(consumer);
    }

    public Integer getGraduationYear() {
        for (Education education : resume.getEducations()) {
            if (education.getEducationLevel().equals("licenta")) {
                if (education.getEndDate() == null)
                    return null;
                else
                    return education.getEndDate().getYear();
            }
        }
        return null;
    }

    public Double meanGPA() {
        int noEducations = 0;
        double GPA = 0;
        for (Education education : resume.getEducations()) {
            GPA = GPA + education.getMeanGPA();
            noEducations++;
        }
        return (double) GPA/noEducations;
    }


}
