package dhbw.ipoat.transportationdevice;

import dhbw.ipoat.player.Player;

public class Cart extends TransportDevice {


    public Cart(Player owner) {
        super(TransportationDeviceType.Cart, 50, owner, 500);
    }
}
