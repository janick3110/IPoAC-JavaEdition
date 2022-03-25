package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.player.Player;

public class Horse extends Mammal {

    public Horse(Player owner) {
        super(owner, 60, 40);
    }

    @Override
    public String makeSound() {
        return "Neigh!";
    }
}
