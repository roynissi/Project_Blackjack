package blackjack.GameController;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {

    /**
     * Should be empty when initialized.
     */
    @Test
    public void testGetCards() {
        var instance = new Hand();
        // should be empty
        assertTrue(instance.getCards().isEmpty());
    }

    /**
     * should add 1 card thus increasing the cards list size.
     */
    @Test
    public void testAddCard() {
        var instance = new Hand();
        assertNotNull(instance);
        instance.addCard(new Card(2, "Spade"));
        assertEquals(1, instance.getSize());
    }

    /**
     * Cards between 1-9 should just add their value.
     */
    @Test
    public void testGetValue() {
        var instance = new Hand();
        instance.addCard(new Card(2, "Spade"));
        assertEquals(2, instance.getValue());
    }

    /**
     * Cards between 1-9 should just add their value.
     */
    @Test
    public void testGetValue2Cards() {
        var instance = new Hand();
        instance.addCard(new Card(2, "Spade"));
        instance.addCard(new Card(5, "Spade"));
        assertEquals(7, instance.getValue());
    }

    /**
     * Cards between 1-9 should just add their value.
     * Aces are added to get best result.
     */
    @Test
    public void testGetValue2CardsWithOneBeingAce() {
        var instance = new Hand();
        instance.addCard(new Card(2, "Spade"));
        instance.addCard(new Card(1, "Spade"));
        assertEquals(13, instance.getValue());
    }

    /**
     * Cards between 1-9 should just add their value.
     * Aces are added to get best result.
     */
    @Test
    public void testGetValueCountAce() {
        var instance = new Hand();
        instance.addCard(new Card(12, "Spade"));
        instance.addCard(new Card(1, "Spade"));
        assertEquals(21, instance.getValue());
    }

    /**
     * Busts at value > 21
     */
    @Test
    public void testIsBustShouldBust() {
        var instance = new Hand();
        instance.addCard(new Card(11, "Spade"));
        instance.addCard(new Card(12, "Spade"));
        instance.addCard(new Card(8, "Spade"));
        assertTrue(instance.isBust());
    }

    /**
     * Busts at value > 21
     */
    @Test
    public void testIsBustShouldNotBust() {
        var instance = new Hand();
        instance.addCard(new Card(11, "Spade"));
        instance.addCard(new Card(2, "Spade"));
        assertFalse(instance.isBust());
    }

    /**
     * Blackjacks at getValue == 21
     */
    @Test
    public void isBlackjack() {
        var instance = new Hand();
        instance.addCard(new Card(11, "Spade"));
        instance.addCard(new Card(1, "Spade"));
        assertTrue(instance.isBlackjack());
    }
}