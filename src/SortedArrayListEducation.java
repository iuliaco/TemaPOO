import java.util.ArrayList;
import java.util.Collections;

public class SortedArrayListEducation  {
    public ArrayList<Education> educations;

    public SortedArrayListEducation(ArrayList<Education> educations) {
        this.educations = educations;
    }

    public SortedArrayListEducation() {
        this.educations = new ArrayList<>();
    }

    public boolean add(Education t) {
        educations.add(t);
        Collections.sort(educations);
        return true;
    }


    public void add(int index, Education element) {
        this.add(element);
    }

    @Override
    public String toString() {
        return "" + educations;
    }
}
