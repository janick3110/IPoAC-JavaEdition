package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.transportationdevice.Cart;

public class CommandSend extends CommandTemplate{

    public CommandSend() {
        super();
    }

    @Override
    public void execute(String input) {
        Animal animalToSend = player.getInventory().getAnimalsByName().get(input);
    }
}
