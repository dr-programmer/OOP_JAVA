package org.elsys.cardgame.api;

public class DrawTopCardOperation extends AbstractOperation {
    public DrawTopCardOperation() {
        this.setName("draw_top_card");
    }

    @Override
    public void execute(GameImpl game) throws CardException {
        if(game.getDeck().getSize() < 1) {
            throw new CardException("ERROR: Not enough cards in deck");
        }
        System.out.println(game.getDeck().takeTopCard());
    }
}
