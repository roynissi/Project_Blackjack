package blackjack.GameController;

import java.util.Scanner;

/*deck, player and dealer classes will be imported here */
import blackjack.GameController.Deck;

public class GameController{

    private Deck deck;
    private Player player;
    private Dealer dealer;
    private boolean roundOver;
	
	// Add the public function that was missing... 
	public boolean isRoundOver() {
		return this.roundOver;
	}

    public GameController(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.roundOver = false;
    }

    // --- GAME FLOW ---

    /*
     * Starts a new round of Blackjack.
     * Shuffles deck and performs initial deal.
     */
    public void startGame() {
        resetRound();
        deck.shuffle();

        // Initial deal (2 cards each)
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        // Check for immediate blackjack
        if (player.getHand().isBlackjack() || dealer.getHand().isBlackjack()) {
            roundOver = true;
        }
    }

    // handle players turn: Check if round is over, if not, add a card, then check if they went bust from that added card.
    public void playerTurn() {
        if (roundOver) return;
        player.addCard(deck.dealCard());
        if(player.getHand().isBust()){
            roundOver = true;
        }
    }


    /*
     * Handles the dealer's turn.
     * Dealer must hit until hand value is at least 17
     */
    public void dealerTurn() {
        if (roundOver) return;

        while (dealer.getHand().getValue() < 17) {
            dealer.addCard(deck.dealCard());
        }

        if (dealer.getHand().isBust()) {
            roundOver = true;
        }
    }

    /*
     * Determines the winner of the round
     * based on Blackjack rules.
     */
    public GameResult checkWinner() {

        int playerValue = player.getHand().getValue();
        int dealerValue = dealer.getHand().getValue();

        if (player.getHand().isBust()) {
            return GameResult.DEALER_WINS;
        }

        if (dealer.getHand().isBust()) {
            return GameResult.PLAYER_WINS;
        }

        if (player.getHand().isBlackjack() && !dealer.getHand().isBlackjack()) {
            return GameResult.PLAYER_BLACKJACK;
        }

        if (dealer.getHand().isBlackjack() && !player.getHand().isBlackjack()) {
            return GameResult.DEALER_WINS;
        }

        if (playerValue > dealerValue) {
            return GameResult.PLAYER_WINS;
        } else if (dealerValue > playerValue) {
            return GameResult.DEALER_WINS;
        } else {
            return GameResult.PUSH;
        }
    }

    /*

     * Resets the round state and clears hands.
     */
    public void resetRound() {
        player.getHand().clear();
        dealer.getHand().clear();
        roundOver = false;
    }
}

