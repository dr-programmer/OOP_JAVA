package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BeloteDeck extends AbstractDeck {
    final Integer constDeckSize = 32;
    final Integer constHandSize = 8;
    final Integer constRankStartIndex = 5;

    public BeloteDeck() {
        List<Card> cards = new ArrayList<Card>();

        Rank[] allRanks = Rank.values();
        Rank[] ranks = Arrays.copyOfRange(allRanks, constRankStartIndex, allRanks.length);
        for(Rank rank : ranks) {
            for(Suit suit : Suit.values()) {
                cards.add(new CardImpl(rank, suit));
            }
        }

        setCards(cards);
        setHandSize(constHandSize);
        this.sort();
    }

    @Override
    public void sort() {
        this.getCards().sort(new CompareCard());
    }

    private class CompareCard implements Comparator<Card> {
        private Integer getOrdinalRank(Card card) {
            Rank rank = card.getRank();
            if(rank == Rank.ACE) {
                return rank.ordinal() + 1;
            }
            if(rank == Rank.TEN) {
                return Rank.ACE.ordinal();
            }
            return rank.ordinal();
        }

        @Override
        public int compare(Card o1, Card o2) {
            if(o1.getRank() == o2.getRank()) {
                return o1.compareTo(o2);
            }

            Integer thisRank = getOrdinalRank(o1);
            Integer otherRank = getOrdinalRank(o2);
            return thisRank.compareTo(otherRank);
        }
    }
}
