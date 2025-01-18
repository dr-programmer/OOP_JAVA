package org.elsys.cardgame.api;

public class DeckFactory {
    public static WarDeck createWarDeck() {
        return new WarDeck();
    }

    public static BeloteDeck createBelotDeck() {
        return new BeloteDeck();
    }

    public static SantaseDeck createSantaseDeck() {
        return new SantaseDeck();
    }
}
