package blackjack.GameController;

import java.util.ArrayList;
import java.util.Collections;

// After creating a Deck Variable, we should Reset and Shuffle a Deck before using it.
// like `Deck main_deck = new Deck;` -- then `main_deck.reset()` then `main_deck.shuffle()`
public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        reset();
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            reset();
            shuffle();
        }
        return cards.remove(cards.size() - 1);
    }

    private void reset() {
        cards.clear(); // Clears The cards ArrayList.
        String[] suits = {"♠", "♥", "♦", "♣"};
        for (String suit : suits) { // For each Suit in the list suits
            for (int rank = 1; rank <= 13; rank++) { // iterate through all possible Ranks
                cards.add(new Card(rank, suit)); // Add a new Card with Rank and Suit. This makes a deck.
            }
        }
    }
}


