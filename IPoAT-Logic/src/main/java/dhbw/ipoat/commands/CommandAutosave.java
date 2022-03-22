package dhbw.ipoat.commands;

import dhbw.ipoat.savesystem.Savegame;

public class CommandAutosave extends CommandTemplate{

    public CommandAutosave() {
        super();
    }

    @Override
    public void execute(String input) {
        Savegame.autosave = !Savegame.autosave;
        if (Savegame.autosave){
            System.out.println("Autosave is now enabled");
        } else {
            System.out.println("Autosave is now disabled. Enter SAVE to save the game");
        }
    }
}
