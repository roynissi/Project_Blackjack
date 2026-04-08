package blackjack.GameController;

import blackjack.GameController.Player;
import java.util.Scanner;

public class Dealer extends Player {

    // Dealer's logic for hitting
    @Override
    public boolean wantsToHit(Scanner scanner) {
        return hand.getValue() < 17;
    }
}
