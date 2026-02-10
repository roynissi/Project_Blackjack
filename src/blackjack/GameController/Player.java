package blackjack.GameController;


import java.util.Scanner;

public class Player {
    protected final Hand hand = new Hand(); // Create a Hand from Deck.java

    public Hand getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    
    }
    public boolean wantsToHit(Scanner scanner) {
    // If the hand is already bust or blackjack, no need to ask
    if (hand.isBust() || hand.isBlackjack()) {
        return false;
    }

    // Ask the player
    while (true) {
        System.out.println("Your hand: " + hand);
        System.out.println("Hand value: " + hand.getValue());
        System.out.print("Do you want to hit? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("y") || input.equals("yes")) {
            return true;
        } else if (input.equals("n") || input.equals("no")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }
}
}
class Dealer extends Player {

    // Dealer's logic for hitting
    @Override
    public boolean wantsToHit(Scanner scanner) {
        int handValue = hand.getValue();
        // Dealer hits if hand value is less than 17
        if (handValue < 17) {
            System.out.println("Dealer hits (hand value: " + handValue + ")");
            return true;
        } else {
            System.out.println("Dealer stands (hand value: " + handValue + ")");
            return false;
        }
    }
}
