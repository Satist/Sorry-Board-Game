package Model.Square;

import Model.Player.Player;

public class SafetyZoneSquare extends Square{
    private Player player;
    /**
     * <b>Constructor</b>
     *
     * @param position
     * @param color
     */
    public SafetyZoneSquare(int position, String color) {
        super(position, color);
    }

    /**
     * <b>Accessor</b>
     * <b>Postcondtion</b> Returns the player/owner of the start square
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * <b>Transformer</b>
     * <b>Postcondtion</b> Sets the player/owner of the start square
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}