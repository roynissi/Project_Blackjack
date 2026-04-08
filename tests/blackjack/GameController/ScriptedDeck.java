package blackjack.GameController;

/* Test: Makes it deterministic (overrides shuffling/deck to something known) to make sure nothing weird is happening
   */
public class ScriptedDeck extends Deck {
    private Card[] scriptedDraws;

    public ScriptedDeck(Card... scriptedDraws) {
        this.scriptedDraws = scriptedDraws.clone();
        reset();
    }

    @Override
    public void reset() {
        super.reset();
        if (scriptedDraws == null) return;

        var cards = getCards();
        for (int i = 0; i < scriptedDraws.length; i++) {
            cards.set(cards.size() - 1 - i, scriptedDraws[i]);
        }
    }

    @Override
    public void shuffle() {
    }
}
