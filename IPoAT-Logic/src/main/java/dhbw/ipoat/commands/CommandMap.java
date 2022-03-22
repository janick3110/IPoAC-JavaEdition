package dhbw.ipoat.commands;

import dhbw.ipoat.GameInterface;
import dhbw.ipoat.animals.*;
import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.animals.mammals.Elephant;
import dhbw.ipoat.animals.mammals.Mammal;
import dhbw.ipoat.animals.mammals.Ox;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.habitat.Stall;
import dhbw.ipoat.medium.FloppyDisk;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.savesystem.Savegame;
import dhbw.ipoat.transportationdevice.Bag;
import dhbw.ipoat.transportationdevice.Cart;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public class CommandMap {

    public GUI gui;

    private Map<CommandToken, CommandTemplate> commands = new HashMap<>();

    private final Player player;
    private Boolean autosave = true;

    public enum outputPossibilities{
        CONSOLE,
        SPEAKER
    }
    public static outputPossibilities mode = outputPossibilities.CONSOLE;



    public CommandMap(Player player, GUI gui, GameInterface game) {
        this.gui = gui;
        this.player = player;

        CommandTemplate.setPlayer(player);
        CommandTemplate.setGui(gui);
        CommandTemplate.setGameInterface(game);

        initializeMap();
    }

    public void execute(CommandToken commandToken, String input) {
        commands.get(commandToken).execute(input);
    }

    private void initializeMap() {
        commands.put(CommandToken.PUT, new CommandPut());
        commands.put(CommandToken.BUY, new CommandBuy());
        commands.put(CommandToken.UPGRADE, new CommandUpgrade());
        commands.put(CommandToken.NEXT, new CommandNextDay()) ;
        commands.put(CommandToken.SEND, new CommandSend());
        commands.put(CommandToken.STATS, new CommandStats());
        commands.put(CommandToken.HELP, new CommandHelp());
        commands.put(CommandToken.SELL, new CommandSellObject());
        commands.put(CommandToken.LIST, new CommandList());
        commands.put(CommandToken.EXIT, new CommandExit());
        commands.put(CommandToken.LOAD, new CommandLoad());
        commands.put(CommandToken.INVENTORY, new CommandInventory());
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
