public class Cat {
    private int health;
    private int hunger;
    private int thirst;
    private int mood;
    private boolean alive;
    private boolean isSleeping;
    private String name;

    public Cat(int health, int hunger, int thirst, int mood, boolean alive, String name, boolean isSleeping) {
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.mood = mood;
        this.alive = alive;
        this.name = name;
        this.isSleeping = isSleeping;
    }

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

    public void decreaseHealth(int x) {
        health -= x;
        if (health < 0) {
            health = 0;
        }
    }

    public void decreaseHunger(int x) {
        hunger -= x;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void decreaseThirst(int x) {
        thirst -= x;
        if (thirst < 0) {
            thirst = 0;
        }
    }

    public void decreaseMood(int x) {
        mood -= x;
        if (mood < 0) {
            mood = 0;
        }
    }

    public void increaseHealth(int x) {
        health += x;
        if (health > 100) {
            health = 100;
        }
    }

    public void increaseHunger(int x) {
        hunger += x;
        if (hunger > 100) {
            hunger = 100;
        }
    }

    public void increaseThirst(int x) {
        thirst += x;
        if (thirst > 100) {
            thirst = 100;
        }
    }

    public void increaseMood(int x) {
        mood += x;
        if (mood > 100) {
            mood = 100;
        }
    }

    public void changeAliveStatus() {
        alive = !(alive);
    }

    public void changeIsSleeping(boolean b) {
        isSleeping = !(isSleeping);
    }

}
