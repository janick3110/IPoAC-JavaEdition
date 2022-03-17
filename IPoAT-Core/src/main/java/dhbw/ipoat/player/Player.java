package dhbw.ipoat.player;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    private List<Medium> avaliableMedia = new ArrayList<>();
    private int day;
    private String name;
    private float money = 1000;
    private float amountDataTransmitted = 0;
    private final HashMap<String, TransportDevice> allTransportDevices = new HashMap<>();
    private final HashMap<String, Habitat> habitatDict = new HashMap<>();
    private final HashMap<String, TransportDevice> transportDict = new HashMap<>();
    private final HashMap<String, Medium> mediumDict = new HashMap<>();
    private final HashMap<String, Computer> computerDict = new HashMap<>();
    private final HashMap<String, Employee> employeeDict = new HashMap<>();

    public HashMap<String, Employee> getEmployeeDict() {
        return employeeDict;
    }

    public HashMap<String, Medium> getMediumDict() {
        return mediumDict;
    }

    public HashMap<String, Computer> getComputerDict() {
        return computerDict;
    }

    public HashMap<String, TransportDevice> getTransportDict() {
        return transportDict;
    }

    public String getName() {
        return name;
    }



    public Player() {
        BirdHouse startHouse = new BirdHouse(this);
        habitatDict.put(startHouse.getNameOfHabitat(),startHouse);
        Computer pc = new Computer();
        computerDict.put(pc.getNameOfPc(), pc);
    }

    public HashMap<String, Habitat> getHabitatDict() {
        return habitatDict;
    }



    public HashMap<String, TransportDevice> getAllTransportDevices() {
        return allTransportDevices;
    }

    public float getAmountDataTransmitted() {
        return amountDataTransmitted;
    }

    public void setAmountDataTransmitted(float amountDataTransmitted) {
        this.amountDataTransmitted = amountDataTransmitted;
    }

    public void moneyTransactions(float transaction) {
        money += transaction;
        System.out.println("Current account balance: " + money);
    }

    public List<Medium> getAvaliableMedia() {
        return avaliableMedia;
    }

    public void setAvaliableMedia(List<Medium> avaliableMedia) {
        this.avaliableMedia = avaliableMedia;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void NextDay() {
        day++;
        System.out.println("Heute ist Tag " + day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Helping function for checking if a name already exists
     *
     * @param nameToCheck the name which needs to be checked
     * @return true if name is already used
     */
    public boolean checkForDoubleNames(String nameToCheck) {
        for (Habitat h : habitatDict.values()
        ) {
            for (Animal a : h.getAnimals()
            ) {
                if (a.getName().equals(nameToCheck)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void unloadData(float size) {
        amountDataTransmitted += size;
    }

    /**
     * Helping function for returning all animals the player owns
     *
     * @return all animals
     */
    public List<Animal> getAllAnimals() {
        List<Animal> animalList = new ArrayList<>();

        for (Habitat h : habitatDict.values()
        ) {
            animalList.addAll(h.getAnimals());
        }
        return animalList;
    }

    public TransportDevice getTransportDeviceWithName(String id) {
        for (TransportDevice device : transportDict.values()
        ) {
            if (device.getUuid().equals(id)) {
                return device;
            }
        }
        return null;
    }

    public void addAnimalToHabitat(Animal animal) {

        for (Habitat h : habitatDict.values()
        ) {
            if (h.isEnoughSpace() && animal.getHabitatType().equals(h.getHabitatTypes())) {
                h.addAnimalToHabitat(animal);
                return;
            }
        }

    }

    public void removeAnimalFromArchives(Animal animal) {
        for (Habitat h : habitatDict.values()
        ) {
            h.getAnimals().remove(animal);
        }
    }


    /**
     * Helping function for getting a medium with a certain name
     *
     * @param id ID of the medium
     * @return ID with the name
     */
    public Medium getMediumWithName(String id) {
        for (Medium medium : mediumDict.values()
        ) {
            if (medium.getId().equals(id)) {
                return medium;
            }
        }
        return null;
    }

    /**
     * Helping function for getting an animal with a given name
     *
     * @param name name of the animal
     * @return the animal with the name
     */
    public Animal getAnimalWithName(String name) {
        for (Animal animal : getAllAnimals()
        ) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

}
