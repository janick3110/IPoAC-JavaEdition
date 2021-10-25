package dhbw.ipoac.habitat;

import dhbw.ipoac.animals.birds.BirdOld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Habitat {

    private final List<BirdOld> birdOlds = new ArrayList<>();
    private int avaliableNests = 10;
    private int costOfNewNest = 100;
    private final int relaxingFactor = 5;
    private int amountOfChargingStations = 0;
    private int costOfChargingStation = 500;
    private int dailyCost;
    private final Map<String, BirdOld> mapNameToBird = new HashMap<>();

    public Map<String, BirdOld> getMapNameToBird() {
        return mapNameToBird;
    }

    public int getCostOfNewNest() {
        return costOfNewNest;
    }

    public int getAmountOfChargingStations() {
        return amountOfChargingStations;
    }

    public int getCostOfChargingStation() {
        return costOfChargingStation;
    }

    public void setCostOfChargingStation(int costOfChargingStation) {
        this.costOfChargingStation = costOfChargingStation;
    }

    public int getRelaxingFactor() {
        return relaxingFactor;
    }

    public void increaseChargingStations() {
        amountOfChargingStations++;
        costOfChargingStation = (int) (costOfChargingStation * 1.2f);
    }

    public List<BirdOld> getBirds() {
        return birdOlds;
    }

    public boolean isEnoughSpace() {
        return getAvaliableNests() >= getBirds().size() + 1;
    }

    public void AddBirdToHabitat(BirdOld birdOld) {
        birdOlds.add(birdOld);
        mapNameToBird.put(birdOld.getNameOfBird(), birdOld);
        System.out.println("A bird of type " + birdOld.getTypes() + " called " + birdOld.getNameOfBird() + " was added to the habitat");
    }

    public void IncreaseSizeOfHabitat() {
        avaliableNests++;
        costOfNewNest = (int) (costOfNewNest * 1.2f);
        System.out.println("The amount of avaliable nests has been increased to " + avaliableNests);
    }

    public void decreaseNests(int difference) {
        if (avaliableNests - difference > 0) {
            avaliableNests -= difference;

            int birdsToBeKilled = difference;
            int currentBird = birdOlds.size();
            for (int i = 0; i < currentBird; i++) {
                if (birdOlds.get(currentBird).isHome()) {
                    birdOlds.get(0).killBird();
                }
            }
            if (birdsToBeKilled > 0) {
                for (int i = 0; i < birdsToBeKilled; i++) {
                    birdOlds.get(0).killBird();
                }
            }
        }
    }

    public int getAvaliableNests() {
        return avaliableNests;
    }

}
