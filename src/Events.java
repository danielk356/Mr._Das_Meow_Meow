public class Events {
    private Cat pleio;
    private Cat koopa;
    private Player player;

    public Events(Cat pleio, Cat koopa, Player player) {
        this.pleio = pleio;
        this.koopa = koopa;
        this.player = player;
    }

    public void feedCat(Cat cat) {
        player.decreasePlayerEnergy(10);
        cat.increaseMood(20);
    }

    public void playerSleep() {
        player.increasePlayerEnergy(30);
    }

    public void putCatsToSleep() {
        int chance = (int) (Math.random() * 2) + 1;
        if (chance == 1) {
            player.decreasePlayerEnergy(20);
            pleio.changeIsSleeping();
            koopa.changeIsSleeping();
        } else {
            player.decreasePlayerEnergy(30);
        }
    }


}
