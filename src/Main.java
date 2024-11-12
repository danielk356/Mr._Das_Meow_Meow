import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cat pleio = new Cat(100, 100, 100, 100, true, "Pleio", false);
        Cat koopa = new Cat(100, 100, 100, 100, true, "Koopa", false);
        Player player = new Player(1000);
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
        System.out.println(intro);
        System.out.println(tutorial);
        int day = 0;
        while ((pleio.getAliveStatus() && koopa.getAliveStatus() && day <= 7)) {
            System.out.println("Day " + day);
            System.out.println();
            if (day == 0) {
                System.out.println("Intro");
                System.out.println(intro);
                System.out.println();
                System.out.println("Tutorial");
                System.out.println(tutorial);
                System.out.println();
            } else {
                for (int time = 1; time <= 3; time++) {
                    if (time == 1) {
                        System.out.println("Morning");
                    } else if (time == 2) {
                        System.out.println("Afternoon");
                    } else if (time == 3) {
                        System.out.println("Evening");
                    }
                    System.out.println();
                    System.out.println("Your energy: " + player.getPlayerEnergy());
                    System.out.println("1: Feed cat; 2: Play with cats; 3: Put cat to sleep; 4: You sleep; 5: See cats' stats");
                    System.out.print("Your choice? ");
                    int choice = s.nextInt();
                    if (choice == 1) {
                        System.out.print("Pleio or Koopa or both?");
                        String feedChoice = s.nextLine();
                        if (feedChoice.equals("Pleio")) {
                            System.out.println("You fed Pleio. (You no like Koopa? :c)");
                            events.feedCat(pleio);
                        }
                    } else if (choice == 2) {

                    } else if (choice == 3) {

                    } else if (choice == 4) {

                    } else if (choice == 5) {

                    }
                }
            }

            day ++;
        }
    }
}