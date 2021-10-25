package dhbw.ipoac.transportationdevice;

import dhbw.ipoac.animals.Animal;
import dhbw.ipoac.medium.Medium;
import dhbw.ipoac.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransportDevice {
    protected List<Medium> mediaInDevice = new ArrayList<>();
    protected int maxObjects;
    protected int cost;
    protected int costForUpgrade;
    protected float weight;
    protected float probabilityOfFailure;
    protected String uuid;
    protected Player player;
    protected String type;

    public TransportDevice(Player player, int maxObjects, int cost, float weight) {
        this.maxObjects = maxObjects;
        this.cost = cost;
        this.weight = weight;
        this.probabilityOfFailure = probabilityOfFailure;


        uuid = UUID.randomUUID().toString().substring(0, 8);
        while (player.getAllTransportDevices().containsKey(uuid)) {
            uuid = UUID.randomUUID().toString().substring(0, 8);
        }


        costForUpgrade = (int) (cost * 1.2f);
    }

    public String getType() {
        return type;
    }

    public int getMaxObjects() {
        return maxObjects;
    }

    public List<Medium> getMediaInDevice() {
        return mediaInDevice;
    }

    public void load(Player player, Animal animal) {
        float currentWeight = 0;
        List<Medium> allMedia = player.getAvaliableMedia();
        for (int i = 0; i < allMedia.size(); i++) {
            if (allMedia.get(i).getWeight() + currentWeight <= animal.getMaxWeight()) {
                currentWeight += allMedia.get(i).getWeight();
                System.out.println(animal.getName() + " was loaded with " + allMedia.get(i).getNameOfMedium());
                mediaInDevice.add(allMedia.get(i));
            }
        }
        for (Medium m : mediaInDevice
        ) {
            player.getAvaliableMedia().remove(m);
        }

        if (mediaInDevice.size() == 0) {
            System.out.println("No fitting drive is avaliable");
        }

    }

    public void increaseSize() {
        maxObjects += 4;
        costForUpgrade = (int) (costForUpgrade * 1.2f);
    }

    protected void notifyPlayer(String msg) {
        System.out.println(msg);
    }

    public TransportDevice getTransportDevice() {
        return null;
    }
}
