package org.elsys.cardgame.api;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDeck implements Deck {
    private List<Card> cards;
    private Integer handSize;

    @Override
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public Integer getHandSize() {
        return handSize;
    }

    public void setHandSize(Integer handSize) {
        this.handSize = handSize;
    }

    @Override
    public Card takeCard() {
        return cards.removeFirst();
    }

    @Override
    public Integer getSize() {
        return cards.size();
    }

    @Override
    public Hand deal() {
        return new HandImpl(
                cards
                        .stream()
                        .limit(handSize)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }
}