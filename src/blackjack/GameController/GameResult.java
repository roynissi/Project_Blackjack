package blackjack.GameController;

/**
 * Represents the possible outcomes of a Blackjack round.
 * This enum also provides user-friendly messages for each result.
 */
public enum GameResult {

    PLAYER_WINS("You win! 🎉"),
    DEALER_WINS("Dealer wins. Better luck next time."),
    PLAYER_BLACKJACK("BLACKJACK! You win instantly! 🃏🔥"),
    PUSH("Push! It's a tie.");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    /**
     * Returns a display-friendly message for the game result.
     */
    public String getMessage() {
        return message;
    }
}
