package dhbw.ipoat.player;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerInventory {


    private final ArrayList<Habitat> habitats = new ArrayList<>();
    private final ArrayList<TransportDevice> transportDevices = new ArrayList<>();
    private final ArrayList<Medium> mediums = new ArrayList<>();
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final ArrayList<Computer> computers = new ArrayList<>();

    private final HashMap<String, Animal> animalsByName = new HashMap<>();

    public void putIn(Animal animal) {
        animals.add(animal);
    }

    public void putIn(Medium medium) {
        mediums.add(medium);
    }

    public void putIn(TransportDevice transportDevice) {
        transportDevices.add(transportDevice);
    }

    public void putIn(Habitat habitat) {
        habitats.add(habitat);
    }

    public void putIn(Computer computer){
        computers.add(computer);
    }

    public void putIn(Employee employee){
        employees.add(employee);
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public ArrayList<TransportDevice> getTransportDevices() {
        return transportDevices;
    }

    public ArrayList<Medium> getMediums() {
        return mediums;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public HashMap<String, Animal> getAnimalsByName() {
        return animalsByName;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }


}
