package dhbw.ipoac;

import dhbw.ipoac.commands.CommandList;
import dhbw.ipoac.commands.Commands;
import dhbw.ipoac.encrypt.Encryption;
import dhbw.ipoac.events.Event;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.savesystem.LoadSaveGame;
import dhbw.ipoac.savesystem.Savegame;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        System.out.println("IP over Animal Transport - Tycoon");
        System.out.println("Enter <HELP> for a list of available commands");
        System.out.println("More information: https://github.com/janick3110/IPoAC-JavaEdition");
        Player player = new Player();
        Commands commands = new Commands(player);
        Event event = new Event();
        
        //LoadSaveGame.load();
        //Savegame.save(player);
        //System.out.println("Saved");

        Scanner in = new Scanner(System.in);
        String s;

        while (in.hasNextLine()) {
            s = in.nextLine();
            // Decode commands and main loop of the game
            String command;
            try {
                command = s.toUpperCase().substring(0, s.indexOf(" "));
            } catch (StringIndexOutOfBoundsException e) {
                command = s.toUpperCase();
            }
            try {
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
                        commands.save();
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
                        commands.getPuffer(s);
                        break;
                    case BREED:
                        commands.breed(s);
                        break;
                    case ATTACH:
                        commands.attachTransport(s);
                        break;
                    case RECRUIT:
                        commands.recruitNewEmployee();
                        break;
                    case SACK:
                        commands.sackEmployee(s);
                        break;
                    case SAVE:
                        commands.save();
                        break;
                    case AUTOSAVE:
                        commands.setAutosave();
                        break;
                    default:
                        System.out.println("Your command is no valid command. " +
                                "Please enter <HELP> or read the README file");
                        break;


                }
                //Do Events
                Random random = new Random();
                event.doSomethingGoodOrBad(random.nextInt(100), player);

                if (commands.getAutosave()) {
                    commands.save();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Your command is no valid command. " +
                        "Please enter <HELP> or read the README file");
            }





        }

    }
}