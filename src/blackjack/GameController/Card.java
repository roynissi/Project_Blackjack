package blackjack.GameController;

class Card {
    private final int rank; // 1(Ace), 2-10, 11(J), 12(Q), 13(K)
    private final String suit;

    Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    int getRank() {
        return rank;
    }

    int getBaseValue() {
        if (rank == 1) return 11; // Ace value = 11
        if (rank >= 10) return 10; // 10, J, Q, and K have a value of 10
        return rank; // Numbers 2-9's value is the same as there rank.
    }

    boolean isAce() { // Returns true if the Rank is 1 (rank will be one if it is an Ace)
        return rank == 1;
    }

    @Override
    public String toString() {
        String face;
        if (rank == 1) face = "A"; // Rank One shows "A" because it is Ace
        else if (rank == 11) face = "J"; // Same for J, Q, K
        else if (rank == 12) face = "Q";
        else if (rank == 13) face = "K";
        else face = String.valueOf(rank); // If not a letter card the String is the number
        return face + suit; // Returns the now set Face, and the already set suit (clubs, hearts, etc. as ♣, and ♥) 
    }
}


