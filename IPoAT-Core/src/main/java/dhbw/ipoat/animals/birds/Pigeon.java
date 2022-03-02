package dhbw.ipoat.animals.birds;

import dhbw.ipoat.animals.AnimalImplementation;
import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

public class Pigeon extends Bird {


    public Pigeon(Player player, AnimalImplementation animal) {
        super(player, 20, 1, 1, "Pigeon", 1, 0.5f, HabitatTypes.BIRDHOUSE, animal);
    }

    @Override
    public void MakeSound() {
        animalImplementation.MakeAnimalSound("Gurrr!");
    }

    public Pigeon(JSONObject object, Player player) {
        super(object,player);
    }
}
