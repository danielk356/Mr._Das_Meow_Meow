public class Actions {
    private Cat pleio;
    private Cat koopa;
    private Player player;
    private boolean success;

    public Actions(Cat pleio, Cat koopa, Player player, boolean success) {
        this.pleio = pleio;
        this.koopa = koopa;
        this.player = player;
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public void feedCat(Cat cat) {
        player.decreasePlayerEnergy(10);
        cat.increaseMood(20);
        cat.increaseHunger(20);
        cat.increaseThirst(20);
    }

    public void playerSleep() {
        player.increasePlayerEnergy(50);
    }

    public void putCatsToSleep() {
        int chance = (int) (Math.random() * 2) + 1;
        if (chance == 1) {
            player.decreasePlayerEnergy(20);
            pleio.changeIsSleeping(true);
            koopa.changeIsSleeping(true);
            success = true;
        } else {
            player.decreasePlayerEnergy(30);
            success = false;
        }
    }

    public void playWithCats() {
        player.decreasePlayerEnergy(30);
        if (!pleio.getIsSleeping()) {
            pleio.increaseMood(30);
        }
        if (!koopa.getIsSleeping()){
            koopa.increaseMood(30);
        }


    }


}
