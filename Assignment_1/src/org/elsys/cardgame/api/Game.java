package org.elsys.cardgame.api;

import java.util.Set;

public interface Game {
    void process(String operationName);
    Deck getDeck();
    Hand getLastHand();
    Set<String> getOperationNames();
}
