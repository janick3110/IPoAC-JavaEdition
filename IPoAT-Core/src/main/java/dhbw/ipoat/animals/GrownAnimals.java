package dhbw.ipoat.animals;

import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportDevice;
import org.json.JSONObject;

public abstract class GrownAnimals extends Animal {

    protected int cost;
    protected boolean home;
    protected boolean delivering;
    protected int breedingCooldown;
    protected TransportDevice transport;
    protected AnimalImplementation animalImplementation;

    public GrownAnimals(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability, HabitatTypes types) {
        super(player, maxAge, speed, cost, type, maxWeight, deathProbability, types);
        age = (int) (maxAge * 0.05f);
    }

    public GrownAnimals(BabyAnimals animal) {
        super(animal);

    }

    public abstract void MakeSound();

    public GrownAnimals(JSONObject object, Player player) {
        super(object,player);
    }


    public TransportDevice getTransport() {
        return transport;
    }

    public AnimalImplementation getAnimalImplementation() {
        return animalImplementation;
    }

    public void setAnimalImplementation(AnimalImplementation animalImplementation) {
        this.animalImplementation = animalImplementation;
    }
}
