package dhbw.ipoat.transportationdevice;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class TransportDevice extends Buyable {

    TransportationDeviceType deviceType;
    private double currentLoad;
    private double maxLoad;
    private List<Medium> media;

    public TransportDevice(TransportationDeviceType type, int price, Player owner, double maxLoad) {
        super(price, owner);
        this.deviceType = type;
        this.maxLoad = maxLoad;
        media = new ArrayList<>();
    }

    public TransportationDeviceType getDeviceType() {
        return deviceType;
    }

    @Override
    public void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getTransportDevices().add(this);
    }

    @Override
    public int calculateSellValue(){
        return (int) (price * 0.85f);
    }

    @Override
    public void removeThisObject() {
        owner.getInventory().getTransportDevices().remove(this);
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public JSONObject generateJSONFromObject(){
        JSONObject device = new JSONObject();

        device.put("Type", deviceType);
        device.put("currentLoad", currentLoad);
        device.put("mediaInDevice", listOfMedia());
        return device;
    }

    private JSONArray listOfMedia(){
        JSONArray array = new JSONArray();

        for (Medium media:owner.getInventory().getMediums()
             ) {
            array.put(media.generateJSONFromObject());
        }

        return array;
    }
}
