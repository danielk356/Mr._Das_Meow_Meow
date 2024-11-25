import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initialize the objects
        Cat pleio = new Cat(100, 100, 100, 100, true, "Pleio", false);
        Cat koopa = new Cat(100, 100, 100, 100, true, "Koopa", false);
        Player player = new Player(100);
        Actions actions = new Actions(pleio, koopa, player, false);

        //The intro message
        String intro = "Mr. Das entrusted his two cats, Pleio and Koopa, to you. You must take care of them.\n";
        intro += "You must feed them, put them to sleep for the night, and save them from dangerous situations.\n";
        intro += "Why are you doing this?\nIt cuz you have a bad grade in APCSA and you need extra credit to pass haiyaaa.\n";
        intro += "If you don't take care of the cats well, Mr. Das will give you a fat zero, but if you manage to do your job well,you get 100.\n";
        intro += "Have fun! :D (go suffer u failure)";

        //The tutorial message
        String tutorial = "Each cat have a health bar, hunger bar, thirst bar, and mood bar. If hunger and/or thirst is low, mood goes down.\n";
        tutorial += "If mood is low, cats will perform some special events. If hunger or thirst is 0, the cat loses health daily.\n";
        tutorial += "You have an energy bar (stat, not food). Each action you take uses some energy. If you don't have enough energy for an action, you can't do it.\n";
        tutorial += "You have to take care of the cats for 7 days. If even a single cat dies, you get a fat 0 from Mr. Das.";

        //set up the loop
        Scanner s = new Scanner(System.in);
        int day = 0;
        boolean thereIsEvent = false;
        while ((pleio.getAliveStatus() && koopa.getAliveStatus()) && day <= 7) { //the while loop lasts 8 iterations
            System.out.println("Day " + day);
            //day 0 is an overview of the game
            if (day == 0) {
                System.out.println("Intro");
                System.out.println(intro);
                System.out.println();
                System.out.println("Tutorial");
                System.out.println(tutorial);
                System.out.print("Enter any character to continue: ");
                String enter = s.next();

                //the game starts at day 1
            } else {
                System.out.println("Awake now? Good cuz the cats are also awake. Go do your job u failure haiyaaa");
                System.out.println();
                pleio.changeIsSleeping(false);
                koopa.changeIsSleeping(false);
                for (int time = 1; time <= 3; time++) { //there is 3 time periods each day: morning, afternoon, evening
                    if (time == 1) {
                        System.out.println("Morning");
                    } else if (time == 2) {
                        System.out.println("Afternoon");
                    } else if (time == 3) {
                        System.out.println("Evening");
                    }
                    System.out.println();
                    System.out.println("Pleio: " + pleio.catNoises());
                    System.out.println("Koopa: " + koopa.catNoises());

                    // each time period have a %50 of triggering a random event.
                    int eventChance = (int) (Math.random() * 2) + 1;
                    if (eventChance == 1 || (pleio.getMood() < 50 || koopa.getMood() < 50)) {
                        thereIsEvent = true;
                    } else {
                        thereIsEvent = false;
                    }

                    //if no events were triggered for the time period, the cats' stats decrease
                    if (!thereIsEvent) {
                        pleio.decreaseHunger(20);
                        pleio.decreaseThirst(20);
                        pleio.decreaseMood(30);
                        koopa.decreaseHunger(20);
                        koopa.decreaseThirst(20);
                        koopa.decreaseMood(30);
                        if (pleio.getHunger() < 50 || pleio.getThirst() < 50) {
                            pleio.decreaseMood(10);
                        }
                        if (koopa.getHunger() < 50 || koopa.getThirst() < 50) {
                            koopa.decreaseMood(10);
                        }
                    }

                    //if the cats have 0 hunger or 0 thirst, they lose health each time period.
                    if (pleio.getHunger() == 0 || pleio.getThirst() == 0) {
                        pleio.decreaseHealth(20);
                    }
                    if (koopa.getHunger() == 0 || koopa.getThirst() == 0) {
                        koopa.decreaseHealth(20);
                    }

                    int choice = 0;

                    //when either one of the cats' health reach zero, the loop immediately ends.
                    if (pleio.getHealth() == 0 && koopa.getHealth() == 0) {
                        pleio.changeAliveStatus();
                        koopa.changeAliveStatus();
                        time = 3;
                        choice = 6;
                    } else if (pleio.getHealth() == 0) {
                        pleio.changeAliveStatus();
                        time = 3;
                        choice = 6;
                    } else if (koopa.getHealth() == 0) {
                        koopa.changeAliveStatus();
                        time = 3;
                        choice = 6;
                    }

                    //the while loop when there is no events
                    while (choice != 6 && !thereIsEvent) {
                        System.out.println("Your energy: " + player.getPlayerEnergy());
                        System.out.println("1: Feed cat; 2: Play with cats; 3: Put cat to sleep; 4: You sleep; 5: See cats' stats; 6: Continue");
                        System.out.print("Your choice? ");
                        choice = s.nextInt();

                        //different choices, different actions will take place.
                        if (choice == 1) {
                            if (player.getPlayerEnergy() >= 10) {
                                System.out.print("Pleio or Koopa? ");
                                String feedChoice = s.next();
                                if (feedChoice.equals("Pleio") || feedChoice.equals("pleio")) {
                                    if (pleio.getIsSleeping()) {
                                        System.out.println("Pleio is sleeping :/");
                                    } else {
                                        System.out.println("You fed Pleio. (You no like Koopa? :c)");
                                        System.out.println("Pleio's hunger, thirst, and mood increased by 20. Your energy decreased by 10.");
                                        actions.feedCat(pleio);
                                    }
                                } else if (feedChoice.equals("Koopa") || feedChoice.equals("koopa")) {
                                    if (koopa.getIsSleeping()) {
                                        System.out.println("Koopa is sleeping :/");
                                    } else {
                                        System.out.println("You fed Koopa. (You no like Pleio? :c)");
                                        System.out.println("Koopa's hunger, thirst, and mood increased by 20. Your energy decreased by 10.");
                                        actions.feedCat(koopa);
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
                                    actions.playWithCats();
                                } else if (koopa.getIsSleeping()) {
                                    System.out.println("Koopa is sleeping. You can play with Pleio though :D");
                                    System.out.println("You petted and played with Pleio. Pleio's mood increased by 30. Your energy decreased by 30.");
                                    actions.playWithCats();
                                } else if (!koopa.getIsSleeping() && !pleio.getIsSleeping()) {
                                    System.out.println("Yay both cats are awake :D");
                                    System.out.println("You are happy and played with them like the cat lover you are. Both cats' mood increased by 30. Your energy decreased by 30.");
                                    actions.playWithCats();
                                }
                            } else {
                                System.out.println("You don't have enough energy haiyaa");
                                System.out.println("You so weak. Your ancestors look down on you haiyyaaaaaa");
                            }

                        } else if (choice == 3) {
                            if (time == 3) {
                                if (player.getPlayerEnergy() >= 30) {
                                    actions.putCatsToSleep();
                                    if (actions.getSuccess()) {
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
                                actions.playerSleep();
                                choice = 6;
                            } else {
                                System.out.println("You can only sleep at night time. Haiyaaaa");
                            }

                        } else if (choice == 5) {
                            System.out.println(pleio);
                            System.out.println("----------------------------------------------");
                            System.out.println(koopa);

                        } else if (choice > 6 || choice < 1) {
                            System.out.println("That's not a valid choice.");
                        }
                        System.out.println();
                    }

                    //the while loop when there is events
                    while (thereIsEvent && (pleio.getAliveStatus() && koopa.getAliveStatus())) {
                        if (pleio.getMood() < 50 || koopa.getMood() < 50) { //the special event when cats' mood are under 50
                            System.out.println("The cats are sad. They ran away from home.");
                            System.out.print("Find them?");
                            System.out.println("1: Yes; 2: No");
                            System.out.print("Your choice? ");
                            choice = s.nextInt();
                            if (choice == 1) {
                                System.out.println("You went outside (about time u stinky). You searched for the cats and found them in your ex's house.");
                                System.out.println("Wait.. you have an ex??? Nvm");
                                System.out.println("Anyway...you see the cats getting pampered by your ex.");
                                System.out.println("Fueled by jealousy, you angrily barged in your ex's house.");
                                System.out.println("Your ex looks at you.");
                                System.out.println("1: Take the cats; 2: Make up with your ex");
                                System.out.print("Your choice? ");
                                choice = s.nextInt();
                                if (choice == 1) {
                                    System.out.println("You told your ex that the cats belong to you.");
                                    System.out.println("Your ex reluctantly let you take take the cats.");
                                    System.out.println("You expected more? Ha imagine");
                                    System.out.println("Your energy decreased by 10. Both cats' mood increased by 30.");
                                    player.decreasePlayerEnergy(10);
                                    pleio.increaseMood(30);
                                    koopa.increaseMood(30);
                                    thereIsEvent = false;
                                } else if (choice == 2) {
                                    System.out.println("WOWWWW YOU PRIORITIZE YOUR EX OVER CATS? Whatever you do you.");
                                    System.out.println("You told your ex you missed him/her. You want to go back with him/her.");
                                    System.out.println("Some romantic stuff happened that I'm not going to specify.");
                                    System.out.println("You took back the cats and kissed him/her goodbye. Happy ending :)");
                                    System.out.println("Your energy decreased by 20. Both cats' mood increased by 30.");
                                    player.decreasePlayerEnergy(20);
                                    pleio.increaseMood(30);
                                    koopa.increaseMood(30);
                                    thereIsEvent = false;
                                }
                            } else if (choice == 2) {
                                System.out.println("Wow what is wrong with you?");
                                System.out.println("So you stayed home, absolutely not caring about the cats. You're a monster.");
                                System.out.println("The cats died because you didn't care for them.");
                                pleio.decreaseHealth(100);
                                koopa.decreaseHealth(100);
                                thereIsEvent = false;
                            }
                        } else {
                            //the random events that can occur throughout the loop. There are 5 randomized events
                            int randomEvent = (int) (Math.random() * 5) + 1;

                            if (randomEvent == 1) {
                                System.out.println("NOOOO PLEIO IS LICKING GASOLINE!!!");
                                System.out.println("1: You grab Pleio and rush him to the vet; 2: You leave him alone; 3: You take Pleio home and gave him home meds");
                                System.out.print("Your choice? ");
                                choice = s.nextInt();
                                if (choice == 1) {
                                    System.out.println("Very responsible!! You grabbed Pleio and took him to the vet.");
                                    System.out.println("You told the vet that Pleio was licking gasoline.");
                                    System.out.println("The vet gave Pleio some magical treatments. He said Pleio will be okay.");
                                    System.out.println("1: Give the vet a tip; 2: Take Pleio home without giving a tip");
                                    System.out.print("Your choice? ");
                                    choice = s.nextInt();
                                    if (choice == 1) {
                                        System.out.println("You tipped the vet one cent. You cheapskate. Haiyaaa you are sooo poor.");
                                        System.out.println("The vet frowned at you as you take Pleio home.");
                                        System.out.println("Your energy decreased by 10. Pleio's mood increased by 20.");
                                        player.decreasePlayerEnergy(10);
                                        pleio.increaseMood(20);
                                        pleio.increaseHealth(20);
                                        thereIsEvent = false;
                                    } else if (choice == 2) {
                                        System.out.println("You went home with Pleio. No drama :)");
                                        System.out.println("Your energy decreased by 10. Pleio's mood and health increased by 20.");
                                        player.decreasePlayerEnergy(10);
                                        pleio.increaseMood(20);
                                        pleio.increaseHealth(20);
                                        thereIsEvent = false;
                                    }
                                } else if (choice == 2) {
                                    System.out.println("You left him alone. Pleio died. What did you expect? \uD83D\uDC80");
                                    pleio.decreaseHealth(100);
                                    thereIsEvent = false;
                                } else if (choice == 3) {
                                    System.out.println("Completely confident in your abilities, you gave Pleio home meds.");
                                    System.out.println("You accidentally gave Pleio too much pills, so Pleio died from an overdose.");
                                    System.out.println("Baka \uD83D\uDC80");
                                    pleio.decreaseHealth(100);
                                    thereIsEvent = false;
                                }

                            } else if (randomEvent == 2) {
                                System.out.println("Some man walked up to you and asked if he can buy the cats off you.");
                                System.out.println("1: yes; 2: no");
                                System.out.print("Your choice? ");
                                choice = s.nextInt();
                                if (choice == 1) {
                                    System.out.println("You sold the cats to the man for $50. Really bro?");
                                    System.out.println("Oh you have a plan? You going to take the cats back and keep the money? Ok good luck");
                                    System.out.println("So, you secretly followed the man home. How do you get inside?");
                                    System.out.println("1: window; 2: backdoor");
                                    System.out.print("Your choice? ");
                                    choice = s.nextInt();
                                    if (choice == 1) {
                                        System.out.println("You broke into the house through the window. You see the cats get put into cages.");
                                        System.out.println("1: Pray; 2: Fight the man");
                                        System.out.print("Your choice? ");
                                        choice = s.nextInt();
                                        if (choice == 1) {
                                            System.out.println("You prayed to the cat god for help. The cat god looked at you with disappoint.");
                                            System.out.println("The cat god's voice boomed, \"fine I will help, but don't let this happen ever again.\"");
                                            System.out.println("The cat god snapped his fingers and teleported you and the cats back home.");
                                            System.out.println("Your energy decreased by 10. All of the cats' stats increased by 50 thanks to the power of cat god.");
                                            player.decreasePlayerEnergy(10);
                                            pleio.increaseMood(50);
                                            pleio.increaseHealth(50);
                                            pleio.increaseHunger(50);
                                            pleio.increaseThirst(50);
                                            koopa.increaseMood(50);
                                            koopa.increaseHealth(50);
                                            koopa.increaseHunger(50);
                                            koopa.increaseThirst(50);
                                            thereIsEvent = false;
                                        } else if (choice == 2) {
                                            System.out.println("You tried to fight the man, but you lost.");
                                            System.out.println("Haiyaaa you ran home, and Mr. Das is furious.");
                                            pleio.decreaseHealth(100);
                                            koopa.decreaseHealth(100);
                                            thereIsEvent = false;
                                        }

                                    } else if (choice == 2) {
                                        System.out.println("You entered the house through the backdoor. You see a bat and knocked out the man unconscious with it.");
                                        System.out.println("You took the cats and ran home with a crime on your records. Haiyaaa");
                                        System.out.println("Your energy decreased by 10.");
                                        player.decreasePlayerEnergy(10);
                                        thereIsEvent = false;
                                    }
                                } else if (choice == 2) {
                                    System.out.println("Good choice. You did not sell the cats. No drama :)");
                                    thereIsEvent = false;
                                }

                            } else if (randomEvent == 3) {
                                System.out.println("The cat god appeared to you.");
                                System.out.println("He said, \"I can grant you one wish. What is it?\"");
                                System.out.println("1: Restore energy; 2: Restore cats' health; 3: Restore cats' hunger and thirst");
                                System.out.print("Your choice? ");
                                choice = s.nextInt();
                                if (choice == 1) {
                                    System.out.println("The cat god snapped his fingers and gave you 50 energy.");
                                    player.increasePlayerEnergy(50);
                                    thereIsEvent = false;
                                } else if (choice == 2) {
                                    System.out.println("The cat god snapped his fingers and gave the cats 30 health.");
                                    pleio.increaseHealth(30);
                                    koopa.increaseHealth(30);
                                    thereIsEvent = false;
                                } else if (choice == 3) {
                                    System.out.println("The cat god snapped his fingers and gave the cats 30 hunger and 30 thirst.");
                                    pleio.increaseHunger(30);
                                    pleio.increaseThirst(30);
                                    koopa.increaseHunger(30);
                                    koopa.increaseThirst(30);
                                    thereIsEvent = false;
                                }

                            } else if (randomEvent == 4) {
                                System.out.println("A kid wants to play with the cats. Let them?");
                                System.out.println("1: Yes; 2: No");
                                System.out.print("Your choice? ");
                                choice = s.nextInt();
                                if (choice == 1) {
                                    System.out.println("You let the kids play with the cats. The cats purred and had fun. So nice of you :)");
                                    System.out.println("The cats' mood increased by 20. Their hunger and thirst decreased by 10.");
                                    pleio.increaseMood(20);
                                    pleio.decreaseHunger(10);
                                    pleio.decreaseThirst(10);
                                    koopa.increaseMood(20);
                                    koopa.decreaseHunger(10);
                                    koopa.decreaseThirst(10);
                                    thereIsEvent = false;
                                } else if (choice == 2) {
                                    System.out.println("You are so mean haiyaaa. The kid cried.");
                                    System.out.println("Your reputation decreased by 1000 (this is a joke. Rep doesn't exist in this game).");
                                    thereIsEvent = false;
                                }

                            } else if (randomEvent == 5) {
                                System.out.println("The cats are running around the house breaking stuff! Stop them pls");
                                System.out.println("1: Use red dot toy; 2: Stop them using physical force; 3: Do nothing");
                                System.out.print("Your choice? ");
                                choice = s.nextInt();
                                if (choice == 1) {
                                    System.out.println("As a cat genius, you used the red dot toy to distract the cats.");
                                    System.out.println("The cats were drawn to the red dot and started chasing it. Mission accomplished");
                                    System.out.println("Your energy decreased by 10. The cats' mood increased by 10.");
                                    player.decreasePlayerEnergy(10);
                                    pleio.increaseMood(10);
                                    koopa.increaseMood(10);
                                    thereIsEvent = false;
                                } else if (choice == 2) {
                                    System.out.println("You tried to stop them with physical force.");
                                    System.out.println("The cats scratched you and ran away to a corner of the room.");
                                    System.out.println("Your energy decreased by 30.");
                                    player.decreasePlayerEnergy(30);
                                    thereIsEvent = false;
                                } else if (choice == 3) {
                                    System.out.println("You did nothing. The cats caused mayhem and chaos in the house.");
                                    System.out.println("After a while, the whole house is a mess. You were forced to clean everything up haiyaaa");
                                    System.out.println("Your energy decreased by 40.");
                                    player.decreasePlayerEnergy(40);
                                    thereIsEvent = false;
                                }
                            }
                        }
                        System.out.println();
                    }
                }
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            day ++;
        }

        //prints the message when the cats' are dead or the player kept them alive for 7 days
        if (!pleio.getAliveStatus() && !koopa.getAliveStatus()) {
            System.out.println("BOTH CATS DIED?!! HOW ARE YOU THIS BAD???????");
            System.out.println("MR. DAS IS VERY ANGRY!!! HE WILL HUNT YOU DOWN FOR ETERNITY!");
            System.out.println("Good luck lil bro, but I hope you ain't got that good luck.");
        } else if (!pleio.getAliveStatus()) {
            System.out.println("Pleio is dead. You failure haiyyaaaa.");
            System.out.println("How could you do this to Mr. Das? He gives you a fat zero.");
            System.out.println("Now your parents use physical violence on you because you got the fat zero.");
            System.out.println("Everyone in heaven looks down at you for letting a cat die. Haiyyaaaaa");
        } else if (!koopa.getAliveStatus()) {
            System.out.println("Koopa is dead. You failure haiyyaaaa.");
            System.out.println("How could you do this to Mr. Das? He gives you a fat zero.");
            System.out.println("Now your parents use physical violence on you because you got the fat zero.");
            System.out.println("Everyone in heaven looks down at you for letting a cat die. Haiyyaaaaa");
        } else if (pleio.getAliveStatus() && koopa.getAliveStatus()) {
            System.out.println("Yay both cats are alive. Very good job :D");
            System.out.println("Mr. Das gives you the 100 and your parents are very proud of you.");
            System.out.println("Heaven nods at you with approval. You are a success (i bet you don't get that a lot from your parents)");
        }

    }
}