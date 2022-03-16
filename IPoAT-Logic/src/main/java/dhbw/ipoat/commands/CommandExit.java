package dhbw.ipoat.commands;

import dhbw.ipoat.savesystem.Savegame;

public class CommandExit extends CommandTemplate{
    @Override
    public void execute(String input) {
        Savegame.save(player);
        System.out.println("Thank you for playing IPoAT. See you next time!");
    }
}
