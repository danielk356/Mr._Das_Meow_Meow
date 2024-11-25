/**
 * The Actions class represent the actions. The actions are based on Cat objects and Player object.
 * There is also a boolean instance variable: success.
 */

public class Actions {
    private Cat pleio;
    private Cat koopa;
    private Player player;
    private boolean success;

    /**
     * Constructor for the Actions class. This creates a new instance of an Actions given
     * the below parameters.
     *
     * @param pleio represents pleio, a Cat object.
     * @param koopa represents koopa, a Cat object.
     * @param player represents player, a Player object.
     * @param success represents success.
     */
    public Actions(Cat pleio, Cat koopa, Player player, boolean success) {
        this.pleio = pleio;
        this.koopa = koopa;
        this.player = player;
        this.success = success;
    }

    /**
     * The getSuccess method returns a boolean which represents the success of the Actions.
     *
     * @return an int which represents the energy of the Player.
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * The feedCat method increases the mood, hunger, and thirst of cat by 20. Decrease player's energy by 10.
     */
    public void feedCat(Cat cat) {
        player.decreasePlayerEnergy(10);
        cat.increaseMood(20);
        cat.increaseHunger(20);
        cat.increaseThirst(20);
    }

    /**
     * The playerSleep method is an action that increases the player's energy by 50.
     */
    public void playerSleep() {
        player.increasePlayerEnergy(50);
    }

    /**
     * The putCatToSleep method is an action that have a success rate of 50%. If successful, the cats' isSleeping will be true.
     * If not successful, the cats' isSleeping remain unchanged and reduces the player's energy more.
     */
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

    /**
     * The playWithCats method will decrease the player's energy by 30. The cats' mood will increase by 40
     * if isSleeping is false.
     */
    public void playWithCats() {
        player.decreasePlayerEnergy(30);
        if (!pleio.getIsSleeping()) {
            pleio.increaseMood(40);
        }
        if (!koopa.getIsSleeping()){
            koopa.increaseMood(40);
        }


    }


}
