package dhbw.ipoac.transportationdevice;

import dhbw.ipoac.animals.mammals.Mammal;
import dhbw.ipoac.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Cart extends TransportDevice {

    private List<Mammal> draughtAnimals = new ArrayList<>();
    private int sizeOfCart;
    private int wheelCount;
    private final int animalCount = 1;


    public Cart(Player player, int maxObjects, int cost, float weight) {
        super(player, maxObjects, cost, weight);


    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void putAnimalsInFront(List<Mammal> mammals) {
        draughtAnimals = mammals;
    }
}
