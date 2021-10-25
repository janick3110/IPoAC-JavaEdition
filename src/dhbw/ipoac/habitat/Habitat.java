package dhbw.ipoac.habitat;

import dhbw.ipoac.animals.Animal;
import dhbw.ipoac.animals.birds.Bird;
import dhbw.ipoac.player.Player;

import java.util.*;

public class Habitat {

    protected final List<Bird> birdOlds = new ArrayList<>();
    protected int avaliableNests = 10;
    protected int costOfNewNest = 100;
    protected int maxCapacity;
    protected final int relaxingFactor = 5;
    protected int amountOfChargingStations = 0;
    protected int costOfChargingStation = 500;
    protected int dailyCost;
    private final Map<String, Animal> mapNameToBird = new HashMap<>();
    protected List<Animal> animalsInHabitat = new ArrayList<>();
    protected String nameOfHabitat;
    protected Player player;
    protected String type;


    public Habitat(Player player, int avaliableNests, int costOfNewNest, int dailyCost, String type) {
        this.avaliableNests = avaliableNests;
        this.costOfNewNest = costOfNewNest;
        this.dailyCost = dailyCost;
        this.player = player;
        this.type = type;

        nameOfHabitat = UUID.randomUUID().toString().substring(0, 8);
        while (player.getHabitatDict().containsKey(nameOfHabitat)) {
            nameOfHabitat = UUID.randomUUID().toString().substring(0, 8);
        }
    }

    public int getDailyCost() {
        return dailyCost;
    }

    public String getType() {
        return type;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Animal> getAnimalsInHabitat() {
        return animalsInHabitat;
    }


    public Map<String, Animal> getMapNameToBird() {
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

    public List<Animal> getAnimals() {
        return animalsInHabitat;
    }


    public boolean isEnoughSpace() {
        return getAvaliableNests() >= getAnimals().size() + 1;
    }

    public void addAnimalToHabitat(Animal animal) {
        animalsInHabitat.add(animal);
        mapNameToBird.put(animal.getName(), animal);
        System.out.println("A animal of type " + animal.getType() + " called " + animal.getName() + " was added to the habitat");
    }

    public void IncreaseSizeOfHabitat() {
        avaliableNests++;
        costOfNewNest = (int) (costOfNewNest * 1.2f);
        System.out.println("The amount of avaliable nests has been increased to " + avaliableNests);
    }

    public String getNameOfHabitat() {
        return nameOfHabitat;
    }


    public void decreaseNests(int difference) {
        if (avaliableNests - difference > 0) {
            avaliableNests -= difference;

            int birdsToBeKilled = difference;
            int currentBird = birdOlds.size();
            for (int i = 0; i < currentBird; i++) {
                if (birdOlds.get(currentBird).isHome()) {
                    birdOlds.get(0).killAnimal();
                }
            }
            if (birdsToBeKilled > 0) {
                for (int i = 0; i < birdsToBeKilled; i++) {
                    birdOlds.get(0).killAnimal();
                }
            }
        }
    }

    public int getAvaliableNests() {
        return avaliableNests;
    }

}
