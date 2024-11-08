public class Player {
    private int energy;

    public Player(int energy) {
        this.energy = energy;
    }

    public int getPlayerEnergy() {
        return energy;
    }

    public void increasePlayerEnergy(int x) {
        energy += x;
        if (energy > 100) {
            energy = 100;
        }
    }

    public void decreasePlayerEnergy(int x) {
        energy -= x;
    }

}
