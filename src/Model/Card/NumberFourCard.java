package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * Card 4
 */
public class NumberFourCard extends SimpleNumberCard {
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public NumberFourCard(int number) {
        super(number,"4 Moves to the back");
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
