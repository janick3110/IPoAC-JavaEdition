package dhbw.ipoat.commands;

import java.util.HashMap;
import java.util.Map;


public class CommandMap {

    public GUI gui;

    private static final Map<CommandToken, CommandTemplate> commands = new HashMap<>();

    private final Boolean autosave = true;

    public enum outputPossibilities{
        CONSOLE,
        SPEAKER
    }

    public static outputPossibilities mode = outputPossibilities.CONSOLE;

    public void execute(CommandToken commandToken, String input) {
        commands.get(commandToken).execute(input);
    }

    public static void initializeMap() {
        commands.put(CommandToken.PUT, new CommandPut());
        commands.put(CommandToken.BUY, new CommandBuy());
        commands.put(CommandToken.UPGRADE, new CommandUpgrade());
        commands.put(CommandToken.NEXT, new CommandNextDay());
        commands.put(CommandToken.SEND, new CommandSend());
        commands.put(CommandToken.STATS, new CommandStats());
        commands.put(CommandToken.HELP, new CommandHelp());
        commands.put(CommandToken.SELL, new CommandSellObject());
        commands.put(CommandToken.LIST, new CommandList());
        commands.put(CommandToken.EXIT, new CommandExit());
        commands.put(CommandToken.LOAD, new CommandLoad());
        commands.put(CommandToken.REMOVE, new CommandRemove());
        commands.put(CommandToken.PUFFER, new CommandPuffer());
        commands.put(CommandToken.BREED, new CommandBreed());
        commands.put(CommandToken.ATTACH, new CommandAttatch());
        commands.put(CommandToken.RECRUIT, new CommandRecruit());
        commands.put(CommandToken.SACK, new CommandSack());
        commands.put(CommandToken.SAVE, new CommandSave());
        commands.put(CommandToken.AUTOSAVE, new CommandAutosave());
        commands.put(CommandToken.SOUND, new CommandSound());
        commands.put(CommandToken.SWITCH, new CommandSwitch());
    }
}
