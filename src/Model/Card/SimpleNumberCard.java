package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * Class for numbered cards
 */
public class SimpleNumberCard extends Card {
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public SimpleNumberCard(int number,String ability) {
        super(number,ability);
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck){
    }

}

