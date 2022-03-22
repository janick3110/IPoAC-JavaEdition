package dhbw.ipoat.transportationdevice;

import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;

public abstract class TransportDevice extends Buyable {

    TransportationDeviceType deviceType;

    public TransportDevice(TransportationDeviceType type, int price, Player owner) {
        super(price, owner);
        this.deviceType = type;
    }

    public TransportationDeviceType getDeviceType() {
        return deviceType;
    }

}
