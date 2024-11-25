/**
 * The Player class represent the player. The player has energy.
 */

public class Player {
    private int energy;

    /**
     * Constructor for the Player class. This creates a new instance of a Player given
     * the below parameters.
     *
     * @param energy represents the energy of the player.
     */
    public Player(int energy) {
        this.energy = energy;
    }

    /**
     * The getPlayerEnergy method returns an int which represents the energy of the Player.
     *
     * @return an int which represents the energy of the Player.
     */
    public int getPlayerEnergy() {
        return energy;
    }

    /**
     * The increasePlayerEnergy method increases the energy of a player by x. Energy can't go higher than 100.
     *
     * @param x represents by how much the Player's energy will increase by.
     */
    public void increasePlayerEnergy(int x) {
        energy += x;
        if (energy > 100) {
            energy = 100;
        }
    }

    /**
     * The decreasePlayerEnergy method decreases the energy of a player by x. Energy can't go lower than 0.
     *
     * @param x represents by how much the Player's energy will decrease by.
     */
    public void decreasePlayerEnergy(int x) {
        energy -= x;
        if (energy < 0) {
            energy = 0;
        }
    }

}
