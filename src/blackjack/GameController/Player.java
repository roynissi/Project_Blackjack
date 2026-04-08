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

    /**
     *
     * @return the size of the hand. Wrapper for hand.getSize();
     */
    public int getHandSize() {
        return hand.getSize();
    }

    public boolean wantsToHit(Scanner scanner) {
        if (hand.isBust() || hand.isBlackjack()) {
            return false;
        }

        while (true) {
            System.out.print("(H) Hit    (S) Stand: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("H")) {
                return true;
            } else if (input.equals("S")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter H or S.");
            }
        }
    }
}
