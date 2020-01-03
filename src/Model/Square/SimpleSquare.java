package Model.Square;

import Controller.Controller;

import javax.swing.*;

public class SimpleSquare extends Square {
    /**
     * <b>Constructor</b>
     *
     * @param position
     * @param color
     */
    public SimpleSquare(int position, String color) {
        super(position, color,new ImageIcon(Controller.path+"simpleSquare.png"));
    }
}
