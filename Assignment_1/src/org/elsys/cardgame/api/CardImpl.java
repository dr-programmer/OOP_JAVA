package org.elsys.cardgame.api;

public class CardImpl implements Card {
    private Rank rank;
    private Suit suit;

    public CardImpl(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card other) {
        return this.suit.compareTo(other.getSuit());
    }
}
