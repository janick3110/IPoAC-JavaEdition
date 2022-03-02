package dhbw.ipoat;

import dhbw.ipoat.commands.CommandList;
import dhbw.ipoat.commands.Commands;
import dhbw.ipoat.events.Event;
import dhbw.ipoat.player.Player;


import java.util.Random;


public class Main {

    public static void main(String[] args) {

        GUI gui = new Terminal();


        gui.out("IP over Animal Transport - Tycoon");
        gui.out("Enter <HELP> for a list of available commands");
        gui.out("More information: https://github.com/janick3110/IPoAC-JavaEdition");

        Player player = new Player();
        Commands commands = new Commands(player);
        Event event = new Event();
        
        //LoadSaveGame.load();
        //Savegame.save(player);
        //System.out.println("Saved");


        while (true) {
            // Decode commands and main loop of the game
            String command;
            String s = gui.in();
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
                    case SOUND:
                        commands.playAnimalSound(s);
                        break;
                    case SWITCH:
                        commands.switchSoundOutput();
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
