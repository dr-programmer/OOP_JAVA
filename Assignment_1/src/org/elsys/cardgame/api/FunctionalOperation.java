package org.elsys.cardgame.api;

@FunctionalInterface
public interface FunctionalOperation {
    void execute(Deck deck) throws CardException;
}
