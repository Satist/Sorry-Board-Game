package Model.Pawn;

import Model.Square.Square;

import javax.swing.*;

public class Pawn {
    private String color;
    private Square square;
    private boolean state;
    private ImageIcon image;
    public Pawn(String color, Square square, ImageIcon image){
        this.color=color;
        this.square=square;
        this.image=image;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets the color of the pawn
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * <b>Accessor</b>
     * <b>Postcondition</b> Returns the color of the pawn
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets the square of the pawn
     * @param square
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondition</b> Returns the square of the pawn
     * @return square
     */
    public Square getSquare() {
        return square;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondition</b> Returns the state of the pawn
     * @return state
     */
    public boolean getState(){
        return state;
    }
    /**
     * <b>Transformer</b>
     * <b>Postcondition</b> Sets the state of the pawn
     * @param state
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondtion</b> Returns the image of the pawn
     * @return image
     */
    public ImageIcon getImage() {
        return image;
    }
}

