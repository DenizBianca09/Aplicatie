import java.util.Comparator;

public class SortCursByName implements Comparator<Curs> {
    @Override
    public int compare(Curs o1, Curs o2) {
        return o1.nume.compareTo(o2.nume);
    }
}
