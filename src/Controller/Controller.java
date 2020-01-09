package Controller;

import Model.Deck.Deck;

public class Controller {
    protected Deck deck;
    public static String path="/home/satist/IdeaProjects/Project_Sorry/src/images/";
    private int turn;
    private boolean first=true;

    public Controller(Deck deck,int turn){
        this.deck=deck;
        this.turn=turn;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets Turn of player
     * @param turn
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondition</b> Returns the turn of player
     * @return turn
     */
    public int getTurn(){
        return turn;
    }


    public boolean getfirstTime(){
        return first;
    }


    public void setfirstTime(){
        first=false;
    }
    /**
     * Ends the game
     */
    public void endgame(){

    }


}
