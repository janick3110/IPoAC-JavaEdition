package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.ConsoleSoundGenerator;
import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.animals.mammals.Elephant;
import dhbw.ipoat.animals.mammals.Mammal;
import dhbw.ipoat.animals.mammals.Ox;
import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.habitat.Stall;
import dhbw.ipoat.medium.FloppyDisk;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.Bag;

public class CommandBuy extends CommandTemplate {

    public CommandBuy() {
        super();
    }

    @Override
    public void execute(String input) {
        input = input.toUpperCase();

        try {
            player.buy(input);
        } catch (OperationNotAllowedException e) {
            gui.out(e.getMessage());
        }
    }
}

