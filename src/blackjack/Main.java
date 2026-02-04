package blackjack;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Title Screen
        System.out.println("================================");
        System.out.println("           BLACKJACK            ");
        System.out.println("================================");
        System.out.println();
        System.out.println("        Press ENTER to Play     ");
        System.out.println();

        //Game Initialization
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("\n\n\n");
        System.out.println("        Shuffling Cards....     ");

        // Game Screen Layout to be replaced with logic
        System.out.println("\n");
        System.out.println("Dealer's Hand:");
        System.out.println("[??] [7♠]");
        System.out.println();

        System.out.println("-------------------------------");
        System.out.println();

        System.out.println("Your Hand:");
        System.out.println("[10♦] [6♥]");
        System.out.println("Total: 16");
        System.out.println();

        System.out.println("(H) Hit    (S) Stand");

        boolean isPlaying = true;

        while (isPlaying) {
            System.out.print("Choose an action (H/S)");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("H")) {
                System.out.println("You chose to HIT.");
                // deal card logic
            }
            else if (choice.equals("S")) {
                System.out.println("You chose to STAND");
                isPlaying = false;
            }
            else {
                System.out.println("Invalid input. Please enter H or S.");
            }

            System.out.println();

        }

        // End Screen

        System.out.println("================================");
        System.out.println("            GAME OVER           ");
        System.out.println("================================");
        System.out.println();
        System.out.println("Result: You Win!");
        System.out.println();

        // Game Restart
        System.out.print("Play again? (Y/N): ");
        String replayChoice = scanner.nextLine().trim().toUpperCase();






    }
}
