package dhbw.ipoac.animals.mammals;

import dhbw.ipoac.animals.Animal;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.Backpack;

public class Mammal extends Animal {

    private Backpack backpack;

    public Mammal(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability);
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
