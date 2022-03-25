package dhbw.ipoat.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandHelp extends CommandTemplate{

    private final List<String> helpDescriptions = new ArrayList<>();

    public CommandHelp() {
        super();
    }

    @Override
    public void execute(String input) {
        generateDescriptions();
        gui.out("##################HELP##################");
        for (int i = 0; i < CommandToken.values().length; i++) {
            gui.out(CommandToken.values()[i].toString() + " \n" + helpDescriptions.get(i));
        }
        gui.out("########################################");
    }

    private void generateDescriptions(){
        helpDescriptions.add("Attach a transport device to a animal - WARNING: Deprecated");
        helpDescriptions.add("Buy a animal, transport device, medium, computer or habitat");
        helpDescriptions.add("Increase size of object");
        helpDescriptions.add("Next day");
        helpDescriptions.add("Put animal en route");
        helpDescriptions.add("List your personal stats");
        helpDescriptions.add("Explains all available commands");
        helpDescriptions.add("Sell a object");
        helpDescriptions.add("List your inventory");
        helpDescriptions.add("Exit game");
        helpDescriptions.add("Put medium in transport device");
        helpDescriptions.add("Remove medium from transport device");
        helpDescriptions.add("Get the generated data of a computer");
        helpDescriptions.add("Breed two animals");
        helpDescriptions.add("Attach a transport device to a animal");
        helpDescriptions.add("Recruit new employee");
        helpDescriptions.add("Sack a employee");
        helpDescriptions.add("Save the game");
        helpDescriptions.add("Enable or disable autosave");
        helpDescriptions.add("Let animal make sound");
        helpDescriptions.add("Switch sound output");
    }
}
