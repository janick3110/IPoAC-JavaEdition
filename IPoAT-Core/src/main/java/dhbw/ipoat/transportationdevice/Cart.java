package dhbw.ipoat.transportationdevice;

import dhbw.ipoat.animals.mammals.Mammal;
import dhbw.ipoat.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Cart extends TransportDevice {

    private List<Mammal> draughtAnimals = new ArrayList<>();
    private int sizeOfCart;
    private int wheelCount;
    private final int animalCount = 1;
    private boolean home = true;


    public Cart(Player player) {
        super(player, 10, 100, 1000, "Cart");


    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public List<Mammal> getDraughtAnimals() {
        return draughtAnimals;
    }

    public boolean isHome() {
        return home;
    }

    public void putAnimalsInFront(List<Mammal> mammals) {
        draughtAnimals = mammals;
    }
}
