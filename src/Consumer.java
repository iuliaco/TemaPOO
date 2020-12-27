import java.util.ArrayList;

public abstract class Consumer {
    Resume resume;
    ArrayList<Consumer> acquaintances;
    class Resume {
        private Information info;
        private SortedArrayList<Education> educations;
        private SortedArrayList<Experience> experiences;
        // educatie si experienta profi sortate
        public Resume() {
            educations = new SortedArrayList<Education>();
            experiences = new SortedArrayList<Experience>();
        }
        public Resume(Information info) {
            this();
            this.info = info;
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
        return 1;
    }
    public Double meanGPA() {
        return 1.0;
    }



}
