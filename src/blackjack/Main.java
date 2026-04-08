package blackjack;

import java.util.Scanner;

import blackjack.GameController.GameController;
import blackjack.GameController.GameResult;
import blackjack.GameController.Deck;
import blackjack.GameController.Player;
import blackjack.GameController.Dealer;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main game = new Main();
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        GameController controller = new GameController(player, dealer, deck);

        boolean playAgain = true;

    
        while (playAgain) {
            game.showTitleScreen(scanner);
            game.showGameScreen(scanner, controller, player, dealer);
            playAgain = game.showEndScreen(scanner);
        }

        scanner.close();
    }

    public void showTitleScreen(Scanner input) {
        System.out.println("================================");
        System.out.println("           BLACKJACK            ");
        System.out.println("================================");
        System.out.println("\n        Press ENTER to Play     \n");

        input.nextLine();

        System.out.println("        Shuffling Cards....     \n");
    }

    public void showGameScreen(Scanner input, GameController controller,
                               Player player, Dealer dealer) {
        controller.startGame();


        while (!controller.isRoundOver()) {

            System.out.println("Dealer's Hand: "
                    + dealer.getHand().toStringHidden());
            System.out.println("-------------------------------");
            System.out.println("Your Hand: " + player.getHand());
            System.out.println("Total: " + player.getHand().getValue());

            if (player.wantsToHit(input)) {
                controller.playerTurn();
            } else {
                System.out.println("Dealer's Hand: " + dealer.getHand());
                controller.dealerTurn();
                break;
            }
        }

        
        System.out.println("\n--- FINAL HANDS ---");
        System.out.println("Dealer: " + dealer.getHand()
                + " (" + dealer.getHand().getValue() + ")");
        System.out.println("Player: " + player.getHand()
                + " (" + player.getHand().getValue() + ")");

        GameResult result = controller.checkWinner();
        System.out.println(result.getMessage());
    }

    
    public boolean showEndScreen(Scanner input) {

        System.out.println("================================");
        System.out.println("            GAME OVER           ");
        System.out.println("================================");
        System.out.print("Play again? (Y/N): ");

        String replayChoice = input.nextLine().trim().toUpperCase();

        return replayChoice.equals("Y");
    }
}
