package dhbw.IPoAC;

import dhbw.IPoAC.commands.Commands;
import dhbw.IPoAC.events.Event;
import dhbw.IPoAC.player.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Commands commands = new Commands();
        Player player = new Player();
        Event event = new Event();

        Scanner in = new Scanner(System.in);
        System.out.println("IPoAC Tycoon");
        System.out.println("Enter <HELP> for a list of avaliable commands");

        String s = "";

        while (in.hasNextLine()) {
            s = in.nextLine();
            // Decode commands and main loop of the game
            if (s.toUpperCase().contains("BUY")) {
                commands.buy(s.toUpperCase(), player);
            } else if (s.toUpperCase().contains("UPGRADE")) {
                commands.increase(s.toUpperCase(), player);
            } else if (s.toUpperCase().contains("NEXT DAY")) {
                commands.nextDay(player);
            } else if (s.toUpperCase().contains("SEND")) {
                commands.send(player);
            } else if (s.toUpperCase().contains("STATS")) {
                commands.stats(player);
            } else if (s.toUpperCase().contains("HELP")) {
                commands.help();
            } else if (s.toUpperCase().contains("RELEASE")) {
                commands.releaseBird(s, player);
            } else if (s.toUpperCase().contains("LIST")) {
                commands.listAllBirds(player);
            }
            //Exit game
            if (s.equalsIgnoreCase("EXIT")) {
                break;
            }

            //Do Events
            Random random = new Random();
            event.doSomethingGoodOrBad(random.nextInt(100), player);

        }

    }
}
