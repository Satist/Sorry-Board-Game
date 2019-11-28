package Model.Square;

import Model.Pawn.Pawn;

/**
 * <b>Abstract class</b> Square
 * @author glamprou 3976
 */
public abstract class Square {
    private int position;
    private String color="Λευκο";

    /**
     * <b>Constructor</b>
     * @param position
     * @param color
     */
    Square(int position,String color){
        this.position=position;
        this.color=color;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondition</b> Returns the position of square
     * @return position
     */
    public int getPosition() {
        return position;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondition</b> Returns the color of the square
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets the position of the square
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets the color of the square
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * <b>Observer</b>
     * Checks if there is a pawn on the square
     * @param pawn
     * @return True if there is a pawn
     */
    public boolean checkPawn(Pawn pawn){

    }
}
