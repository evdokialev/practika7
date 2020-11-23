import java.util.Stack;
import java.util.Scanner;

public class Card {
    public Card(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }
}