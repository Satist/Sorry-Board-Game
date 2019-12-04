package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

import javax.swing.*;

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
        super(number,"If u are on Start, Move & You must play again",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\card2.png"));
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
