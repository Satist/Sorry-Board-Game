package Controller;

import Model.Deck.Deck;

public class Controller {
    protected Deck deck;
    private boolean turn;

    /**
     * <b>Transformer</b>
     * <b>Postcondition<b/> Sets Turn of player
     * @param turn
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondition</b> Returns the turn of player
     * @return turn
     */
    public boolean getTurn(){
        return turn;
    }
    /**
     * If all conditions are true move the pawn
     */
    public void check_move(){
        if(getTurn())
            deck.move();
    }

    /**
     * Ends the game
     */
    public void endgame(){

    }

    /**
     * Sets the winner
     */
    public void winner(){

    }
}