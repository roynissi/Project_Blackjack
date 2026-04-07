/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package blackjack.GameController;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anm
 */
public class GameControllerTest {

    private GameController instance;

    public GameControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Player player = new Player();
        Dealer dealer = new Dealer();
        Deck deck = new Deck();
        instance = new GameController(player, dealer, deck);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isRoundOver method, of class GameController.
     */
    @Test
    public void testIsRoundOver() {
        instance.startGame();
        boolean result = instance.isRoundOver();
        assertFalse(result);
    }

    /**
     * Test of startGame method, of class GameController.
     */
    @Test
    public void testStartGame() {
        assertNotNull(instance);
        instance.startGame();
    }

    /**
     * Test of playerTurn method, of class GameController.
     * playerTurn should execute without throwing an exception.
     */
    @Test
    public void testPlayerTurn() {
        instance.startGame();
        instance.playerTurn();
    }

    /**
     * Test of dealerTurn method, of class GameController.
     */
    @Test
    public void testDealerTurn() {
        instance.startGame();
        instance.dealerTurn();
    }

    /**
     * Test of checkWinner method, of class GameController.
     */
    @Test
    public void testCheckWinner() {
        instance.startGame();
        GameResult result = instance.checkWinner();
        assertNotNull(result);
    }

    /**
     * Test of resetRound method, of class GameController.
     */
    @Test
    public void testResetRound() {
        instance.startGame();
        instance.resetRound();
        assertFalse(instance.isRoundOver());
    }

}