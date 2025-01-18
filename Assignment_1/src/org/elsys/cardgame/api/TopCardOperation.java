package org.elsys.cardgame.api;

public class TopCardOperation extends AbstractOperation {
    public TopCardOperation() {
        this.setName("top_card");
    }

    @Override
    public void execute(GameImpl game) throws CardException {
        if(game.getDeck().getSize() < 1) {
            throw new CardException("ERROR: Not enough cards in deck");
        }
        System.out.println(game.getDeck().getCards().getFirst());
    }
}
