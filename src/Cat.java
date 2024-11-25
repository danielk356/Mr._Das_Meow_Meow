/**
 * The Cat class represent a cat. A cat is a cat with a name, health, hunger, thirst, mood,
 * alive status, isSleeping status.
 */

public class Cat {
    private int health;
    private int hunger;
    private int thirst;
    private int mood;
    private boolean alive;
    private boolean isSleeping;
    private String name;

    /**
     * Constructor for the Cat class. This creates a new instance of a Cat given
     * the below parameters.
     * @param health represnts the health of the Cat.
     * @param hunger represents the hunger of the Cat.
     * @param thirst represents the thirst of the Cat.
     * @param mood represents the mood of the Cat.
     * @param alive represents the alive status of the Cat.
     * @param name represents the name of the Cat.
     * @param isSleeping represents the isSleeping status of the Cat.
     */
    public Cat(int health, int hunger, int thirst, int mood, boolean alive, String name, boolean isSleeping) {
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.mood = mood;
        this.alive = alive;
        this.name = name;
        this.isSleeping = isSleeping;
    }

    /**
     * The catNoises method will randomly return cat noises that can be printed out in the runner class.
     */
    public String catNoises() {
        String catNoise1 = "Mroww";
        String catNoise2 = "Meeeooowww";
        String catNoise3 = "Prrr";
        String catNoise4 = "Mew";
        String catNoise5 = "Rrrrr";
        int randomNum = (int) (Math.random() * 5) + 1;
        if (randomNum == 1) {
            return catNoise1;
        } else if (randomNum == 2) {
            return catNoise2;
        } else if (randomNum == 3) {
            return catNoise3;
        } else if (randomNum == 4) {
            return catNoise4;
        } else if (randomNum == 5) {
            return catNoise5;
        }
        return "";
    }

    /**
     * The getHealth method returns an int which represents the health of the Cat.
     *
     * @return an int which represents the health of the cat.
     */
    public int getHealth() {
        return health;
    }

    /**
     * The getHunger method returns an int which represents the hunger of the Cat.
     *
     * @return an int which represents the hunger of the cat.
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * The getThirst method returns an int which represents the thirst of the Cat.
     *
     * @return an int which represents the thirst of the cat.
     */
    public int getThirst() {
        return thirst;
    }

    /**
     * The getMood method returns an int which represents the mood of the Cat.
     *
     * @return an int which represents the mood of the cat.
     */
    public int getMood() {
        return mood;
    }

    /**
     * The getAliveStatus method returns a boolean which represents the alive status of the Cat.
     *
     * @return a boolean which represents the alive status of the cat.
     */
    public boolean getAliveStatus() {
        return alive;
    }

    /**
     * The getIsSleeping method returns a boolean which represents the isSleeping status of the Cat.
     *
     * @return a boolean which represents the isSleeping status of the cat.
     */
    public boolean getIsSleeping() {
        return isSleeping;
    }

    /**
     * The decreaseHealth method decreases the health of a cat by x. Health can't go lower than 0.
     *
     * @param x represents by how much the Cat's health will decrease by.
     */
    public void decreaseHealth(int x) {
        health -= x;
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * The decreaseHunger method decreases the hunger of a cat by x. Hunger can't go lower than 0.
     *
     * @param x represents by how much the Cat's hunger will decrease by.
     */
    public void decreaseHunger(int x) {
        hunger -= x;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    /**
     * The decreaseThirst method decreases the thirst of a cat by x. Thirst can't go lower than 0.
     *
     * @param x represents by how much the Cat's thirst will decrease by.
     */
    public void decreaseThirst(int x) {
        thirst -= x;
        if (thirst < 0) {
            thirst = 0;
        }
    }

    /**
     * The decreaseMood method decreases the mood of a cat by x. Mood can't go lower than 0.
     *
     * @param x represents by how much the Cat's mood will decrease by.
     */
    public void decreaseMood(int x) {
        mood -= x;
        if (mood < 0) {
            mood = 0;
        }
    }

    /**
     * The increaseHealth method increases the health of a cat by x. Health can't go higher than 100.
     *
     * @param x represents by how much the Cat's health will increase by.
     */
    public void increaseHealth(int x) {
        health += x;
        if (health > 100) {
            health = 100;
        }
    }

    /**
     * The increaseHunger method increases the hunger of a cat by x. Hunger can't go higher than 100.
     *
     * @param x represents by how much the Cat's hunger will increase by.
     */
    public void increaseHunger(int x) {
        hunger += x;
        if (hunger > 100) {
            hunger = 100;
        }
    }

    /**
     * The increaseThirst method increases the thirst of a cat by x. Thirst can't go higher than 100.
     *
     * @param x represents by how much the Cat's thirst will increase by.
     */
    public void increaseThirst(int x) {
        thirst += x;
        if (thirst > 100) {
            thirst = 100;
        }
    }

    /**
     * The increaseMood method increases the mood of a cat by x. Mood can't go higher than 100.
     *
     * @param x represents by how much the Cat's mood will increase by.
     */
    public void increaseMood(int x) {
        mood += x;
        if (mood > 100) {
            mood = 100;
        }
    }

    /**
     * The changeAliveStatus method makes the value of alive the opposite. True to false or false to true.
     */
    public void changeAliveStatus() {

        alive = !(alive);
    }

    /**
     * The changeIsSleeping method changes the sleeping status of a cat to boolean b.
     *
     * @param b represents the boolean value that isSleeping will change to.
     */
    public void changeIsSleeping(boolean b) {
        isSleeping = b;
    }

    /**
     * The changeIsSleeping method changes the sleeping status of a cat to boolean b.
     *
     * @return returns a string which contains all the Cat's instance variables in a list.
     */
    public String toString() {
        String str = name + "\n";
        str += "Health: " + health + "\n";
        str += "Hunger: " + hunger + "\n";
        str += "Thirst: " + thirst + "\n";
        str += "Mood: " + mood + "\n";
        str += "Alive: " + alive + "\n";
        str += "Sleeping: " + isSleeping;
        return str;
    }

}
