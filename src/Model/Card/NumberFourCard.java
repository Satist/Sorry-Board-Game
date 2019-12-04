package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

import javax.swing.*;

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
        super(number,"4 Moves to the back",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\card4.png"));
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
