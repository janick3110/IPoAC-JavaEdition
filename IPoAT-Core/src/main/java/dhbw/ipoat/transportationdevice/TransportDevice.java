package dhbw.ipoat.transportationdevice;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;

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

    public TransportDevice(Player player, int maxObjects, int cost, float weight, String type) {
        this.maxObjects = maxObjects;
        this.cost = cost;
        this.weight = weight;
        this.probabilityOfFailure = probabilityOfFailure;
        this.type = type;
        this.player = player;

        uuid = UUID.randomUUID().toString().substring(0, 8);
        while (player.getAllTransportDevices().containsKey(uuid)) {
            uuid = UUID.randomUUID().toString().substring(0, 8);
        }


        costForUpgrade = (int) (cost * 1.2f);
    }

    public String getUuid() {
        return uuid;
    }

    public String getType() {
        return type;
    }

    public int getMaxObjects() {
        return maxObjects;
    }

    public void attachDevice(Animal animal) {
        animal.setDevice(this);
    }

    public float calculateWeight() {
        float sum = 0;
        for (Medium m : mediaInDevice
        ) {
            sum += m.getWeight();
        }
        return sum;
    }

    public void removeObject(Medium object) {
        player.getMediumDict().put(object.getId(), object);
        mediaInDevice.remove(object);
    }

    public List<Medium> getMediaInDevice() {
        return mediaInDevice;
    }

    /**
     * Load a transport device with the stuff the player owns
     *
     * @param player the player
     * @param animal the animal which is loaded
     */
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

    public void putMedium(Medium medium) {
        if (maxObjects >= mediaInDevice.size() + 1) {
            player.getMediumDict().remove(medium.getId(), medium);
            mediaInDevice.add(medium);
            System.out.println(medium.getId() + " was put into " + uuid);
        }

    }

    public void unloadData() {
        for (Medium m : mediaInDevice
        ) {
            player.getAvaliableMedia().add(m);
        }
        mediaInDevice.clear();
    }

    public float calculateData() {
        float sum = 0;

        for (Medium m : mediaInDevice
        ) {
            sum += m.getData();
        }
        return sum;
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