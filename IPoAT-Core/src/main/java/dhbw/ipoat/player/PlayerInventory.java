package dhbw.ipoat.player;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerInventory {


    private ArrayList<Habitat> habitats = new ArrayList<>();
    private ArrayList<TransportDevice> transportDevices = new ArrayList<>();
    private ArrayList<Medium> mediums = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();

    private HashMap<String, Animal> animalsByName = new HashMap<>();

    public void putIn(Animal animal) {
        animals.add(animal);
    }

    public void putIn(Medium medium) {
        mediums.add(medium);
    }

    public void putIn(TransportDevice transportDevice) {
        transportDevices.add(transportDevice);
    }

    public void putIn(Habitat habitat) {
        habitats.add(habitat);
    }
}
