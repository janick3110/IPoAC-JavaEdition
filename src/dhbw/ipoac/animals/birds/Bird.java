package dhbw.ipoac.animals.birds;

import dhbw.ipoac.animals.Animal;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.Bag;

public class Bird extends Animal {

    private Bag bag;

    public Bird(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability);

    }

    public Bag getBag() {
        return bag;
    }
}
