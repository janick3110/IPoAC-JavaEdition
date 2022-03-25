package dhbw.ipoat.gameplay;

import dhbw.ipoat.GameInterface;
import dhbw.ipoat.commands.CommandMap;
import dhbw.ipoat.commands.CommandToken;
import dhbw.ipoat.commands.GUI;
import dhbw.ipoat.events.Event;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.savesystem.Savegame;

import java.util.Random;

public class Game implements GameInterface {


    private boolean running = true;

    private final Player player;
    private int days;
    private GUI gui;

    private CommandMap commandMap;
    private Event event;

    public Game(GUI gui) {
        days = 0;
        this.gui = gui;
        this.player = new Player(gui.in("Enter Player Name"));

        commandMap = new CommandMap(player, gui, this);
        event = new Event(player);


        gui.out("IP over Animal Transport - Tycoon");
        gui.out("Enter <HELP> for a list of available commands");
        gui.out("More information: https://github.com/janick3110/IPoAC-JavaEdition");

        while (isRunning()){
            run();
        }

    }

    public void run() {

        String[] argument = getArgument();

        try {
            CommandToken availableCommands = CommandToken.valueOf(argument[0]);

            if (argument.length == 1) {
                commandMap.execute(availableCommands, null);
            } else if (argument.length == 2) {
                commandMap.execute(availableCommands, argument[1]);
            } else if (argument.length == 3) {
                commandMap.execute(availableCommands, argument[1] + " " + argument[2]);
            }

            //Do Events
            Random random = new Random();
            event.doSomethingGoodOrBad(random.nextInt(100));

            if (Savegame.autosave) {
                Savegame.save(player);
            }

        } catch (IllegalArgumentException e) {
            gui.out("Your argument is no valid argument. " +
                    "Please enter <HELP> or read the README file");
        }

    }

    private String[] getArgument() {
        String[] argument;
        String input = gui.in();


        argument = input.split(" ");
        argument[0] = argument[0].toUpperCase();
        return argument;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }


    @Override
    public int days() {
        return days;
    }

    @Override
    public void running(boolean gameState){
        running = gameState;
    }
}
