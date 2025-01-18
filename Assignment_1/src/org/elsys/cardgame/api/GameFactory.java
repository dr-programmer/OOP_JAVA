package org.elsys.cardgame.api;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GameFactory {
    public static Game createWarGame(List<Card> cards) throws CardException {
        WarDeck deck = DeckFactory.createWarDeck();

        boolean hasValidCards = new HashSet<>(cards).containsAll(deck.getCards());
        if(!hasValidCards) {
            throw new CardException("ERROR: Not enough cards for War");
        }

        cards = cards.stream()
                .filter(card -> new HashSet<>(deck.getCards()).contains(card))
                .collect(Collectors.toList());
        deck.setCards(cards);

        return new GameImpl(deck);
    }

    public static Game createBeloteGame(List<Card> cards) throws CardException {
        BeloteDeck deck = DeckFactory.createBelotDeck();

        boolean hasValidCards = new HashSet<>(cards).containsAll(deck.getCards());
        if(!hasValidCards) {
            throw new CardException("ERROR: Not enough cards for Belote");
        }

        cards = cards.stream()
                .filter(card -> new HashSet<>(deck.getCards()).contains(card))
                .collect(Collectors.toList());
        deck.setCards(cards);

        return new GameImpl(deck);
    }

    public static Game createSantaseGame(List<Card> cards) throws CardException {
        SantaseDeck deck = DeckFactory.createSantaseDeck();

        boolean hasValidCards = new HashSet<>(cards).containsAll(deck.getCards());
        if(!hasValidCards) {
            throw new CardException("ERROR: Not enough cards for Santase");
        }

        cards = cards.stream()
                .filter(card -> new HashSet<>(deck.getCards()).contains(card))
                .collect(Collectors.toList());
        deck.setCards(cards);

        return new GameImpl(deck);
    }

    public static Game createTempGame() {
        return new GameImpl(new AbstractDeck() {
            @Override
            public void sort() {
                return;
            }
        });
    }
}
