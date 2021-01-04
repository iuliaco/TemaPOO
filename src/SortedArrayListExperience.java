import java.util.ArrayList;
import java.util.Collections;

public class SortedArrayListExperience {
    public ArrayList<Experience> experiences;

    public SortedArrayListExperience(ArrayList<Experience> experiences) {
        this.experiences = experiences;
    }

    public SortedArrayListExperience() {
        this.experiences = new ArrayList<>();
    }

    public boolean add(Experience t) {
        experiences.add(t);
        Collections.sort(experiences);
        return true;
    }

    public void add(int index, Experience element) {
        this.add(element);
    }

    @Override
    public String toString() {
        return "" + experiences;
    }
}

