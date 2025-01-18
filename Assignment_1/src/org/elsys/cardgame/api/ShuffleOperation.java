package org.elsys.cardgame.api;

public class ShuffleOperation extends AbstractOperation {
    public ShuffleOperation() {
        this.setName("shuffle");
    }

    @Override
    public void execute(GameImpl game) throws CardException {
        game.getDeck().shuffle();
        for(Card card : game.getDeck().getCards()) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
