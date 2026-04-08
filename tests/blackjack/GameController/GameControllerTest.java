package blackjack.GameController;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameControllerTest {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private GameController instance;

    @Before
    public void setUp() {
        player = new Player();
        dealer = new Dealer();
        deck = new Deck();
        instance = new GameController(player, dealer, deck);
    }

    @Test
    public void testStartGame() {
        deck = new ScriptedDeck(
                new Card(10, "Spade"),
                new Card(9, "Heart"),
                new Card(8, "Club"),
                new Card(7, "Diamond")
        );
        instance = new GameController(player, dealer, deck);

        instance.startGame();

        assertEquals(2, player.getHandSize());
        assertEquals(2, dealer.getHandSize());
        assertEquals(48, deck.getCards().size());
        assertFalse(instance.isRoundOver());
    }

    @Test
    public void testPlayerBlackjack() {
        deck = new ScriptedDeck(
                new Card(1, "Spade"),
                new Card(9, "Heart"),
                new Card(13, "Club"),
                new Card(7, "Diamond")
        );
        instance = new GameController(player, dealer, deck);

        instance.startGame();

        assertTrue(instance.isRoundOver());
        assertEquals(GameResult.PLAYER_BLACKJACK, instance.checkWinner());
    }

    @Test
    public void testPlayerBust() {
        deck = new ScriptedDeck(
                new Card(10, "Spade"),
                new Card(9, "Heart"),
                new Card(8, "Club"),
                new Card(7, "Diamond"),
                new Card(5, "Spade")
        );
        instance = new GameController(player, dealer, deck);

        instance.startGame();
        instance.playerTurn();

        assertTrue(player.getHand().isBust());
        assertTrue(instance.isRoundOver());
        assertEquals(GameResult.DEALER_WINS, instance.checkWinner());
    }

    @Test
    public void testCheckWinner() {
        player.addCard(new Card(10, "Spade"));
        player.addCard(new Card(9, "Heart"));
        dealer.addCard(new Card(10, "Club"));
        dealer.addCard(new Card(7, "Diamond"));

        assertEquals(GameResult.PLAYER_WINS, instance.checkWinner());
    }
}
