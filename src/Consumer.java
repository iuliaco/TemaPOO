import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Consumer {
    Resume resume;
    ArrayList<Consumer> acquaintances;

    static class Resume {
        private Information info;
        private SortedArrayListEducation educations;
        private SortedArrayListExperience experiences;

        public Information getInfo() {
            return info;
        }

        public void setInfo(Information info) {
            this.info = info;
        }

        public void setEducations(SortedArrayListEducation educations) {
            this.educations = educations;
        }

        public void setExperiences(SortedArrayListExperience experiences) {
            this.experiences = experiences;
        }

        // educatie si experienta profi sortate
        public Resume() {
            educations = new SortedArrayListEducation();
            experiences = new SortedArrayListExperience();
        }
        public Resume(ResumeBuilder builder) {
            this();
            this.educations = builder.educations;
            this.experiences = builder.experiences;
            this.info = builder.info;
        }
        public Resume(Information info) {
            this();
            this.info = info;
        }
        public static  class ResumeBuilder{
            private Information info;
            private SortedArrayListEducation educations;
            private SortedArrayListExperience experiences;
            {
                educations = new SortedArrayListEducation();
                experiences = new SortedArrayListExperience();
            }
            public ResumeBuilder info(String firstName, String lastName, String email, String phone, LocalDate birthdate, String sex) {
                this.info = new Information(lastName, firstName, email, phone, birthdate, sex);
                return this;
            }
            public ResumeBuilder language(String name, String level) {
                this.info.addLanguages(name, level);
                return this;
            }
            public ResumeBuilder languages(HashMap<String, String> languages) {
                this.info.setLanguages(languages);
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
            public ResumeBuilder educations(SortedArrayListEducation educations) {
                this.educations.educations.addAll(educations.educations);
                return this;
            }
            public ResumeBuilder experiences(SortedArrayListExperience experiences) {
                this.experiences.experiences.addAll(experiences.experiences);
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
            public Resume build() throws ResumeIncompleteException{
                if(this.educations.educations.size() == 0) {
                    throw new ResumeIncompleteException();
                }
                return new Resume(this);
            }
        }
        public void addEducation(Education education) {
            this.educations.add(education);
        }

        public void addExperience(Experience experience) {
            this.experiences.add(experience);
        }

        @Override
        public String toString() {
            return "Resume{" +
                    "info=" + info +
                    ", educations=" + educations +
                    ", experiences=" + experiences +
                    '}';
        }

        public SortedArrayListEducation getEducations() {
            return educations;
        }

        public SortedArrayListExperience getExperiences() {
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
        HashMap<Consumer, Integer> list;
        ArrayList<Consumer> friends;
        list = new HashMap<>();
        friends = new ArrayList<>();
        list.put(this, 0);
        friends.add(this);
        for (int i = 0; i < friends.size(); i++) {
            Consumer friend = friends.get(i);
            for (Consumer friendFriend: friend.acquaintances) {
                if(friendFriend.equals(consumer)) {
                    int pos = list.get(friend);
                    return pos + 1;
                }
                if(!friends.contains(friendFriend)) {
                    int pos = list.get(friend);
                    list.put(friendFriend, pos + 1);
                    friends.add(friendFriend);
                }
            }
        }
        return -1;
    }

    public void remove(Consumer consumer) {
        acquaintances.remove(consumer);
    }

    public Integer getGraduationYear() {
        for (Education education : resume.getEducations().educations) {
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
        for (Education education : resume.getEducations().educations) {
            GPA = GPA + education.getMeanGPA();
            noEducations++;
        }
        return (double) GPA/noEducations;
    }


}
