package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * Card 11
 */
public class NumberElevenCard extends SimpleNumberCard {
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public NumberElevenCard(int number) {
        super(number,"11 Moves front or exchange position with an opponents pawn");
    }

    /**
     * Checks the pawn of the opponent for later use on movePawn
     * @param pawnOpponent
     * @return pawnOpponent
     */
    public Pawn getPawnOpponent(Pawn pawnOpponent){
        return pawnOpponent;
    }
    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
