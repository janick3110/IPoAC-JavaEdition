package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.employee.Occupations;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportationDeviceType;
import org.json.JSONObject;

import java.util.ArrayList;

public abstract class Mammal extends Animal {

    protected Employee rider;

    public Mammal(Player owner, int price, int lifeExpectancy) {
        super(owner, price, lifeExpectancy);
        allowedTransportationDevices = new ArrayList<>();
        allowedTransportationDevices.add(TransportationDeviceType.Backpack);
        allowedTransportationDevices.add(TransportationDeviceType.Cart);
    }

    public void setRider(Employee rider) {
        this.rider = rider;
        rider.setStatus(Occupations.RIDING);
    }

}
