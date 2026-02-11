package blackjack.GameController;

import blackjack.GameController.Player;
import java.util.Scanner;

public class Dealer extends Player {

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
