package blackjack;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main game = new Main();

        game.showTitleScreen(scanner);
        game.showGameScreen(scanner);
        game.showEndScreen(scanner);

        scanner.close();
    }

    public void showTitleScreen(Scanner input) {
        System.out.println("================================");
        System.out.println("           BLACKJACK            ");
        System.out.println("================================");
        System.out.println("\n        Press ENTER to Play     \n");

        // 'input' parameter we passed in
        input.nextLine();

        System.out.println("        Shuffling Cards....     \n");

    }

    public void showGameScreen(Scanner input) {
        // Game Screen Layout to be replaced with logic
        System.out.println("Dealer's Hand: [?] [7♠]");
        System.out.println("-------------------------------");
        System.out.println("Your Hand: [10♦] [6♥] (Total: 16)");
        System.out.println("(H) Hit    (S) Stand");

        boolean isPlaying = true;

        while (isPlaying) {
            System.out.print("Choose an action (H/S)");
            String choice = input.nextLine().trim().toUpperCase();

            if (choice.equals("H")) {
                System.out.println("You chose to HIT.");
                // deal card logic
            } else if (choice.equals("S")) {
                System.out.println("You chose to STAND");
                isPlaying = false;
            } else {
                System.out.println("Invalid input. Please enter H or S.");
            }

            System.out.println();

        }
    }

    public void showEndScreen(Scanner input) {

        // End Screen

        System.out.println("================================");
        System.out.println("            GAME OVER           ");
        System.out.println("================================");
        System.out.print("Play again? (Y/N): ");

        // Game Restart
        String replayChoice = input.nextLine().trim().toUpperCase();
        System.out.println("You chose: " + replayChoice);

    }
}
