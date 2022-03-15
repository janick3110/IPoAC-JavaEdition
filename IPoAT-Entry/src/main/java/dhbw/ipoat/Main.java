package dhbw.ipoat;

import dhbw.ipoat.animals.AudioSoundGenerator;
import dhbw.ipoat.commands.CommandMap;
import dhbw.ipoat.commands.CommandToken;
import dhbw.ipoat.events.Event;
import dhbw.ipoat.player.Player;


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
            String command;
            String s = gui.in();
            try {
                command = s.toUpperCase().substring(0, s.indexOf(" "));
            } catch (StringIndexOutOfBoundsException e) {
                command = s.toUpperCase();
            }
            try {
                CommandToken availableCommands = CommandToken.valueOf(command);




                        System.out.println("Your command is no valid command. " +
                                "Please enter <HELP> or read the README file");




                //Do Events
                Random random = new Random();
                event.doSomethingGoodOrBad(random.nextInt(100), player);

                if (commandMap.getAutosave()) {
                    commandMap.save();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Your command is no valid command. " +
                        "Please enter <HELP> or read the README file");
            }





        }

    }
}
