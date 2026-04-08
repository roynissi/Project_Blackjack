package blackjack.GameController;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DealerTest {

    @Test
    public void testDealerHitsBelowSeventeen() {
        var dealer = new Dealer();
        dealer.addCard(new Card(10, "Spade"));
        dealer.addCard(new Card(6, "Heart"));

        assertTrue(dealer.wantsToHit(null));
    }

    @Test
    public void testDealerStandsOnSeventeen() {
        var dealer = new Dealer();
        dealer.addCard(new Card(10, "Spade"));
        dealer.addCard(new Card(7, "Heart"));

        assertFalse(dealer.wantsToHit(null));
    }

    @Test
    public void testDealerDrawsToSeventeen() {
        var player = new Player();
        var dealer = new Dealer();
        var deck = new ScriptedDeck(
                new Card(9, "Spade"),
                new Card(10, "Heart"),
                new Card(7, "Club"),
                new Card(6, "Diamond"),
                new Card(2, "Spade")
        );
        var controller = new GameController(player, dealer, deck);

        controller.startGame();
        controller.dealerTurn();

        assertEquals(3, dealer.getHandSize());
        assertEquals(18, dealer.getHand().getValue());
        assertTrue(controller.isRoundOver());
    }
}
