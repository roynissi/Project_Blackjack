package blackjack;

import java.util.Scanner;

import blackjack.GameController.GameController;
import blackjack.GameController.GameResult;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main game = new Main();

        boolean playAgain = true;

    
        while (playAgain) {
            game.showTitleScreen(scanner);
            game.showGameScreen(scanner);
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

    public void showGameScreen(Scanner input) {

        
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();

        GameController controller =
                new GameController(player, dealer, deck);

        controller.startGame();


        while (!controller.isRoundOver()) {

            System.out.println("Dealer's Hand: "
                    + dealer.getHand().toStringHidden());
            System.out.println("-------------------------------");
            System.out.println("Your Hand: " + player.getHand());
            System.out.println("Total: " + player.getHand().getValue());

            System.out.print("(H) Hit    (S) Stand: ");
            String choice = input.nextLine().trim().toUpperCase();

            if (choice.equals("H")) {
                
                controller.playerTurn();

            } else if (choice.equals("S")) {
                controller.dealerTurn();
                break;

            } else {
                System.out.println("Invalid input. Please enter H or S.");
            }
        }

        
        System.out.println("\n--- FINAL HANDS ---");
        System.out.println("Dealer: " + dealer.getHand()
                + " (" + dealer.getHand().getValue() + ")");
        System.out.println("Player: " + player.getHand()
                + " (" + player.getHand().getValue() + ")");

        GameResult result = controller.checkWinner();

        switch (result) {
            case PLAYER_WINS -> System.out.println("🎉 You win!");
            case DEALER_WINS -> System.out.println("💀 Dealer wins!");
            case PLAYER_BLACKJACK -> System.out.println("🃏 BLACKJACK!");
            case PUSH -> System.out.println("🤝 Push (Tie)");
        }
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
