package org.elsys.cardgame.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameImpl implements Game {
    private Map<String, Operation> operations;
    private Deck deck;
    private Hand lastHand;

    public GameImpl(Deck parameterDeck) {
        operations = new HashMap<>();
        operations.put("size", deck -> {
            System.out.println(deck.getSize());
        });
        operations.put("draw_top_card", deck -> {
            if(deck.getSize() < 1) {
                throw new CardException("ERROR: Not enough cards in deck");
            }
            System.out.println(deck.takeTopCard());
        });
        operations.put("draw_bottom_card", deck -> {
            if(deck.getSize() < 1) {
                throw new CardException("ERROR: Not enough cards in deck");
            }
            System.out.println(deck.takeBottomCard());
        });
        operations.put("top_card", deck -> {
            if(deck.getSize() < 1) {
                throw new CardException("ERROR: Not enough cards in deck");
            }
            System.out.println(deck.getCards().getFirst());
        });
        operations.put("bottom_card", deck -> {
            if(deck.getSize() < 1) {
                throw new CardException("ERROR: Not enough cards in deck");
            }
            System.out.println(deck.getCards().getLast());
        });
        operations.put("shuffle", deck -> {
            deck.shuffle();
            for(Card card : deck.getCards()) {
                System.out.print(card + " ");
            }
            System.out.println();
        });
        operations.put("sort", deck -> {
            deck.sort();
            for(Card card : deck.getCards()) {
                System.out.print(card + " ");
            }
            System.out.println();
        });
        operations.put("deal", deck -> {
            if(deck.getSize() < deck.getHandSize()) {
                throw new CardException("ERROR: Not enough cards in deck");
            }
            this.lastHand = deck.deal();
            for(Card card : this.lastHand.getCards()) {
                System.out.print(card + " ");
            }
            System.out.println();
        });

        this.deck = parameterDeck;
    }

    @Override
    public void process(String operationName) {
        Operation operation = operations.get(operationName);
        try {
            operation.execute(deck);
        }
        catch(CardException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Set<String> getOperationNames() {
        return operations.keySet();
    }

    public Map<String, Operation> getOperations() {
        return operations;
    }

    public void setOperations(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getLastHand() {
        return lastHand;
    }

    public void setLastHand(Hand lastHand) {
        this.lastHand = lastHand;
    }
}
