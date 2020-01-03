package Model.Card;

import Controller.Controller;
import Model.Deck.Deck;
import Model.Pawn.Pawn;

import javax.swing.*;

/**
 * Card 7
 */
public class NumberSevenCard extends SimpleNumberCard {
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public NumberSevenCard(int number) {
        super(number,"7 moves front or split 7 moves between your pawns",new ImageIcon(Controller.path+"cards/card7.png"));
    }

    /**
     * <b>Observer</b>
     * <b>Postcondition</b> Returns if the split of card 7 can be played out
     * @param pawn1
     * @param pawn2
     * @param split1
     * @param split2
     * @return True for success
     */
    public boolean split(Pawn pawn1, Pawn pawn2, int split1, int split2){
        if(split1+split2!=7)
            return false;
        return true;
    }
    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
