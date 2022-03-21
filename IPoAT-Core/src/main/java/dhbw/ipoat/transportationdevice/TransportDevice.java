package dhbw.ipoat.transportationdevice;

public abstract class TransportDevice {

    TransportationDeviceType deviceType;

    public TransportDevice(TransportationDeviceType type) {
        this.deviceType = type;
    }

    public TransportationDeviceType getDeviceType() {
        return deviceType;
    }

}
