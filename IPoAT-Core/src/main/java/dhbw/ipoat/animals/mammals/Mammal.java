package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportationDeviceType;

import java.util.ArrayList;

public abstract class Mammal extends Animal {

    public Mammal(Player owner, int price) {
        super(owner, price);
        allowedTransportationDevices = new ArrayList<>();
        allowedTransportationDevices.add(TransportationDeviceType.Backpack);
        allowedTransportationDevices.add(TransportationDeviceType.Cart);
    }

}
