package blackjack.GameController;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Card class.
 */
public class CardTest {

    @Test
    public void testGetRank() {
        var instance = new Card(2, "Club");
        assertNotNull(instance);
        assertEquals(2, instance.getRank());
    }

    @Test
    public void testGetBaseValue() {
        var instance = new Card(2, "Club");
        assertNotNull(instance);
        assertEquals(2, instance.getBaseValue());
    }

    /**
     * Rank anything with rank above 9 should have baseValue of 10.
     */
    @Test
    public void testGetBaseValueShouldBe10() {
        var instance = new Card(11, "Club");
        assertNotNull(instance);
        assertEquals(10, instance.getBaseValue());
    }

    /**
     * Rank value of 20 for example is not valid. Should throw illegal argument exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetBaseValueShouldThrowExceptionForInvalidRank() {
       var instance = new Card(14, "Suit");
       assertNull(instance);
    }

    /**
     * For numbers 1-9 base value should be same of rank
     */
    @Test
    public void testGetBaseValueShouldBeSameAsGetRank() {
        var instance = new Card(8, "Club");
        assertNotNull(instance);
        assertEquals(8, instance.getRank());
        assertEquals(instance.getRank(), instance.getBaseValue());
    }

    /**
     * Ace has rank 1. Anything else should not be considered an Ace.
     */
    @Test
    public void testIsAceNotAnAce() {
        var instance = new Card(7, "Club");
        assertNotNull(instance);
        assertFalse(instance.isAce());
    }

    /**
     * Test for ace.
     */
    @Test
    public void testIsAce() {
        var instance = new Card(1, "Club");
        assertNotNull(instance);
        assertTrue(instance.isAce());
    }

    /**
     * Ranks greater than 9 should show the expected card face instead of number.
     * For e.g., Rank 11 == 'K'
     */
    @Test
    public void testToStringAce() {
        var instance = new Card(1, "Heart");
        assertEquals("A Heart", instance.toString());
    }

    /**
     * Ranks greater than 9 should show the expected card face instead of number.
     * For e.g., Rank 11 == 'K'
     */
    @Test
    public void testToStringJack() {
        var instance = new Card(11, "Diamond");
        assertEquals("J Diamond", instance.toString());
    }

    /**
     * Ranks greater than 9 should show the expected card face instead of number.
     * For e.g., Rank 11 == 'K'
     */
    @Test
    public void testToStringQueen() {
        var instance = new Card(12, "Club");
        assertEquals("Q Club", instance.toString());
    }

    /**
     * Ranks greater than 9 should show the expected card face instead of number.
     * For e.g., Rank 11 == 'K'
     */
    @Test
    public void testToStringKing() {
        var instance = new Card(13, "Heart");
        assertEquals("K Heart", instance.toString());
    }

    /**
     * Ranks greater than 9 should show the expected card face instead of number.
     * For e.g., Rank 11 == 'K'
     * Anything else should just be the number itself and the suit.
     */
    @Test
    public void testToStringOther() {
        var instance = new Card(3, "Spade");
        assertEquals("3 Spade", instance.toString());
    }
}