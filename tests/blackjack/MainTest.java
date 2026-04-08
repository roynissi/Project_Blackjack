package blackjack;

import java.util.Scanner;

import blackjack.GameController.Card;
import blackjack.GameController.Dealer;
import blackjack.GameController.GameController;
import blackjack.GameController.Player;
import blackjack.GameController.ScriptedDeck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/* Tests that Play again actually works */
public class MainTest {

    @Test
    public void testPlayAgainYes() {
        var game = new Main();
        var deck = new ScriptedDeck(
                new Card(10, "Spade"),
                new Card(9, "Heart"),
                new Card(8, "Club"),
                new Card(7, "Diamond")
        );
        var player = new Player();
        var dealer = new Dealer();
        var controller = new GameController(player, dealer, deck);

        controller.startGame();
        player.addCard(new Card(5, "Spade"));
        dealer.addCard(new Card(6, "Heart"));

        assertTrue(game.showEndScreen(new Scanner("Y\n")));

        controller.startGame();

        assertEquals(2, player.getHandSize());
        assertEquals(2, dealer.getHandSize());
        assertFalse(controller.isRoundOver());
    }
}
