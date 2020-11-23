import java.util.Scanner;
import java.util.Stack;

class SimpleCardGame {
    public static void main(String[] args) {
        Stack<Card> deck1 = new Stack<>();
        Stack<Card> deck2 = new Stack<>();
        Stack<Card> deck3 = new Stack<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите карты 1ого игрока");
        for (int i = 0; i < 5; i++) {
            deck2.push(new Card(in.next()));
        }
        for (int i = 0; i < 5; i++) {
            deck1.push(deck2.pop());
        }
        System.out.println("Введите карты 2ого игрока");
        for (int i = 0; i < 5; i++) {
            deck3.push(new Card(in.next()));
        }
        for (int i = 0; i < 5; i++) {
            deck2.push(deck3.pop());
        }

        Sravnenie comp = new Sravnenie();
        int k = 0;
        while ((!deck1.empty()) & (!deck2.empty()) & (k < 106)) {
            System.out.println(deck1);
            System.out.println(deck2);
            System.out.println(deck3);
            System.out.println(comp.compare(deck1.peek(), deck2.peek()));
            System.out.println("/////////////////////////////");
            k++;
            Card a1 = deck1.peek();
            Card a2 = deck2.peek();
            if (comp.compare(deck1.pop(), deck2.pop()) < 0 || comp.compare(a1, a2) == 9) {
                int d2 = deck2.size();
                for (int i = 0; i < d2; i++) {
                    deck3.push(deck2.pop());
                }
                deck2.push(a2);
                deck2.push(a1);
                int d3 = deck3.size();
                for (int i = 0; i < d3; i++) {
                    deck2.push(deck3.pop());
                }
            }
            else if (comp.compare(a1, a2) > 0 || comp.compare(a1, a2) == -9) {
                int d1 = deck1.size();
                for (int i = 0; i < d1; i++) {
                    deck3.push(deck1.pop());
                }
                deck1.push(a2);
                deck1.push(a1);
                int d3 = deck3.size();
                for (int i = 0; i < d3; i++) {
                    deck1.push(deck3.pop());
                }
            }
        }
        if (k >= 106) System.out.println("botva");
        if (k < 106) {
            if (deck1.empty()) {
                System.out.println("Second " + k);
            }
            if (deck2.empty()) {
                System.out.println("First " + k);
            }
        }
    }                                                   //1 3 5 7 9          2 4 6 8 0
}
