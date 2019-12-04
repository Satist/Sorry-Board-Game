package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

import javax.swing.*;

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
        super(number,"If you are on start, Move",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\card1.png"));
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
