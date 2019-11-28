package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * Card 2
 */
public class NumberTwoCard extends SimpleNumberCard {
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public NumberTwoCard(int number) {
        super(number,"If u are on Start, Move & You must play again");
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
