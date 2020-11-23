import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GameDrunkard {                                             //1 3 5 7 9          2 4 6 8 0
    public static void main(String[] args) {
        Deque<Card> deck1 = new LinkedList<>();
        Deque<Card> deck2 = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите карты 1ого игрока");
        for (int i = 0; i < 5; i++) {
            deck1.offer(new Card(in.next()));
        }
        System.out.println("Введите карты 2ого игрока");
        for (int i = 0; i < 5; i++) {
            deck2.offer(new Card(in.next()));
        }
        Sravnenie comp = new Sravnenie();
        int k = 0;
        while ((deck1.isEmpty() != true) & (deck1.isEmpty() != true) & (k < 106)) {
            k++;
            System.out.println(deck1);
            System.out.println(deck2);
            System.out.println(comp.compare(deck1.peekFirst(), deck2.peekFirst()));
            System.out.println("/////////////////////////////");
            Card a1 = deck1.pollFirst();
            Card a2 = deck2.pollFirst();
            if (comp.compare(a1, a2) < 0 || comp.compare(a1, a2) == 9) {
                deck2.addLast(a1);
                deck2.addLast(a2);
            }
            else if (comp.compare(a1, a2) > 0 || comp.compare(a1, a2) == -9) {
                deck1.addLast(a1);
                deck1.addLast(a2);
            }
        }
        if (k >= 106) System.out.println("botva");
        if (k < 106) {
            if (deck1.isEmpty()) {
                System.out.println("Second " + k);
            }
            if (deck2.isEmpty()) {
                System.out.println("First " + k);
            }
        }
    }
}