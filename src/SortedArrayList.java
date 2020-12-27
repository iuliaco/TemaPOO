import java.util.ArrayList;
import java.util.Comparator;

public class SortedArrayList<T> extends ArrayList<T> {
    @Override
    public boolean add(T t) {
        add(t);
        sort((Comparator<? super T>) t);
        return true;
    }

    @Override
    public void add(int index, T element) {
        this.add(element);
    }

}
