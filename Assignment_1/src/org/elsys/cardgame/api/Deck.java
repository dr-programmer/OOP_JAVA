package org.elsys.cardgame.api;

import java.util.List;

public interface Deck {
    List<Card> getCards();
    Integer getSize();
    Integer getHandSize();

    Hand deal();
    Card takeTopCard();
    Card takeBottomCard();
    void sort();
    void shuffle();
}
