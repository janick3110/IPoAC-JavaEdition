package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportationDeviceType;

import java.util.ArrayList;

public abstract class Mammal extends Animal {

    public Mammal(Player owner) {
        super(owner);
        allowedTransportationDevices = new ArrayList<>();
        allowedTransportationDevices.add(TransportationDeviceType.Backpack);
        allowedTransportationDevices.add(TransportationDeviceType.Cart);
    }

}
