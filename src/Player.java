public class Player {
    private int energy;

    //constructor method only have one parameter: energy
    public Player(int energy) {
        this.energy = energy;
    }

    //getter method for player's energy
    public int getPlayerEnergy() {
        return energy;
    }

    //method for increasing player's energy
    public void increasePlayerEnergy(int x) {
        energy += x;
        if (energy > 100) {
            energy = 100;
        }
    }

    //method for decreasing player's energy
    public void decreasePlayerEnergy(int x) {
        energy -= x;
        if (energy > 100) {
            energy = 100;
        }
    }

}
