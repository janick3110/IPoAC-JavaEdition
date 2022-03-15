package dhbw.ipoat.commands;

import dhbw.ipoat.player.Player;

public abstract class CommandTemplate {


    protected static Player player;

    public abstract void execute(String input);

}
