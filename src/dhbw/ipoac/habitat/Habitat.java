package dhbw.ipoac.habitat;

import dhbw.ipoac.birds.Bird;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Habitat {

    private final List<Bird> birds = new ArrayList<>();
    private int avaliableNests = 10;
    private final int relaxingFactor = 5;
    private int amountOfChargingStations = 0;
    private int costOfChargingStation = 500;
    private int dailyCost;
    private final Map<String, Bird> mapNameToBird = new HashMap<>();

    public Map<String, Bird> getMapNameToBird() {
        return mapNameToBird;
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

    public List<Bird> getBirds() {
        return birds;
    }

    public boolean isEnoughSpace() {
        return getAvaliableNests() >= getBirds().size() + 1;
    }

    public void AddBirdToHabitat(Bird bird){
        birds.add(bird);
        mapNameToBird.put(bird.getNameOfBird(), bird);
        System.out.println("A bird of type " + bird.getTypes() + " called " + bird.getNameOfBird() + " was added to the habitat");
    }

    public void IncreaseSizeOfHabitat(){
        avaliableNests++;
        System.out.println("The amount of avaliable nests has been increased to " + avaliableNests);
    }

    public int getAvaliableNests() {
        return avaliableNests;
    }

}
