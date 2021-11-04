package dhbw.ipoac;

import dhbw.ipoac.commands.CommandList;
import dhbw.ipoac.commands.Commands;
import dhbw.ipoac.events.Event;
import dhbw.ipoac.player.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("IP over Animal Transport - Tycoon");
        System.out.println("Enter <HELP> for a list of available commands");
        Player player = new Player();
        Commands commands = new Commands(player);
        Event event = new Event();
        Scanner in = new Scanner(System.in);


        String s = "";

        while (in.hasNextLine()) {
            s = in.nextLine();
            // Decode commands and main loop of the game
            String command = "";
            try {
                command = s.toUpperCase().substring(0, s.lastIndexOf(" "));
            } catch (StringIndexOutOfBoundsException e) {
                command = s.toUpperCase();
            }

            CommandList availableCommands = CommandList.valueOf(command);
            switch (availableCommands) {
                case PUT:
                    commands.putCartBeforeAnimals(s);
                    break;
                case BUY:
                    commands.buy(s.toUpperCase());
                    break;
                case UPGRADE:
                    commands.increase(s.toUpperCase());
                    break;
                case NEXT:
                    commands.nextDay();
                    break;
                case SEND:
                    commands.send(s);
                    break;
                case STATS:
                    commands.stats();
                    break;
                case HELP:
                    commands.help();
                    break;
                case SELL:
                    commands.sellObject(s);
                    break;
                case LIST:
                    commands.listAllObjectsOfAType();
                    break;
                case EXIT:
                    // TODO: 04.11.2021 Save game
                    System.out.println("Thank you for playing IPoAT. See you next time!");
                    return;
                case LOAD:
                    commands.loadTransportDevice(s);
                    break;
                case INVENTORY:
                    commands.getInventory(s);
                    break;
                case REMOVE:
                    commands.removeMediumFromTransport(s);
                    break;
                case PUFFER:
                    break;
                case BREED:
                    commands.getPuffer(s);
                    break;
                case ATTACH:
                    commands.attachTransport(s);
                    break;
                default:
                    System.out.println("Your command is no valid command. " +
                            "Please enter <HELP> or read the README file");
                    break;
            }


            //Do Events
            Random random = new Random();
            event.doSomethingGoodOrBad(random.nextInt(100), player);

        }

    }
}
