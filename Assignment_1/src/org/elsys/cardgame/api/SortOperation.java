package org.elsys.cardgame.api;

public class SortOperation extends AbstractOperation {
    public SortOperation() {
        this.setName("sort");
    }

    @Override
    public void execute(GameImpl game) throws CardException {
        game.getDeck().sort();
        for(Card card : game.getDeck().getCards()) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
