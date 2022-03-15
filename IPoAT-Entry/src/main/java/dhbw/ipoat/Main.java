package dhbw.ipoat;

import dhbw.ipoat.animals.AudioSoundGenerator;
import dhbw.ipoat.commands.CommandMap;
import dhbw.ipoat.commands.CommandToken;
import dhbw.ipoat.events.Event;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.savesystem.Savegame;


import java.util.Random;


public class Main {
    static Player player = new Player();



    public static void main(String[] args) {

        GUI gui = new Terminal();

        gui.out("IP over Animal Transport - Tycoon");
        gui.out("Enter <HELP> for a list of available commands");
        gui.out("More information: https://github.com/janick3110/IPoAC-JavaEdition");


        CommandMap commandMap = new CommandMap(player);
        Event event = new Event();
        
        //LoadSaveGame.load();
        //Savegame.save(player);
        //System.out.println("Saved");


        while (true) {
            // Decode commands and main loop of the game
            String[] argument;
            String input = gui.in();



            argument = input.split(" ");
            argument[0] = argument[0].toUpperCase();

            try {
                CommandToken availableCommands = CommandToken.valueOf(argument[0]);

                if (argument.length == 1) {
                    commandMap.execute(availableCommands, null);
                } else if(argument.length == 2) {
                    commandMap.execute(availableCommands, argument[1]);
                } else if(argument.length == 3) {
                    commandMap.execute(availableCommands, argument[1] + " " + argument[2]);
                }

                //Do Events
                Random random = new Random();
                event.doSomethingGoodOrBad(random.nextInt(100), player);

                if (Savegame.autosave) {
                    Savegame.save(player);
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Your argument is no valid argument. " +
                        "Please enter <HELP> or read the README file");
            }





        }

    }
}
