package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.mammals.Mammal;
import dhbw.ipoat.transportationdevice.Cart;

import java.util.ArrayList;
import java.util.List;

public class CommandPut extends CommandTemplate{

    public CommandPut() {
        super();
    }

    @Override
    public void execute(String input) {
        if (player.getTransportDict().containsKey(input.substring(16))) {
            if (player.getTransportDict().get(input.substring(16)) instanceof Cart) {
                int maxAnimals = ((Cart) player.getTransportDict().get(input.substring(16))).getAnimalCount();
                int counter = 0;
                List<Mammal> listAnimals = new ArrayList<>();
                for (Animal a : player.getAllAnimals()
                ) {
                    if (a instanceof Mammal && counter < maxAnimals) {
                        listAnimals.add((Mammal) a);
                    }
                }
                ((Cart) player.getTransportDict().get(input.substring(10))).putAnimalsInFront(listAnimals);
            }
        }
    }
}
