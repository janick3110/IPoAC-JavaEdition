package dhbw.ipoac.transportationdevice;

import dhbw.ipoac.animals.Animal;
import dhbw.ipoac.medium.Medium;
import dhbw.ipoac.player.Player;

import java.util.ArrayList;
import java.util.List;

public class TransportDevice {
    protected List<Medium> mediaInDevice = new ArrayList<>();
    protected int maxObjects;
    protected int cost;
    protected float weight;

    public TransportDevice(int maxObjects, int cost, float weight) {
        this.maxObjects = maxObjects;
        this.cost = cost;
        this.weight = weight;
    }

    public List<Medium> getMediaInDevice() {
        return mediaInDevice;
    }

    public void load(float maxCargo, Player player, Animal animal) {
        float currentWeight = 0;
        List<Medium> allMedia = player.getAvaliableMedia();
        for (int i = 0; i < allMedia.size(); i++) {
            if (allMedia.get(i).getWeight() + currentWeight <= maxCargo) {
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
}
