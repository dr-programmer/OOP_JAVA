package org.elsys.cardgame.api;

@FunctionalInterface
public interface Operation {
    void execute(Deck deck) throws CardException;
}
