package org.elsys.cardgame.api;

public interface Operation {
    String getName();
    void execute(GameImpl game) throws CardException;
}
