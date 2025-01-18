package org.elsys.cardgame.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameImpl implements Game {
    private Map<String, Operation> operations;
    private Deck deck;
    private Hand lastHand;

    public GameImpl(Deck deck) {
        operations = new HashMap<>();
        operations.put("size", new SizeOperation());
        operations.put("sort", new SortOperation());
        operations.put("shuffle", new ShuffleOperation());
        operations.put("deal", new DealOperation());
        operations.put("draw_top_card", new DrawTopCardOperation());
        operations.put("draw_bottom_card", new DrawBottomCardOperation());
        operations.put("top_card", new TopCardOperation());
        operations.put("bottom_card", new BottomCardOperation());
        this.deck = deck;
    }

    @Override
    public void process(String operationName) {
        Operation operation = operations.get(operationName);
        try {
            operation.execute(this);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public Hand getLastHand() {
        return lastHand;
    }

    @Override
    public Set<String> getOperationNames() {
        return operations.keySet();
    }

    public void setOperations(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setLastHand(Hand lastHand) {
        this.lastHand = lastHand;
    }
}
