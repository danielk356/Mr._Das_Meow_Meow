import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cat pleio = new Cat(100, 100, 100, 100, true, "Pleio", false);
        Cat koopa = new Cat(100, 100, 100, 100, true, "Koopa", false);
        Player player = new Player(100);
        Events events = new Events(pleio, koopa, player, false);

        String intro = "Mr. Das entrusted his two cats, Pleio and Koopa, to you. You must take care of them.\n";
        intro += "You must feed them, put them to sleep for the night, and save them from dangerous situations.\n";
        intro += "Why are you doing this?\nIt cuz you have a bad grade in APCSA and you need extra credit to pass haiyaaa.\n";
        intro += "If you don't take care of the cats well, Mr. Das will give you a fat zero, but if you manage to do your job well,you get 100.\n";
        intro += "Have fun! :D (go suffer u failure)";

        String tutorial = "Each cat have a health bar, hunger bar, thirst bar, and mood bar. If hunger and/or thirst is low, mood goes down.\n";
        tutorial += "If mood is low, cats will perform some special events. If hunger or thirst is 0, the cat loses health daily.\n";
        tutorial += "You have an energy bar (stat, not food). Each action you take uses some energy. If you don't have enough energy for an action, you can't do it.\n";
        tutorial += "You have to take care of the cats for 7 days. If even a single cat dies, you get a fat 0 from Mr. Das.";

        Scanner s = new Scanner(System.in);
        int day = 0;
        boolean thereIsEvent = false;
        while ((pleio.getAliveStatus() && koopa.getAliveStatus()) && day <= 7) {
            System.out.println("Day " + day);
            if (day == 0) {
                System.out.println("Intro");
                System.out.println(intro);
                System.out.println();
                System.out.println("Tutorial");
                System.out.println(tutorial);
            } else {
                System.out.println("Awake now? Good cuz the cats are also awake. Go do your job u failure haiyaaa");
                System.out.println();
                pleio.changeIsSleeping(false);
                koopa.changeIsSleeping(false);
                for (int time = 1; time <= 3; time++) {
                    if (time == 1) {
                        System.out.println("Morning");
                    } else if (time == 2) {
                        System.out.println("Afternoon");
                    } else if (time == 3) {
                        System.out.println("Evening");
                    }
                    System.out.println();

                    if (!thereIsEvent) {
                        pleio.decreaseHunger(20);
                        pleio.decreaseThirst(20);
                        pleio.decreaseMood(30);
                        koopa.decreaseHunger(20);
                        koopa.decreaseThirst(20);
                        koopa.decreaseMood(30);
                        if (pleio.getHunger() < 50 || pleio.getThirst() < 50) {
                            pleio.decreaseMood(10);
                        } else if (koopa.getHunger() < 50 || koopa.getThirst() < 50) {
                            koopa.decreaseMood(10);
                        }
                    }

                    if (pleio.getHunger() == 0 || pleio.getThirst() == 0) {
                        pleio.decreaseHealth(20);
                    }
                    if (koopa.getHunger() == 0 || koopa.getThirst() == 0) {
                        koopa.decreaseHealth(20);
                    }

                    int choice = 0;

                    if (pleio.getHealth() == 0 || koopa.getHealth() == 0) {
                        time = 3;
                        choice = 6;
                    }
                    while (choice != 6 && !thereIsEvent) {
                        System.out.println("Your energy: " + player.getPlayerEnergy());
                        System.out.println("1: Feed cat; 2: Play with cats; 3: Put cat to sleep; 4: You sleep; 5: See cats' stats; 6: Continue");
                        System.out.print("Your choice? ");
                        choice = s.nextInt();

                        if (choice == 1) {
                            if (player.getPlayerEnergy() >= 10) {
                                System.out.print("Pleio or Koopa? ");
                                String feedChoice = s.next();
                                if (feedChoice.equals("Pleio")) {
                                    if (pleio.getIsSleeping()) {
                                        System.out.println("Pleio is sleeping :/");
                                    } else {
                                        System.out.println("You fed Pleio. (You no like Koopa? :c)");
                                        System.out.println("Pleio's hunger, thirst, and mood increased by 20. Your energy decreased by 10.");
                                        events.feedCat(pleio);
                                    }
                                } else if (feedChoice.equals("Koopa")) {
                                    if (koopa.getIsSleeping()) {
                                        System.out.println("Koopa is sleeping :/");
                                    } else {
                                        System.out.println("You fed Koopa. (You no like Pleio? :c)");
                                        System.out.println("Koopa's hunger, thirst, and mood increased by 20. Your energy decreased by 10.");
                                        events.feedCat(koopa);
                                    }
                                }
                            } else {
                                System.out.println("You don't have enough energy haiyaa");
                                System.out.println("You so weak. Your ancestors look down on you haiyyaaaaaa");
                            }

                        } else if (choice == 2) {
                            if (player.getPlayerEnergy() >= 30) {
                                if (pleio.getIsSleeping() && koopa.getIsSleeping()) {
                                    System.out.println("Shhhhh they are sleeping right now. Play with them later.");
                                } else if (pleio.getIsSleeping()) {
                                    System.out.println("Pleio is sleeping. You can play with koopa though :D");
                                    System.out.println("You petted and played with Koopa. Koopa's mood increased by 30. Your energy decreased by 30.");
                                    events.playWithCats();
                                } else if (koopa.getIsSleeping()) {
                                    System.out.println("Koopa is sleeping. You can play with Pleio though :D");
                                    System.out.println("You petted and played with Pleio. Pleio's mood increased by 30. Your energy decreased by 30.");
                                    events.playWithCats();
                                } else if (!koopa.getIsSleeping() && !pleio.getIsSleeping()) {
                                    System.out.println("Yay both cats are awake :D");
                                    System.out.println("You are happy and played with them like the cat lover you are. Both cats' mood increased by 30. Your energy decreased by 30.");
                                    events.playWithCats();
                                }
                            } else {
                                System.out.println("You don't have enough energy haiyaa");
                                System.out.println("You so weak. Your ancestors look down on you haiyyaaaaaa");
                            }

                        } else if (choice == 3) {
                            if (time == 3) {
                                if (player.getPlayerEnergy() >= 30) {
                                    events.putCatsToSleep();
                                    if (events.getSuccess()) {
                                        System.out.println("The cats are sleeping. Your energy decreased by 20.");
                                    } else {
                                        System.out.println("The cats rebelled. Haiyaa you have skill issue. Your energy decreased by 30");
                                    }
                                } else {
                                    System.out.println("You don't have enough energy haiyaa");
                                    System.out.println("You so weak. Your ancestors look down on you haiyyaaaaaa");
                                }
                            } else {
                                System.out.println("Go play with the cats. It ain't night time yet -_-");
                            }

                        } else if (choice == 4) {
                            if (time == 3) {
                                System.out.println("You went to sleep. You will gain 50 energy.");
                                events.playerSleep();
                                choice = 6;
                            } else {
                                System.out.println("You can only sleep at night time. Haiyaaaa");
                            }

                        } else if (choice == 5) {
                            System.out.println("Pleio");
                            System.out.println("Health: " + pleio.getHealth());
                            System.out.println("Hunger: " + pleio.getHunger());
                            System.out.println("Thirst: " + pleio.getThirst());
                            System.out.println("Mood: " + pleio.getMood());
                            System.out.println("Alive: " + pleio.getAliveStatus());
                            System.out.println("Sleeping: " + pleio.getIsSleeping());
                            System.out.println("----------------------------------------------");
                            System.out.println("Koopa");
                            System.out.println("Health: " + koopa.getHealth());
                            System.out.println("Hunger: " + koopa.getHunger());
                            System.out.println("Thirst: " + koopa.getThirst());
                            System.out.println("Mood: " + koopa.getMood());
                            System.out.println("Alive: " + koopa.getAliveStatus());
                            System.out.println("Sleeping: " + koopa.getIsSleeping());
                        }
                        System.out.println();
                    }
                }
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            day ++;
        }


    }
}