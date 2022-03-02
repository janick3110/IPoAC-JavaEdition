package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.animals.BabyAnimals;
import dhbw.ipoat.animals.GrownAnimals;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.Backpack;

public class Mammal extends GrownAnimals {

    private Backpack backpack;
    protected Employee rider;

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
