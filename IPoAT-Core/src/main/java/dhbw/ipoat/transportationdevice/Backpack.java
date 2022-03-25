package dhbw.ipoat.transportationdevice;

import dhbw.ipoat.player.Player;

public class Backpack extends TransportDevice {


    public Backpack(Player owner) {
        super(TransportationDeviceType.Backpack, 45, owner, 40);
    }
}
