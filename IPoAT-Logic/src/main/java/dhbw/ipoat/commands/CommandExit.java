package dhbw.ipoat.commands;

import dhbw.ipoat.savesystem.Savegame;

public class CommandExit extends CommandTemplate{

    public CommandExit() {
        super();
    }

    @Override
    public void execute(String input) {
        Savegame.save(player, game);
        game.running(false);
        System.out.println("Thank you for playing IPoAT. See you next time!");
    }
}
