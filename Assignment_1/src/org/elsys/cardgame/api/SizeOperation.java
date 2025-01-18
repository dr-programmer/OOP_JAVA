package org.elsys.cardgame.api;

public class SizeOperation extends AbstractOperation {
    public SizeOperation() {
        this.setName("size");
    }

    @Override
    public void execute(GameImpl game) throws CardException {
        System.out.println(game.getDeck().getSize());
    }
}
