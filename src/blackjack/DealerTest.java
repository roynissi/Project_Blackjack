package blackjack.GameController;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the Dealer class.
 */
public class DealerTest {
    private Dealer instance;

    @Before
    public void setUp() {
        instance = new Dealer();
    }

    /**
     * Should return a non-null hand which should be created.
     */
    @Test
    public void testGetHand() {
        var hand = instance.getHand();
        assertNotNull(hand);
    }

    /**
     * Should successfully add the card to the hand.
     */
    @Test
    public void testAddCard() {
        var card = new Card(5, "Test Suit");
        instance.addCard(card);
        assertEquals(5, instance.getHand().getValue());
        // should return the size of the hand
        assertEquals(1, instance.getHandSize());
    }

    /**
     * Dealer should want to hit when hand value is less than 17.
     */
    @Test
    public void testWantsToHit_BelowSeventeen() {
        instance.addCard(new Card(10, "Spades"));
        instance.addCard(new Card(6, "Hearts"));
        // hand value = 16, dealer must hit
        assertTrue(instance.wantsToHit(null));
    }

    /**
     * Dealer should stand when hand value is exactly 17.
     */
    @Test
    public void testWantsToHit_AtSeventeen() {
        instance.addCard(new Card(10, "Spades"));
        instance.addCard(new Card(7, "Hearts"));
        // hand value = 17, dealer must stand
        assertFalse(instance.wantsToHit(null));
    }

    /**
     * Dealer should stand when hand value is above 17.
     */
    @Test
    public void testWantsToHit_AboveSeventeen() {
        instance.addCard(new Card(10, "Spades"));
        instance.addCard(new Card(9, "Clubs"));
        // hand value = 19, dealer must stand
        assertFalse(instance.wantsToHit(null));
    }
}
