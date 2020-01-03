package Model.Card;

import Controller.Controller;
import Model.Deck.Deck;
import Model.Pawn.Pawn;

import javax.swing.*;

public class SorryCard extends Card{
    /**
     * <b>Constructor</b>
     *
     * @param number
     */
    public SorryCard(int number) {
        super(number, "If u are on Start, move your pawn on an opponents position and the pawn of the opponent returns on the start",new ImageIcon(Controller.path+"cards/cardSorry.png"));
    }

    @Override
    public boolean movePawn(Pawn pawn, Deck deck) {
        return false;
    }
}
