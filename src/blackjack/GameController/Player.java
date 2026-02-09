package blackjack.GameController;

public class Player {
    private final Hand hand = new Hand(); // Create a Hand from Deck.java

    public Hand getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    
    }
    // This currently will always hit if it has less than 17 automatically.
    public boolean wantsToHit() { // This needs to be changed so the Player decides. 
        return !hand.isBust() && !hand.isBlackjack() && hand.getValue() < 17;
    }
}

class Dealer extends Player {
}
