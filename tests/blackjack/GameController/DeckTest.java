package blackjack.GameController;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {

    /**
     * Should initialize 52 new cards.
     */
    @Test
    public void testGetCards() {
        var instance = new Deck();
        assertNotNull(instance);
        assertNotNull(instance.getCards());
        assertEquals(52, instance.getCards().size());
    }

    /**
     * Expect card order to be random. First card should not be of rank 1
     */
    @Test
    public void shuffle() {
        var instance = new Deck();
        var card = List.copyOf(instance.getCards()); // makes a shallow copy of the list
        assertNotNull(card);
        instance.shuffle();
        assertNotEquals(card, instance.getCards());
    }

    /**
     * Should remove 1 card from the list.
     */
    @Test
    public void testDealCard() {
        var instance = new Deck();
        var card = instance.dealCard();
        assertNotNull(card);
        assertEquals(51, instance.getCards().size());
    }

    /**
     * If deck is empty, it should reset it.
     */
    @Test
    public void dealCardShouldResetDeck() {
        var instance = new Deck();
        // clear the deck
        instance.getCards().clear();
        var card = instance.dealCard();
        assertNotNull(card);
        // since it should also remove 1 card from the list
        assertEquals(51, instance.getCards().size());
    }
}