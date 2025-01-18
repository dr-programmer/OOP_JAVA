package org.elsys.cardgame.api;

public class DealOperation extends AbstractOperation {
    public DealOperation() {
        this.setName("deal");
    }

    @Override
    public void execute(GameImpl game) throws CardException {
        if(game.getDeck().getSize() < game.getDeck().getHandSize()) {
            throw new CardException("ERROR: Not enough cards in deck");
        }
        game.setLastHand(game.getDeck().deal());
        for(Card card : game.getLastHand().getCards()) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
