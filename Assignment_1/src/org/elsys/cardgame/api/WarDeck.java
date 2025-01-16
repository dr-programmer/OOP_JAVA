package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WarDeck extends AbstractDeck {
    final Integer constDeckSize = 52;
    final Integer constHandSize = 26;

    public WarDeck() {
        List<Card> cards = new ArrayList<Card>();

        for(Rank rank : Rank.values()) {
            for(Suit suit : Suit.values()) {
                cards.add(new CardImpl(rank, suit));
            }
        }

        setCards(cards);
        setHandSize(constHandSize);
    }

    @Override
    public void sort() {
        this.getCards().sort(new CompareCard());
    }

    private class CompareCard implements Comparator<Card> {
        @Override
        public int compare(Card o1, Card o2) {
            if(o1.getRank() == o2.getRank()) {
                return o1.compareTo(o2);
            }
            return o1.getRank().compareTo(o2.getRank());
        }
    }
}
