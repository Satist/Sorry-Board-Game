package Model.Card;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

import javax.swing.*;
import java.awt.*;

/**
 * <b>Abstract class</b> Cards
 * @author glamprou 3976
 */
public  abstract class Card {
    private int number;
    private String ability;
    private ImageIcon image;
    /**
     * <b>Accessor</b>
     * @return number of card
     */
    public int getNumber() {
        return number;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets number of card
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets ability of card
     * @param ability
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }

    /**
     * <b>Accessor</b>
     * <b>PostCondition</b> Returns ability of card
     * @return ability
     */
    public String getAbility() {
        return ability;
    }
    /**<b>Constructor</b>
     * @param number
     */
    Card(int number,String ability,ImageIcon image){
        this.number=number;
        this.ability=ability;
        this.image=image;
    }

    /**
     * <b>Observer</b> Checks if the pawn can play the card
     * <b>Postcondition</b> Returns TRUE if the pawn can play the card
     * @param pawn
     * @param deck
     */
    public abstract boolean movePawn(Pawn pawn, Deck deck);

    /**
     * <b>Accessor</b>
     * <b>Postcondtion</b> Returns the image of the card
     * @return image
     */
    public ImageIcon getImage() {
        return image;
    }
}
