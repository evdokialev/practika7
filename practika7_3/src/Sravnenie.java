import java.util.Comparator;

public class Sravnenie implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return CharSequence.compare(o1.getName(), o2.getName());
    }
}