package org.elsys.cardgame.api;

public class DrawBottomCardOperation extends AbstractOperation {
    public DrawBottomCardOperation() {
        this.setName("draw_bottom_card");
    }

    @Override
    public void execute(GameImpl game) throws CardException {
        if(game.getDeck().getSize() < 1) {
            throw new CardException("ERROR: Not enough cards in deck");
        }
        System.out.println(game.getDeck().takeBottomCard());
    }
}
