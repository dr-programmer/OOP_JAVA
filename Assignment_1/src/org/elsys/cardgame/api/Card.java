package org.elsys.cardgame.api;

public interface Card extends Comparable<Card> {
    Rank getRank();
    Suit getSuit();
}
