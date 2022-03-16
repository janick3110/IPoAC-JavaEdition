package dhbw.ipoat.habitat;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

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
    protected int cost;
    protected HabitatTypes habitatTypes;

    public int getCost() {
        return cost;
    }

    public HabitatTypes getHabitatTypes() {
        return habitatTypes;
    }

    public Habitat(Player player, int avaliableNests, int costOfNewNest, int dailyCost, String type, int cost,int maxCapacity, HabitatTypes habitatTypes) {
        this.avaliableNests = avaliableNests;
        this.costOfNewNest = costOfNewNest;
        this.dailyCost = dailyCost;
        this.player = player;
        this.type = type;
        this.cost = cost;
        this.habitatTypes = habitatTypes;
        this.maxCapacity = maxCapacity;

        nameOfHabitat = UUID.randomUUID().toString().substring(0, 8);

    }

    public Habitat(JSONObject jsonObject, Player player){
        try {
            nameOfHabitat = jsonObject.getString("ID");
            this.avaliableNests = jsonObject.getInt("avaliableNests");
            this.costOfNewNest = jsonObject.getInt("costForNewNest");
            this.dailyCost = jsonObject.getInt("dailyCost");
            this.player = player;
            this.type = jsonObject.getString("Type");
            this.cost = jsonObject.getInt("costForBuying");
            this.habitatTypes = (HabitatTypes) jsonObject.get("Type");
            this.maxCapacity = jsonObject.getInt("maxCapacity");
        } finally {
            return;
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
        System.out.println("A animal of type " + animal.getTypeOfAnimal() + " called " + animal.getName() + " was added to the habitat");
    }

    public void IncreaseSizeOfHabitat() {
        avaliableNests++;
        costOfNewNest = (int) (costOfNewNest * 1.2f);
        //System.out.println("The amount of avaliable nests has been increased to " + avaliableNests);
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
