package blackjack.GameController;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the player class.
 */
public class PlayerTest {
    private Player instance;

    @Before
    public void setUp() {
        instance = new Player();
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
}