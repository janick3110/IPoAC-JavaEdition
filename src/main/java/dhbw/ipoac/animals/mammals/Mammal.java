package dhbw.ipoac.animals.mammals;

import dhbw.ipoac.animals.BabyAnimals;
import dhbw.ipoac.animals.GrownAnimals;
import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.Backpack;

public class Mammal extends GrownAnimals {

    private Backpack backpack;

    public Mammal(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability, HabitatTypes types) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability, types);
    }

    public Mammal(BabyAnimals animals) {
        super(animals);

    }



    public Backpack getBackpack() {
        return backpack;
    }

    public static boolean doesThisAnimalExist(String type) {
        MammalList[] animals = MammalList.values();
        for (MammalList animal : animals) {
            if (animal.toString().equals(type)) {
                return true;
            }
        }
        return false;
    }

}
