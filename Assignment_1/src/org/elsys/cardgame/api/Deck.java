package org.elsys.cardgame.api;

import java.util.List;

public interface Deck {
    List<Card> getCards();
    Integer getSize();
    Integer getHandSize();

    Hand deal();
    Card takeCard();
    void sort();
    void shuffle();
}
