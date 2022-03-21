package dhbw.ipoat.animals.birds;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportationDeviceType;

import java.util.ArrayList;

public abstract class Bird extends Animal {

    public Bird(Player owner) {
        super(owner);
        allowedTransportationDevices = new ArrayList<>();
        allowedTransportationDevices.add(TransportationDeviceType.Bag);
    }


}
