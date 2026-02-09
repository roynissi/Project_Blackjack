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

class Card {
    private final int rank; // 1(Ace), 2-10, 11(J), 12(Q), 13(K)
    private final String suit;

    Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    int getRank() {
        return rank;
    }

    int getBaseValue() {
        if (rank == 1) return 11; // Ace value = 11
        if (rank >= 10) return 10; // 10, J, Q, and K have a value of 10
        return rank; // Numbers 2-9's value is the same as there rank.
    }

    boolean isAce() { // Returns true if the Rank is 1 (rank will be one if it is an Ace)
        return rank == 1;
    }

    @Override
    public String toString() {
        String face;
        if (rank == 1) face = "A"; // Rank One shows "A" because it is Ace
        else if (rank == 11) face = "J"; // Same for J, Q, K
        else if (rank == 12) face = "Q";
        else if (rank == 13) face = "K";
        else face = String.valueOf(rank); // If not a letter card the String is the number
        return face + suit; // Returns the now set Face, and the already set suit (clubs, hearts, etc. as ♣, and ♥) 
    }
}

class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();
    // Create a list of cards called cards

    void addCard(Card card) {
        cards.add(card);
    } // Add a card to the list of cards

    int getValue() {
        int total = 0;
        int aces = 0;
        for (Card c : cards) { // For each Card in the list of cards. 
            total += c.getBaseValue(); // Add cards base value to the total (i.e. card 2 Clubs's value is 2)
            if (c.isAce()) aces++;  // If the card is an ace, count it in aces variable 
        }

        // In Blackjack, an Ace can count as 11 or 1. It will count as 11 if you havent bust. If will count as 1 if it would otherwise cause a loss.
        while (total > 21 && aces > 0) {  // While Total is more than 21, but you have an Ace
            total -= 10; // Subtract 10. Since ace originally added 11, that makes it's contribution only 1
            aces--;
        }
        return total; // Return the final Value of the Hand
    }

    boolean isBust() { // Returns True if Value of Hand is more than 21
        return getValue() > 21;
    }

    boolean isBlackjack() { // This returns True when a dealt Hand is ALREADY equal to 21 (automatic win) i.e. when lucky, and you get 10 and Ace(11) at the start.
        return cards.size() == 2 && getValue() == 21;
    }

    void clear() {
        cards.clear(); // Clears the ArrayList of Cards 
    }
}
