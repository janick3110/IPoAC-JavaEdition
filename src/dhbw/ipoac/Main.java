package dhbw.ipoac;

import dhbw.ipoac.commands.Commands;
import dhbw.ipoac.events.Event;
import dhbw.ipoac.player.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("IP over Animal Transport - Tycoon");
        System.out.println("Enter <HELP> for a list of avaliable commands");
        Player player = new Player();
        Commands commands = new Commands(player);
        Event event = new Event();
        Scanner in = new Scanner(System.in);


        String s = "";

        while (in.hasNextLine()) {
            s = in.nextLine();
            // Decode commands and main loop of the game
            if (s.toUpperCase().contains("BUY")) {
                commands.buy(s.toUpperCase());
            } else if (s.toUpperCase().contains("UPGRADE")) {
                commands.increase(s.toUpperCase());
            } else if (s.equalsIgnoreCase("NEXT DAY")) {
                commands.nextDay();
            } else if (s.toUpperCase().contains("SEND")) {
                commands.send(s);
            } else if (s.equalsIgnoreCase("STATS")) {
                commands.stats();
            } else if (s.equalsIgnoreCase("HELP")) {
                commands.help();
            } else if (s.toUpperCase().contains("SELL")) {
                commands.sellObject(s);
            } else if (s.toUpperCase().contains("LIST")) {
                commands.listAllObjectsOfAType();
            } else if (s.equalsIgnoreCase("EXIT")) {
                break;
            } else if (s.equalsIgnoreCase("PUT BEFORE CART")) {
                commands.putCartBeforeAnimals(s);
            } else if (s.toUpperCase().contains("LOAD")) {
                commands.loadTransportDevice(s);
            } else if (s.toUpperCase().contains("ATTACH")) {
                commands.attachTransport(s);
            } else if (s.toUpperCase().contains("GET INVENTORY")) {
                commands.getInventory(s);
            } else if (s.toUpperCase().contains("REMOVE")) {
                commands.removeMediumFromTransport(s);
            } else if (s.toUpperCase().contains("PUFFER")) {
                commands.getPuffer(s);
            } else if (s.toUpperCase().contains("BREED")) {

            }
            //else System.out.println("Please enter a valid command. Use <help> for more information");

            //Do Events
            Random random = new Random();
            event.doSomethingGoodOrBad(random.nextInt(100), player);

        }

    }
}
