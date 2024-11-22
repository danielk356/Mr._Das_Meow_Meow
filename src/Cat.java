public class Cat {
    private int health;
    private int hunger;
    private int thirst;
    private int mood;
    private boolean alive;
    private boolean isSleeping;
    private String name;

    //constructor method for the cats with all their instance variables
    public Cat(int health, int hunger, int thirst, int mood, boolean alive, String name, boolean isSleeping) {
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.mood = mood;
        this.alive = alive;
        this.name = name;
        this.isSleeping = isSleeping;
    }

    //randomly returns cat noises
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

    //getter methods for all the cat object's instance variables
    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getMood() {
        return mood;
    }

    public boolean getAliveStatus() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public boolean getIsSleeping() {
        return isSleeping;
    }

    //decrease cat's health
    public void decreaseHealth(int x) {
        health -= x;
        if (health < 0) {
            health = 0;
        }
    }

    //decreases cat's hunger
    public void decreaseHunger(int x) {
        hunger -= x;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    //decreases cat's thirst
    public void decreaseThirst(int x) {
        thirst -= x;
        if (thirst < 0) {
            thirst = 0;
        }
    }

    //decreases cat's mood
    public void decreaseMood(int x) {
        mood -= x;
        if (mood < 0) {
            mood = 0;
        }
    }

    //increases cat's health
    public void increaseHealth(int x) {
        health += x;
        if (health > 100) {
            health = 100;
        }
    }

    //increases cat's hunger
    public void increaseHunger(int x) {
        hunger += x;
        if (hunger > 100) {
            hunger = 100;
        }
    }

    //increases cat's thirst
    public void increaseThirst(int x) {
        thirst += x;
        if (thirst > 100) {
            thirst = 100;
        }
    }

    //increases cat's mood
    public void increaseMood(int x) {
        mood += x;
        if (mood > 100) {
            mood = 100;
        }
    }

    //changes cat's alive status to the opposite
    public void changeAliveStatus() {

        alive = !(alive);
    }

    //changes cat's sleeping status to boolean b
    public void changeIsSleeping(boolean b) {
        isSleeping = b;
    }

    //returns the string, which contains all the stats of a cat
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
