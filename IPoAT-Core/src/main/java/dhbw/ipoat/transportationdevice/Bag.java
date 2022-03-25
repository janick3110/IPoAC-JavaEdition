package dhbw.ipoat.transportationdevice;

import dhbw.ipoat.player.Player;

public class Bag extends TransportDevice {


    public Bag(Player owner) {
        super(TransportationDeviceType.Bag, 30, owner, .5d);
    }
}
