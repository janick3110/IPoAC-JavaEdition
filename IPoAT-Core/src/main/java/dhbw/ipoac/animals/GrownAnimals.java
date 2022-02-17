package dhbw.ipoac.animals;

import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.TransportDevice;
import org.json.JSONObject;

public class GrownAnimals extends Animal {

    protected int cost;
    protected boolean home;
    protected boolean delivering;
    protected int breedingCooldown;
    protected TransportDevice transport;

    public GrownAnimals(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability, HabitatTypes types) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability, types);
        age = (int) (maxAge * 0.05f);
    }

    public GrownAnimals(BabyAnimals animal) {
        super(animal);

    }

    public GrownAnimals(JSONObject object, Player player) {
        super(object,player);
    }


    public TransportDevice getTransport() {
        return transport;
    }
}
