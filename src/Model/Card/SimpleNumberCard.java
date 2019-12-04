package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

import javax.swing.*;

/**
 * Class for numbered cards
 */
public class SimpleNumberCard extends Card {
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public SimpleNumberCard(int number, String ability, ImageIcon image) {
        super(number,ability,image);
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck){
        return true;
    }

}

