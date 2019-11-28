package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * Card 1
 */
public class NumberOneCard extends SimpleNumberCard {
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public NumberOneCard(int number) {
        super(number,"If you are on start, Move");
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
