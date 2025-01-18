package org.elsys.cardgame.api;

import java.util.Objects;

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

    @Override
    public String toString() {
        if(rank.ordinal() < Rank.JACK.ordinal()) {
            return String.format("%c%d", suit.toString().charAt(0), rank.ordinal() + 2);
        }
        return String.format("%c%c", suit.toString().charAt(0), rank.toString().charAt(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardImpl card)) return false;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
