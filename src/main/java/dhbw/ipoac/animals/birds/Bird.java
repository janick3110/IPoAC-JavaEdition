package dhbw.ipoac.animals.birds;

import dhbw.ipoac.animals.BabyAnimals;
import dhbw.ipoac.animals.GrownAnimals;
import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.Bag;

public class Bird extends GrownAnimals {

    private Bag bag;

    public Bird(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability, HabitatTypes types) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability, types);

    }

    public Bird(BabyAnimals animals) {
        super(animals);

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
