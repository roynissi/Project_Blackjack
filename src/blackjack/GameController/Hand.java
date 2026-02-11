package blackjack.GameController;
import java.util.ArrayList;
import java.util.Collections;
import blackjack.GameController.Card;


public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();
    // Create a list of cards called cards

    void addCard(Card card) {
        cards.add(card);
    } // Add a card to the list of cards

    public int getValue() {
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

	public String toStringHidden() {
		if (cards.isEmpty()) return "Empty Hand"; // obvious
		if (cards.size() == 1) return "🃏" ; // If there is only one card, don't show it. This is intended to mean the back of a card, that you can't see.

		// If > 1 cards:
		String result = "🃏, " + cards.get(1).toString();  // Shows the 0th card as hidden and the value of the 1st card

		for (int i = 2; i < cards.size(); i++) { // Iterate through the all cards in the hand but the first
			result += ", " + cards.get(i).toString(); // Add the string value for each card
		}
		return result;

	}
}
