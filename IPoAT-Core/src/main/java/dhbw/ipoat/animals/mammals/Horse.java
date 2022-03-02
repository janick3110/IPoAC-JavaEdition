package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.animals.AnimalImplementation;
import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;

public class Horse extends Mammal{

    public Horse(Player player, AnimalImplementation animal){
        super(player, 10, 5, 500, "Horse", 50, 0.4f, HabitatTypes.STALL, animal);

    }

    @Override
    public void MakeSound() {
        animalImplementation.MakeAnimalSound("Neigh!");
    }
}
