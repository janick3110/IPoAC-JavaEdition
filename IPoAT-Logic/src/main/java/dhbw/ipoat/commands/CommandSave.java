package dhbw.ipoat.commands;

import dhbw.ipoat.savesystem.Savegame;

public class CommandSave extends CommandTemplate{
    @Override
    public void execute(String input) {
        Savegame.save(player);
    }
}
