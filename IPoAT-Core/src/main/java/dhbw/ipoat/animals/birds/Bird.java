package dhbw.ipoat.animals.birds;

import dhbw.ipoat.animals.AnimalImplementation;
import dhbw.ipoat.animals.BabyAnimals;
import dhbw.ipoat.animals.GrownAnimals;
import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.Bag;
import org.json.JSONObject;

public abstract class Bird extends GrownAnimals {

    private Bag bag;

    public Bird(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability, HabitatTypes types, AnimalImplementation animal) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability, types);
        animalImplementation = animal;
    }

    public Bird(BabyAnimals animals) {
        super(animals);

    }

    public Bird(JSONObject object, Player player) {
        super(object,player);
    }

    public Bag getBag() {
        return bag;
    }

    public static boolean doesThisAnimalExist(String type) {
        BirdList[] animals = BirdList.values();
        for (BirdList animal : animals) {
            if (animal.toString().equals(type)) {
                return true;
            }
        }
        return false;
    }
}
