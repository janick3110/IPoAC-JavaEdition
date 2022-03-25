package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.animals.AnimalImplementation;
import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;

public class Ox extends Mammal {

    public Ox(Player owner) {
        super(owner, 80);
    }

    @Override
    public String makeSound() {
        return "Mooooooooh!";
    }
}
