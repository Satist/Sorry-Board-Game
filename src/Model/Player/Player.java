package Model.Player;

import Model.Pawn.Pawn;

public class Player {
    private Pawn pawn1;
    private Pawn pawn2;
    private String color;
    public Player(Pawn pawn1, Pawn pawn2, String color){
        this.color=color;
        this.pawn1=pawn1;
        this.pawn2=pawn2;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondtions</b> Returns color of player
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets color of player
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondtions</b> Returns pawn 1 of player
     * @return pawn1
     */
    public Pawn getPawn1() {
        return pawn1;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets pawn 1 of player
     * @param pawn1
     */
    public void setPawn1(Pawn pawn1) {
        this.pawn1 = pawn1;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondtions</b> Returns pawn 2 of player
     * @return pawn2
     */
    public Pawn getPawn2() {
        return pawn2;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets pawn 2 of player
     * @param pawn2
     */
    public void setPawn2(Pawn pawn2) {
        this.pawn2 = pawn2;
    }

    public boolean checkPlays(Player player){

    }
}
