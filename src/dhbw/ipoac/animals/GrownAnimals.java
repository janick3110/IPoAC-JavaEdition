package dhbw.ipoac.animals;

import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;

public class GrownAnimals extends Animal {

    protected int cost;
    protected boolean home;
    protected boolean delivering;
    protected int breedingCooldown;

    public GrownAnimals(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability, HabitatTypes types) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability, types);
    }

    public GrownAnimals(BabyAnimals animal) {
        super(animal);

    }
}
